package com.hw.airport.config;

import java.util.Map;

import com.hw.airport.GUI_S2.AirportGUI;
import com.hw.airport.GUI_S2.AirportGUIImpl;
import com.hw.airport.model.AppData;
import com.hw.airport.model.Booking;
import com.hw.airport.model.DeskManager;
import com.hw.airport.model.Flight;
import com.hw.airport.model.PassengerQueue;
import com.hw.airport.service.*;

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

	private static GUISvc guiSvc;
	
	private static DataSvc dataSvc;
	
	private static QueueSvc queueSvc ;
	
	private static DeskManager deskManager;
	
	private static DeskSvc deskSvc;

	private static CheckInSvc checkinSvc;
	
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
			queueSvc= new QueueSvcImpl();
			deskManager = new DeskManager();
			deskSvc = new DeskSvcImpl();
			checkinSvc = new CheckInSvcImpl();
			guiSvc = new GUISvcImpl();
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

	public static AirportGUI getGui() { return gui; }

	public static GUISvc getGuiSvc() { return guiSvc; }

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
