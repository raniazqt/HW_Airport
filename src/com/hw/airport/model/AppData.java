package com.hw.airport.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppData {

	// Hashmap to hold the list of passengers booking loaded from the text file.
	// The key is the reference code
	private static Map<String, Booking> bookingList;

	// Hashmap to hold the list of flights loaded from the text file. The key is the
	// flight code
	private static Map<String, Flight> flightsInfo;
	
	private static List<ActiveFlight> activeFlights;
	
	private static AppData appData;

	public static AppData getInstance() {
		if (appData == null) {
			appData = new AppData();
			bookingList = new HashMap<String, Booking>();
			flightsInfo = new HashMap<String, Flight>();
			activeFlights = new ArrayList<ActiveFlight>();
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

	public static List<ActiveFlight> getActiveFlights() {
		return activeFlights;
	}

	public static void setActiveFlights(List<ActiveFlight> activeFlights) {
		AppData.activeFlights = activeFlights;
	}
	
}