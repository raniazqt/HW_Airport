package com.hw.airport.main;

import java.util.Map;

import com.hw.airport.GUI.ScreenTemplate;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Flight;
import com.hw.airport.service.DataSvc;
import com.hw.airport.util.FileHandler;

public class ApplicationStart {
	
	//Hashmap to hold the list of passengers booking loaded from the text file. 
	//The key is the lastname concatenated with the reference code
	private static Map<String, Booking> bookingList;
	
	//Hashmap to hold the list of flights loaded from the text file. The key is the flight code
	private static Map<String, Flight> flightsInfo;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		/*
		 * DataSvc dataSvc = null; String flightsFileName = null; String bookingFileName
		 * = null;
		 * 
		 * flightsInfo = dataSvc.loadFlightsData(flightsFileName); bookingList =
		 * dataSvc.loadBookingData(bookingFileName);
		 */
		
		ScreenTemplate template = new ScreenTemplate();
		template.createGUITemplate();
	}

}
