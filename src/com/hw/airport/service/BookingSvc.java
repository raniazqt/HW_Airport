package com.hw.airport.service;

import com.hw.airport.model.Booking;

public interface BookingSvc {
	
	public Booking findBookingByLastNameAndRefCode(String lastName, String refCode);
	
	public boolean updateBookingStatus(String lastName, String refCode, boolean status);
	
	public int getCountOfCheckedInPassengersByFlight(String flightCode);
	
	public double calculateExtraChargeForFlight(String flightCode);

}
