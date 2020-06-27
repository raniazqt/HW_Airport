package com.hw.airport.service;

import java.util.List;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.config.AppContainer;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.exception.MissingBookingException;
import com.hw.airport.exception.MissingFlightException;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Booking.BookingStatus;
import com.hw.airport.model.BookingCharge;
import com.hw.airport.model.Flight;
import com.hw.airport.model.FlightSettings;

public class CheckInSvcImpl implements CheckInSvc {

	private BookingSvc bookingSvc = AppContainer.getBookingSvc();
	private FlightSvc flightSvc = AppContainer.getFlightSvc();
	private BaggageSvc baggageSvc = AppContainer.getBaggageSvc();

	/**
	 * @param lastName last name of the passenger.
	 * @param bookingRef the provided booking reference. this is checked with the bookings file.
	 * @return returns a booking class containing the booking details.
	 * @throws HWAirportException throws a missing booking exception if there was no booking found.
	 */
	@Override
	public Booking retrieveBookingByCodeAndLastName(String lastName, String bookingRef) throws HWAirportException {
		Booking booking = bookingSvc.findBookingByLastNameAndRefCode(lastName, bookingRef);
		if (null == booking) {
			throw new MissingBookingException();
		}
		return booking;
	}

	/**
	 * @param charge a class containing empty chanrges to be filled in for the of the specified booking.
	 * @return the extra charges for the passenger (weight or volume).
	 * @throws HWAirportException throws missing flight exception if no flight is found for the given booking.
	 */
	@Override
	public BookingCharge calculateXtraChargeForPasngr(BookingCharge charge) throws HWAirportException {
		Booking booking = this.retrieveBookingByCodeAndLastName(
				charge.getLastName(), charge.getRefCode());
		Flight flight = flightSvc.getFlightByCode(booking.getFlightCode().toLowerCase());
		if(null == flight) {
			throw new MissingFlightException(booking.getFlightCode(), "checkin service");
		}
		double volume = charge.getLength() * charge.getWidth() * charge.getDepth();
		if (volume > flight.getMaxBagVolume()) {
			charge.setVolumeCharge(flight.getXtraVolumeCharge());
		}
		if (charge.getWeight() > flight.getMaxBagWeight()) {
			charge.setWeightCharge(flight.getXtraWghtChargePerKg() * 
					charge.getWeight() - flight.getMaxBagWeight());
		}
		return charge;
	}

	/**
	 * @param lastName last name of passenger requesting a checkin.
	 * @param bookingRef bookingRef of passenger requesting a checkin.
	 * @return a boolean indicating if it's possible to checkin the pending passenger, this is true ONLY if all the following conditions are true (maxVolume of flight not exceeded,
	 * maxWeight of flight not exceeded, maxPassengers per flight not exceeded, pending passenger has not previously checked in)
	 * @throws HWAirportException missing booking exception if a booking is not found per the bookingRef and last name.
	 */
	@Override
	public boolean canCheckIn(String lastName, String bookingRef) throws HWAirportException {
		Booking pendingBooking = bookingSvc.findBookingByLastNameAndRefCode(lastName, bookingRef);

		if(pendingBooking == null){
			throw new MissingBookingException();
		}
		boolean isNotCheckedIn = (pendingBooking.getCheckInStatus()==BookingStatus.NOT_CHECKED_IN);

		boolean flightSatus = this.isMaxFltCpctyVolWghtStsExceeded(pendingBooking.getFlightCode());
		return !flightSatus && isNotCheckedIn;	
	}

	public boolean isMaxFltCpctyVolWghtStsExceeded(String flightCd) {
		double currentFlightBagVolume;
		boolean isMaxVolumeExceeded = false;
		boolean isMaxWeightExceeded = false;
		boolean isMaxPassengerCountExceeded = false;
		try {
			currentFlightBagVolume = baggageSvc.getTheTotalBagVolumesOnFlight(flightCd);

			double currentFlightBagWeight = baggageSvc.getTheTotalBagWeightOnFlight(flightCd);
			int currentFlightPassengerCount = flightSvc.getPassengerCountForFlight(flightCd);

			isMaxVolumeExceeded = flightSvc.isMaxVolumeExceededForFlight(flightCd, currentFlightBagVolume);
			isMaxWeightExceeded = flightSvc.isMaxWeightExceededForFlight(flightCd, currentFlightBagWeight);
			isMaxPassengerCountExceeded = flightSvc.isMaxPassengerCountExceededForFlight(flightCd, currentFlightPassengerCount);
		} catch (HWAirportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return !isMaxVolumeExceeded && !isMaxWeightExceeded && !isMaxPassengerCountExceeded;	

	}

	/**
	 * @param lastName last name of the passenger.
	 * @param bookingRef the provided booking reference. this is checked with the bookings file.
	 */
	@Override
	public boolean doCheckIn(Booking passenger) {
		List<FlightSettings> activeFlights = AirportSimulator.getActiveFlights();
		String flightCd = passenger.getFlightCode();
		if (isFlightBoarding(flightCd)) {
			
		}
			return false;
		//check if the flight is in the active flight list
		//check if the crnt time is within the flight boarding time 
		//check if the flight capacity, volume, passenger count were not exceeded
		//check the passenger details
		//check passenger baggages
		//calculate any extra charges



	}

	private boolean isFlightBoarding(String flightCd) {
		List<FlightSettings> activeFlights = AirportSimulator.getActiveFlights();
		boolean  found = false;

		for(FlightSettings flight : activeFlights){
			if (flight.getFlightCd().equalsIgnoreCase(flightCd)) {
				found = true;
			}
		}
		return found;
	}

	/**
	 * @param booking the booking that we will update.
	 * @return the check in status (true or false if sucessfully updated).
	 */
	@Override
	public boolean confirmCheckin(Booking booking, BookingCharge bookingChg) {
		boolean status = false;
		try {
			status = bookingSvc.updateBookingStatus(booking, bookingChg);
		} catch (HWAirportException e) {
			status = false;
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return status;
	}

}
