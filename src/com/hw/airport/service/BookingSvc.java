package com.hw.airport.service;

import java.util.List;
import java.util.Map;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking;
import com.hw.airport.model.FlightExtrasAndCharges;

public interface BookingSvc {
	
	public Booking findBookingByLastNameAndRefCode(String lastName, String refCode);
	
	public boolean updateBookingStatus(String lastName, String refCode, boolean status) throws HWAirportException;
	
	public int getCountOfCheckedInPassengersByFlight(String flightCode) throws HWAirportException;
	
	public FlightExtrasAndCharges calculateExtraChargeForFlight(String flightCode) throws HWAirportException;

	public List<Booking> findAllBookingForFlight(String flightCode);

	Map<String, List<Booking>> groupBookingByFlightCode();

}
