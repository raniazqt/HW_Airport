package com.hw.airport.service;

import java.util.List;
import java.util.Observable;

import com.hw.airport.config.AppContainer;
import com.hw.airport.enums.DESK_STATUS;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.exception.MissingBookingException;
import com.hw.airport.exception.MissingFlightException;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Booking.BookingStatus;
import com.hw.airport.model.BookingCharge;
import com.hw.airport.model.Desk;
import com.hw.airport.model.Flight;
import com.hw.airport.model.ActiveFlight;
import com.hw.airport.observer.SynchronizedObservable;

/**
 * 1. save startTime in a variable.
 * 2. for each flight, define a variable called "duration"
 * 3. startTime - currentTime >= duration = flightIsDone.
 * 4. executionRate is the simulated time.
 */

public class CheckInSvcImpl extends SynchronizedObservable implements CheckInSvc {

	private BookingSvc bookingSvc = AppContainer.getBookingSvc();
	private FlightSvc flightSvc = AppContainer.getFlightSvc();
	private DeskSvc deskSvc = AppContainer.getDeskSvc();
	private DataSvc dataSvc = AppContainer.getDataSvc();
	private QueueSvc queueSvc = AppContainer.getQueueSvc();
	
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

		ActiveFlight flight = this.dataSvc.getActiveFlight(flightCd);
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

	
	// Check in - Step # 1
	@Override
	public synchronized void addPassengerToDesk(Desk desk) throws HWAirportException {
		deskSvc.loadDesk(desk);
		
	}

	// Check in - Step # 2
	@Override
	public void validatePassengerData(Booking passenger) throws HWAirportException {
		//check if the passenger has already checked in
		if (passenger.getCheckInStatus() == BookingStatus.CHECKED_IN) {
			System.out.println("Check in progress for Passenger - " + passenger.getFullName() 
			+ ": Passenger has already checked in");
			throw new HWAirportException("passenger " + passenger.getFullName() + " has already checked in!");
		}
	}

	// Check in - Step # 3
	@Override
	public void checkFlightStatus(Booking passenger) throws HWAirportException {
		String passengerName = passenger.getFirstName();
		String flightCd = passenger.getFlightCode();
		ActiveFlight flight = this.dataSvc.getActiveFlight(flightCd);
		//check if the flight is in the active flight list
		if (null == flight) {
			//flight not boarding, remove passenger 
			System.out.println("Passenger " + passengerName 
					+ " is booked on a flight " + flightCd + " Which is not boarding now ");
			throw new HWAirportException("Flight # " + flightCd + " is not boarding now!");
		}else 
			//check if the crnt time is within the flight boarding time
			//TODO: Not sure how to simulate it

			//check if the flight capacity, volume, passenger count were not exceeded
			if (this.isMaxFltCpctyVolWghtStsExceeded(flightCd)) {
				System.out.println("Check in progress for Passenger - " + passengerName 
						+ ": Check in failed The flight " + flightCd + " exceeded its capacity.");
				throw new HWAirportException("Flight # " + flightCd + " has exceeded its capacity");
			}
	}

	// Check in - Step # 4
	@Override
	public Booking calculateBaggageXtraCharge(Booking passenger) throws HWAirportException {
		boolean hasXtraCharge = false;
		//The passenger is good to go. Start the checkin process
		//Check for extra baggage weight or size 
		//to reuse the existing code to calculate the extra charge, create BookingCharge object
		BookingCharge bookingCharge = createBookingChargeObjForPassenger(passenger);

		bookingCharge = calculateXtraChargeForPasngr(bookingCharge);
		passenger.setTotalBaggageVolume(bookingCharge.getVolume());
		passenger.setXtraBagWghtChrg(bookingCharge.getWeightCharge());
		passenger.setXtraBagVolChrg(bookingCharge.getVolumeCharge());
		return passenger;
	}

	// Check in - Step # 5
	@Override
	public boolean processPayment(Booking passenger) {
		return true;
	}

	// Check in - Step # 6
	@Override
	public synchronized boolean saveFlightAndPassengerData(boolean checkInStatus, Booking passenger) {
		//done checking in passenger. update data
		// 1- update activeFlight object with the new charges, volume, weight and passenger count
		//2. add passenger to the list of checkedIn or failed checked depending on the check in status
		if (checkInStatus) {
			dataSvc.updateActiveFlight(passenger.getFlightCode(), 1, passenger.getTotalBaggageWeight(),
					passenger.getTotalBaggageVolume(), passenger.getXtraBagVolChrg() + passenger.getXtraBagWghtChrg());
			dataSvc.addPsgrToCheckedInList(passenger);
		}else {
			dataSvc.addPsgrToFailedToCheckedList(passenger);
		}
		return true;
	}
	
	@Override
	public void clearDesk(Desk desk) {
		deskSvc.clearDesk(desk);
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

	@Override
	public void updateDeskStatus(Desk desk, DESK_STATUS status) {
		deskSvc.updateStatus(desk, status);
		setChanged();
		notifyAll(desk);
	}

	@Override
	public boolean isQueueEmpty() {
		return (queueSvc.getCountOfPassangerInQueue() == 0);
	}

	@Override
	public void closeDesk(Desk desk) {
		deskSvc.closeDesk(desk);
		
	}

	

}
