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
import com.hw.airport.model.ActiveFlight;
import com.hw.airport.model.AppData;

/**
 * 1. save startTime in a variable.
 * 2. for each flight, define a variable called "duration"
 * 3. startTime - currentTime >= duration = flightIsDone.
 * 4. executionRate is the simulated time.
 */

public class CheckInSvcImpl implements CheckInSvc {

	private BookingSvc bookingSvc = AppContainer.getBookingSvc();
	private FlightSvc flightSvc = AppContainer.getFlightSvc();
	private BaggageSvc baggageSvc = AppContainer.getBaggageSvc();
	private DataSvc dataSvc = AppContainer.getDataSvc();
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
					(charge.getWeight() - flight.getMaxBagWeight()));
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

	/*public boolean isMaxFltCpctyVolWghtStsExceeded(String flightCd) {
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

	}*/

	public boolean isMaxFltCpctyVolWghtStsExceeded(String flightCd) {
		double currentFlightBagVolume;
		boolean isMaxVolumeExceeded = false;
		boolean isMaxWeightExceeded = false;
		boolean isMaxPassengerCountExceeded = false;

		ActiveFlight flight = this.getActiveFlight(flightCd);
		currentFlightBagVolume = flight.getTotalVolume();

		double currentFlightBagWeight = flight.getTotalWeight();
		int currentFlightPassengerCount = flight.getBoardedPsngrCnt();

		try {
			isMaxVolumeExceeded = flightSvc.isMaxVolumeExceededForFlight(flightCd, currentFlightBagVolume);
			isMaxWeightExceeded = flightSvc.isMaxWeightExceededForFlight(flightCd, currentFlightBagWeight);
			isMaxPassengerCountExceeded = flightSvc.isMaxPassengerCountExceededForFlight(flightCd, currentFlightPassengerCount);
		} catch (HWAirportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isMaxVolumeExceeded && isMaxWeightExceeded && isMaxPassengerCountExceeded;	
	}

	/**
	 * @param lastName last name of the passenger.
	 * @param bookingRef the provided booking reference. this is checked with the bookings file.
	 * @throws HWAirportException 
	 */
	@Override
	public boolean doCheckIn(Booking passenger) throws HWAirportException {
		//List<ActiveFlight> activeFlights = AppData.getActiveFlights();

		String flightCd = passenger.getFlightCode();
		ActiveFlight flight = this.getActiveFlight(flightCd);
		String passengerName = passenger.getFullName();
		boolean isCheckInComplete = false;


		//check if the passenger has already checked in
		if (passenger.getCheckInStatus() == BookingStatus.CHECKED_IN) {
			System.out.println("Check in progress for Passenger - " + passengerName 
					+ ": Passenger has already checked in");
			//	throw new HWAirportException("passenger " + passengerName + " has already checked in!");
		}else 

			//check if the flight is in the active flight list
			if (null == flight) {
				//flight not boarding, remove passenger 
				System.out.println("Passenger " + passengerName 
						+ " is booked on a flight " + flightCd + " Which is not boarding now ");
				//	throw new HWAirportException("Flight # " + flightCd + " is not boarding now!");
			}else 
				//check if the crnt time is within the flight boarding time
				//TODO: Not sure how to simulate it

				//check if the flight capacity, volume, passenger count were not exceeded
				if (this.isMaxFltCpctyVolWghtStsExceeded(flightCd)) {
					System.out.println("Check in progress for Passenger - " + passengerName 
							+ ": Check in failed The flight " + flightCd + " exceeded its capacity.");
					//	throw new HWAirportException("Flight # " + flightCd + " has exceeded its capacity");
				} else {

					//The passenger is good to go. Start the checkin process
					//Check for extra baggage weight or size 
					//to reuse the existing code to calculate the extra charge, create BookingCharge object
					BookingCharge bookingCharge = createBookingChargeObjForPassenger(passenger);
					try {
						bookingCharge = calculateXtraChargeForPasngr(bookingCharge);
						if (bookingCharge.getVolumeCharge() != 0 || bookingCharge.getWeightCharge() !=0 ) {
							//passenger needs to pay extra baggage charge
							//TODO: Not sure what to do in this case
						}

					} catch (HWAirportException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					//done checking in passenger. update data
					//update activeFlight object with the new charges, volume, weight and passenger count
					dataSvc.updateActiveFlight(flightCd, 1, bookingCharge.getWeight(), bookingCharge.getVolume(), bookingCharge.getTotalChg());


					isCheckInComplete = true;
				}
		return isCheckInComplete;



		//check the passenger details
		//check passenger baggages
		//calculate any extra charges



	}

	private BookingCharge createBookingChargeObjForPassenger(Booking passenger) {
		BookingCharge charge = new BookingCharge();
		charge.setRefCode(passenger.getRefCode());
		charge.setDepth(passenger.getBaggageHeight());
		charge.setLastName(passenger.getLastName());
		charge.setLength(passenger.getBaggageLength());
		charge.setWeight(passenger.getTotalBaggageWeight());
		charge.setWidth(passenger.getBaggageWidth());
		//	charge.setBagCnt(passenger.);
		return charge;
	}

	private ActiveFlight getActiveFlight(String flightCd) {
		List<ActiveFlight> activeFlights = AppData.getActiveFlights();

		for(ActiveFlight flight : activeFlights){
			if (flight.getFlightCd().equalsIgnoreCase(flightCd)) {
				return flight;
			}
		}
		return null;
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
