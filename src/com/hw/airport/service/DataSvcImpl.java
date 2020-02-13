package com.hw.airport.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hw.airport.model.Booking;
import com.hw.airport.model.Flight;
import com.hw.airport.util.FileHandler;

public class DataSvcImpl implements DataSvc {
	
	//reads the data from flights file then convert it into a hashmap
	@Override
	public Map<String, Flight> loadFlightsData(String flightsFileName) {
		List<String[]> flightsData = FileHandler.parseFile(flightsFileName);
		//read file data into hashmap
		//Temp code to populate the flight map
		Map<String, Flight> flights = new HashMap<String, Flight>();
		flights.put("HW123", new Flight("HW123","DXB","LAX","AA"));
		
		return flights;
	}

	@Override
	public Map<String, Booking> loadBookingData(String bookingFileName) {
		List<String[]> bookingData = FileHandler.parseFile(bookingFileName);
		return null;
	}

}
