package com.hw.airport.main;

import java.util.Timer;
import java.util.TimerTask;

import javax.management.RuntimeErrorException;

import com.hw.airport.GUI_S1.AirportGUI;
import com.hw.airport.config.AirportSimulator;
import com.hw.airport.config.AppContainer;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.AppData;
import com.hw.airport.model.PassengerQueue;
import com.hw.airport.service.DataSvc;

enum ApplicationState
{
	UNINITIALIZED,
	INITIALIZED,
}

public class ApplicationManager {
	private AirportGUI gui;
	private ApplicationState appState;
	private AirportSimulator simulator;
	private DataSvc dataSvc;
	String flightsFileName = "flights.csv"; 
	String bookingFileName = "bookings.csv";

	public void InitializeApplication() {
		AppContainer.getInstance();
		AppData.getInstance();
		dataSvc = AppContainer.getDataSvc();
		gui = AppContainer.getGui();
		/*
		 * if (null == appContainer) { throw new RuntimeErrorException(null,
		 * "Application did not start correctly. Notify adminstrator "); }
		 */
		
		
		//load flights and booking data from files
		try {
			AppData.setFlightsInfo(dataSvc.loadFlightsData(flightsFileName));
		} catch (HWAirportException e) {
			e.printStackTrace();
		}
		AppData.setBookingList(dataSvc.loadBookingData(bookingFileName));

		appState = ApplicationState.INITIALIZED;

	}

	public ApplicationManager() {
		simulator = AirportSimulator.getInstnce();
		
		gui = AppContainer.getGui();

		appState = ApplicationState.UNINITIALIZED;
	}

	private void start() {
		
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
		simulator = AirportSimulator.getInstnce();
		long rate = simulator.getQueuePopulatingRate();
		long appRate = rate / 6;

		TimerTask timerTask = new QueueTimer();
		//running timer task as daemon thread
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(timerTask, 0, appRate);
		System.out.println("TimerTask started");

		gui.displayAirportStatusScreen();
	}

	public void execute() {
		try {
			if(appState == ApplicationState.UNINITIALIZED) {
				start();
			}
		}
		catch (Exception e) {
			//do nothing.
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
