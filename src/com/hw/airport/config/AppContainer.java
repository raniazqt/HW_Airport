package com.hw.airport.config;

import java.util.Map;

import com.hw.airport.GUI_S1.AirportGUI;
import com.hw.airport.GUI_S1.AirportGUIImpl;
import com.hw.airport.model.AppData;
import com.hw.airport.model.Booking;
import com.hw.airport.model.DeskManager;
import com.hw.airport.model.Flight;
import com.hw.airport.model.PassengerQueue;
import com.hw.airport.service.BaggageSvc;
import com.hw.airport.service.BaggageSvcImpl;
import com.hw.airport.service.BookingSvc;
import com.hw.airport.service.BookingSvcImpl;
import com.hw.airport.service.CheckInSvc;
import com.hw.airport.service.CheckInSvcImpl;
import com.hw.airport.service.DataSvc;
import com.hw.airport.service.DataSvcImpl;
import com.hw.airport.service.DeskSvc;
import com.hw.airport.service.DeskSvcImpl;
import com.hw.airport.service.FlightSvc;
import com.hw.airport.service.FlightSvcImpl;
import com.hw.airport.service.QueueSvc;
import com.hw.airport.service.QueueSvcImpl;

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
	
	private static QueueSvc queueSvc ;
	
	private static DeskManager deskManager;
	
	private static DeskSvc deskSvc;

	private static CheckInSvc checkinSvc;
	
	public static AppContainer getInstance() {
		if (appContainer == null) {
			appContainer = new AppContainer();
			appData = AppData.getInstance();
			bookingSvc = new BookingSvcImpl();
			flightSvc = new FlightSvcImpl();
			checkInQueue = PassengerQueue.getInstance();
			baggageSvc = new BaggageSvcImpl();
			gui = new AirportGUIImpl();
			dataSvc = new DataSvcImpl();
			queueSvc= new QueueSvcImpl();			
			deskSvc = new DeskSvcImpl();
			checkinSvc = new CheckInSvcImpl();
			deskManager = new DeskManager();
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

	public static QueueSvc getQueueSvc() {
		return queueSvc;
	}

	public static DeskManager getDeskManager() {
		return deskManager;
	}

	public static DeskSvc getDeskSvc() {
		return deskSvc;
	}

	public static CheckInSvc getCheckinSvc() {
		return checkinSvc;
	}
	
	


}
