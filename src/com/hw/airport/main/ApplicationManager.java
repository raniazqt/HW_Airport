package com.hw.airport.main;

import java.util.Timer;
import java.util.TimerTask;

import com.hw.airport.GUI_S2.AirportGUI;
import com.hw.airport.config.AirportSimulator;
import com.hw.airport.config.AppContainer;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.ActiveFlight;
import com.hw.airport.model.AppData;
import com.hw.airport.service.DataSvc;
import com.hw.airport.service.FlightSvc;
import com.hw.airport.service.QueueSvcImpl;


public class ApplicationManager {
	private AirportGUI gui;
	private DataSvc dataSvc;
	String flightsFileName = "flights.csv"; 
	String bookingFileName = "bookings.csv";

	public void InitializeApplication() throws Exception {
		AppContainer.getInstance();
		AppData.getInstance();
		AirportSimulator.getInstnce();

		gui = AppContainer.getGui();
		//register the DeskManager as an observer to the QueueSvs
		QueueSvcImpl queueSvc = (QueueSvcImpl) AppContainer.getQueueSvc();
		queueSvc.addObserver(AppContainer.getDeskManager());
		/*
		 * if (null == appContainer) { throw new RuntimeErrorException(null,
		 * "Application did not start correctly. Notify adminstrator "); }
		 */

		dataSvc = AppContainer.getDataSvc();
		//load flights and booking data from files
		try {
			AppData.setFlightsInfo(dataSvc.loadFlightsData(flightsFileName));
			AppData.setBookingList(dataSvc.loadBookingData(bookingFileName));
		} catch (HWAirportException e) {
			throw new Exception("Application failed to load data. Contact adminstrator");
		}
		
		//create list of flights being boarding based on user entry
		AppData.getActiveFlights().add(new ActiveFlight("AF999", 10));
		AppData.getActiveFlights().add(new ActiveFlight("AA123", 10));
		
		FlightSvc flightSvc = AppContainer.getFlightSvc();
		flightSvc.setFlights(AppData.getFlightsInfo());
		
	
		
		
	}
	private void start() throws Exception {

		this.InitializeApplication();

		/* 1. Load data from files
		 * 2. Read simulator settings from user:
		 * 		- rate for adding passengers to queue in seconds
		 * 		- ratio of number of passengers in queue to number of opened checkin desks
		 * 		- maximum number of allowed check-in desks
		 * 		- simulator running rate in seconds
		 * 		- flights to check in ( flight code , check in period in seconds)
		 * 3. instantiate the queue
		 * 4. create the timer to populate the queue
		 * 
		 */	

		// any setup logic here.

		//Initialize app simulator
		long rate = (long) AirportSimulator.getQueuePopulatingRate();
		long appRate = rate / 6;

		TimerTask queuePopulatingTask = new QueuePopulatingTask();
		//running timer task as daemon thread
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(queuePopulatingTask, 0, appRate);
		System.out.println("TimerTask started");

		gui.display();
	}



	public static void main(String[] args) throws Exception {
		ApplicationManager appManager = new ApplicationManager();
		appManager.start();
	}
}
