package com.hw.airport.main;

import com.hw.airport.GUI.AirportGUI;
import com.hw.airport.GUI.AirportGUIImpl;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.AppData;
import com.hw.airport.service.DataSvc;
import com.hw.airport.service.DataSvcImpl;

enum ApplicationState
{
	UNINITIALIZED,
	INITIALIZED,
}

public class ApplicationManager {
	private AirportGUI gui;
	private ApplicationState appState;
	private DataSvc dataSvc;
	String flightsFileName = "flights.csv"; 
	String bookingFileName = "bookings.csv";

	public ApplicationManager() {
		gui = new AirportGUIImpl();
		dataSvc = new DataSvcImpl();
		appState = ApplicationState.UNINITIALIZED;
	}

	private void start() {
		// any setup logic here.
		AppData appData = AppData.getInstance(); 
		try {
			appData.setFlightsInfo(dataSvc.loadFlightsData(flightsFileName));
			appData.setBookingList(dataSvc.loadBookingData(bookingFileName));
		} catch (HWAirportException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		appState = ApplicationState.INITIALIZED;
		gui.displayWelcomeScreen();
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
