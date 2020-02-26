package com.hw.airport.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Flight;
import com.hw.airport.util.FileHandler;

public class DataSvcImpl implements DataSvc {

	//reads the data from flights file then convert it into a hashmap
	@Override
	public Map<String, Flight> loadFlightsData(String flightsFileName) throws HWAirportException {
		List<String[]> flightsData;
		try {
			flightsData = FileHandler.parseFile(flightsFileName);
		} catch (HWAirportException e) {
			throw new HWAirportException("Error parsing the file data");
		}
		Map<String, Flight> flights = new HashMap<String, Flight>();
		
		try {
		for(String[] line : flightsData ) {
			Flight flight = new Flight(line[0].toLowerCase(), line[1], line[2], line[3],Integer.parseInt(line[4]),
					Integer.parseInt(line[5]), Integer.parseInt(line[6]), Double.parseDouble(line[7]),
					Double.parseDouble(line[8]),Double.parseDouble(line[9]),Double.parseDouble(line[10]),
					Double.parseDouble(line[11]), Double.parseDouble(line[12]));
			flights.put(line[0].toLowerCase(),flight);
		}
		}catch (Exception ex){
			ex.printStackTrace();
		}
				return flights;
	}

	@Override
	public Map<String, Booking> loadBookingData(String bookingFileName) {
		List<String[]> bookingData = new ArrayList<String[]>();
		try {
			bookingData = FileHandler.parseFile(bookingFileName);
		} catch (HWAirportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String, Booking> bookingList = new HashMap<String, Booking>();
		Booking booking;
		for(String[] line : bookingData) {
			String refCode = line[2].toLowerCase();
			booking = new Booking(line[0].toLowerCase(), 
					line[1].toLowerCase(), line[2].toLowerCase(), line[3].toLowerCase(), Boolean.getBoolean(line[4]));
			bookingList.put(refCode, booking);
		}
		return bookingList;
	}

}
