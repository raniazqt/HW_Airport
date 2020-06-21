package com.hw.airport.config;

import java.util.Map;

import com.hw.airport.GUI_S1.AirportGUI;
import com.hw.airport.GUI_S1.AirportGUIImpl;
import com.hw.airport.model.AppData;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Flight;
import com.hw.airport.model.PassengerQueue;
import com.hw.airport.service.BaggageSvc;
import com.hw.airport.service.BaggageSvcImpl;
import com.hw.airport.service.BookingSvc;
import com.hw.airport.service.BookingSvcImpl;
import com.hw.airport.service.DataSvc;
import com.hw.airport.service.DataSvcImpl;
import com.hw.airport.service.FlightSvc;
import com.hw.airport.service.FlightSvcImpl;

public class AppContainer {

	// Hashmap to hold the list of passengers booking loaded from the text file.
	// The key is the reference code
	private Map<String, Booking> bookingList;

	// Hashmap to hold the list of flights loaded from the text file. The key is the
	// flight code
	private Map<String, Flight> flightsInfo;

	// PassengerQueue object to hold a single queue object for the program will need
	// to be managed for threading
	private static PassengerQueue checkInQueue;

	private static BookingSvc bookingSvc;
	private static FlightSvc flightSvc;
	private static BaggageSvc baggageSvc;

	private static AppData appData;

	private static AppContainer appContainer;
	
	private static AirportGUI gui;
	
	private static DataSvc dataSvc;

	public static AppContainer getInstance() {
		if (appContainer == null) {
			appContainer = new AppContainer();
			bookingSvc = new BookingSvcImpl();
			flightSvc = new FlightSvcImpl();
			checkInQueue = PassengerQueue.getInstance();
			baggageSvc = new BaggageSvcImpl();
			appData = AppData.getInstance();
			gui = new AirportGUIImpl();
			dataSvc = new DataSvcImpl();
		}

		return appContainer;
	}

	public Map<String, Booking> getBookingList() {
		return bookingList;
	}

	public Map<String, Flight> getFlightsInfo() {
		return flightsInfo;
	}

	public static PassengerQueue getCheckInQueue() {
		return checkInQueue;
	}

	public static BookingSvc getBookingSvc() {
		return bookingSvc;
	}

	public static FlightSvc getFlightSvc() {
		return flightSvc;
	}

	public static BaggageSvc getBaggageSvc() {
		return baggageSvc;
	}

	public static AppData getAppData() {
		return appData;
	}

	public static AirportGUI getGui() {
		return gui;
	}

	public static DataSvc getDataSvc() {
		return dataSvc;
	}


}
