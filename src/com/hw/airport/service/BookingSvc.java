package com.hw.airport.service;

import java.util.List;
import java.util.Map;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.exception.NullBookingException;
import com.hw.airport.model.Booking;
import com.hw.airport.model.BookingCharge;
import com.hw.airport.model.FlightExtrasAndCharges;
import com.hw.airport.model.Booking.BookingStatus;

public interface BookingSvc {
	
	public Booking findBookingByLastNameAndRefCode(String lastName, String refCode) throws HWAirportException;
		
	public int getCountOfCheckedInPassengersByFlight(String flightCode) throws HWAirportException;
	
	public FlightExtrasAndCharges calculateExtraChargeForFlight(String flightCode) throws HWAirportException;

	public List<Booking> findAllBookingForFlight(String flightCode);
	
	public List<Booking> extractBookingList() ;

	Map<String, List<Booking>> groupBookingByFlightCode();

	boolean updateBookingStatus(Booking booking, BookingCharge bookingChg) throws HWAirportException;

	public Booking getFirstShuffledBooking() throws HWAirportException;
	
	public void updateCheckInStatus(String refCode, BookingStatus status) ;
	
	public Booking findBookingByRefCode(String refCode) throws HWAirportException;
	
	public Booking getRandomBooking() throws HWAirportException ;
	
	public void setRandomBaggageDimensions(Booking booking) ;

	List<String> getAllFlightsCodeWithBooking();

}
