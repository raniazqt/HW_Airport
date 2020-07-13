package com.hw.airport.service;

import com.hw.airport.enums.DESK_STATUS;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking;
import com.hw.airport.model.BookingCharge;
import com.hw.airport.model.Desk;

public interface CheckInSvc {
	public boolean canCheckIn(String lastName, String bookingRef) throws HWAirportException;
	BookingCharge calculateXtraChargeForPasngr(BookingCharge charge) throws HWAirportException;
	Booking retrieveBookingByCodeAndLastName(String lastName, String bookingRef) throws HWAirportException;
	boolean confirmCheckin(Booking booking, BookingCharge bookingChg);
	void validatePassengerData(Booking passenger) throws HWAirportException;
	void checkFlightStatus(Booking passenger) throws HWAirportException;
	Booking calculateBaggageXtraCharge(Booking passenger) throws HWAirportException;
	boolean processPayment(Booking passenger);
	boolean saveFlightAndPassengerData(boolean checkInStatus, Booking passenger);
	public void addPassengerToDesk(Desk desk) throws HWAirportException;
	void clearDesk(Desk desk);
	void updateDeskStatus(Desk desk, DESK_STATUS status);
	public boolean isQueueEmpty();
	public void closeDesk(Desk desk);
}
