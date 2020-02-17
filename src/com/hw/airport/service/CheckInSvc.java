package com.hw.airport.service;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking;
import com.hw.airport.model.BookingCharge;

public interface CheckInSvc {
	public void doCheckIn(String lastName, String bookingRef) throws HWAirportException;
	BookingCharge calculateXtraChargeForPasngr(BookingCharge charge) throws HWAirportException;
	Booking retrieveBookingByCodeAndLastName(String lastName, String bookingRef) throws HWAirportException;
}
