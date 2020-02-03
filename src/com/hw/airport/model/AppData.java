package com.hw.airport.model;

import java.util.Map;


public class AppData {
	
	public static AppData appData;

	//Hashmap to hold the list of passengers booking loaded from the text file. 
	//The key is the reference code
	public Map<String, Booking> bookingList;

	//Hashmap to hold the list of flights loaded from the text file. The key is the flight code
	public Map<String, Flight> flightsInfo; 

	private AppData() {
		
	}
	
	public static AppData getInstance() {
		if (appData == null) {
			appData = new AppData();
		}
		return appData;
	}
}
