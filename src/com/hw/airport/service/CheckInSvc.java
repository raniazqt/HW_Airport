package com.hw.airport.service;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking;
import com.hw.airport.model.BookingCharge;

public interface CheckInSvc {
	public boolean canCheckIn(String lastName, String bookingRef) throws HWAirportException;
	BookingCharge calculateXtraChargeForPasngr(BookingCharge charge) throws HWAirportException;
	Booking retrieveBookingByCodeAndLastName(String lastName, String bookingRef) throws HWAirportException;
	boolean confirmCheckin(Booking booking, BookingCharge bookingChg);
	public boolean doCheckIn(Booking passenger);
}
