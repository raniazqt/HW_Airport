package com.hw.airport.service;

import java.util.List;
import java.util.Map;

import com.hw.airport.model.Booking;

public interface BookingSvc {
	
	public Booking findBookingByLastNameAndRefCode(String lastName, String refCode);
	
	public boolean updateBookingStatus(String lastName, String refCode, boolean status);
	
	public int getCountOfCheckedInPassengersByFlight(String flightCode);
	
	public double claculateXtraFeeChargedForFlight(String flightCode);

	public List<Booking> findBookingByFlightCode(String flightCode);

	Map<String, List<Booking>> groupBookingByFlightCode();

}
