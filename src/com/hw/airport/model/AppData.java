package com.hw.airport.model;

import java.util.Map;


public class AppData {
	
	public static AppData appData;

	//Hashmap to hold the list of passengers booking loaded from the text file. 
	//The key is the reference code
	private  Map<String, Booking> bookingList;

	//Hashmap to hold the list of flights loaded from the text file. The key is the flight code
	private  Map<String, Flight> flightsInfo; 

	private AppData() {
		
	}
	
	public static AppData getInstance() {
		if (appData == null) {
			appData = new AppData();
		}
		
		return appData;
	}

	public Map<String, Booking> getBookingList() {
		return bookingList;
	}

	public void setBookingList(Map<String, Booking> bookingList) {
		this.bookingList = bookingList;
	}

	public Map<String, Flight> getFlightsInfo() {
		return flightsInfo;
	}

	public void setFlightsInfo(Map<String, Flight> flightsInfo) {
		this.flightsInfo = flightsInfo;
	}
	
	


}