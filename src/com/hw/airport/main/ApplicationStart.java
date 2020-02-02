package com.hw.airport.main;

import java.util.Map;

import com.hw.airport.model.Booking;
import com.hw.airport.model.Flight;
import com.hw.airport.util.FileHandler;

public class ApplicationStart {
	
	//Hashmap to hold the list of passengers booking loaded from the text file. 
	//The key is the lastname concatenated with the reference code
	private static Map<String, Booking> bookingList;
	
	//Hashmap to hold the list of flights loaded from the text file. The key is the flight code
	private static Map<String, Flight> flightsInfo;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		FileHandler fileHandler = null;
		String flightsFileName = null;
		String bookingFileName = null;
		
		//flightsInfo = fileHandler.loadFlightsFile(flightsFileName);
		//bookingList = fileHandler.loadBookingFile(bookingFileName);
	}

}
