package com.hw.airport.service;

import com.hw.airport.config.AppContainer;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.exception.MissingBookingException;
import com.hw.airport.exception.MissingFlightException;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Booking.BookingStatus;
import com.hw.airport.model.BookingCharge;
import com.hw.airport.model.Flight;

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

		if(pendingBooking == null)
		{
			throw new MissingBookingException();
		}

		double currentFlightBagVolume = baggageSvc.getTheTotalBagVolumesOnFlight(pendingBooking.getFlightCode());
		double currentFlightBagWeight = baggageSvc.getTheTotalBagWeightOnFlight(pendingBooking.getFlightCode());
		int currentFlightPassengerCount = flightSvc.getPassengerCountForFlight(pendingBooking.getFlightCode());

		boolean isMaxVolumeExceeded = flightSvc.isMaxVolumeExceededForFlight(pendingBooking.getFlightCode(), currentFlightBagVolume);
		boolean isMaxWeightExceeded = flightSvc.isMaxWeightExceededForFlight(pendingBooking.getFlightCode(), currentFlightBagWeight);
		boolean isMaxPassengerCountExceeded = flightSvc.isMaxPassengerCountExceededForFlight(pendingBooking.getFlightCode(), currentFlightPassengerCount);
		boolean isNotCheckedIn = (pendingBooking.getCheckInStatus()==BookingStatus.NOT_CHECKED_IN);
			
		return !isMaxVolumeExceeded && !isMaxWeightExceeded && !isMaxPassengerCountExceeded && isNotCheckedIn;
	
	}
	
	/**
	 * @param lastName last name of the passenger.
	 * @param bookingRef the provided booking reference. this is checked with the bookings file.
	 * @throws HWAirportException throws missing booking exception if no booking was found.
	 */
	@Override
	public void doCheckIn(String lastName, String bookingRef) throws HWAirportException {
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
