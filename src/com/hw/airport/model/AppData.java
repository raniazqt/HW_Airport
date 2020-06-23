package com.hw.airport.model;

import java.util.HashMap;
import java.util.Map;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.service.BaggageSvc;
import com.hw.airport.service.BaggageSvcImpl;
import com.hw.airport.service.BookingSvc;
import com.hw.airport.service.BookingSvcImpl;
import com.hw.airport.service.FlightSvc;
import com.hw.airport.service.FlightSvcImpl;

public class AppData {

	// Hashmap to hold the list of passengers booking loaded from the text file.
	// The key is the reference code
	private static Map<String, Booking> bookingList;

	// Hashmap to hold the list of flights loaded from the text file. The key is the
	// flight code
	private static Map<String, Flight> flightsInfo;
	
	private static AppData appData;

	public static AppData getInstance() {
		if (appData == null) {
			appData = new AppData();
			bookingList = new HashMap<String, Booking>();
			flightsInfo = new HashMap<String, Flight>();
		}
		return appData;
	}

	public static Map<String, Booking> getBookingList() {
		return bookingList;
	}

	public static Map<String, Flight> getFlightsInfo() {
		return flightsInfo;
	}

	public static void setBookingList(Map<String, Booking> bookingList) {
		AppData.bookingList = bookingList;
	}

	public static void setFlightsInfo(Map<String, Flight> flightsInfo) {
		AppData.flightsInfo = flightsInfo;
	}
	
	
	
	

}