package com.hw.airport.service;

import java.util.Map;

import com.hw.airport.model.Booking;
import com.hw.airport.model.Flight;

public interface DataSvc {
	public Map<String, Flight> loadFlightsData(String flightsFileName) ;

	public Map<String, Booking> loadBookingData(String bookingFileName) ;

}
