package com.hw.airport.main;

import com.hw.airport.GUI.AirportGUI;
import com.hw.airport.GUI.AirportGUIImpl;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.AppData;
import com.hw.airport.service.CheckInSvc;
import com.hw.airport.service.CheckInSvcImpl;
import com.hw.airport.service.DataSvc;
import com.hw.airport.service.DataSvcImpl;
import com.hw.airport.service.FlightSvc;
import com.hw.airport.service.FlightSvcImpl;

enum ApplicationState
{
	UNINITIALIZED,
	INITIALIZED,
	RUNNING,
	PAUSED,
	TERMINATED
}

public class ApplicationManager {
	private AirportGUI gui;
	private ApplicationState appState;
	private DataSvc dataSvc;
	String flightsFileName = ""; 
	String bookingFileName = "";

	public ApplicationManager() {
		gui = new AirportGUIImpl();
		dataSvc = new DataSvcImpl();
		appState = ApplicationState.UNINITIALIZED;
	}

	private void start() {
		// any setup logic here.
		AppData appData = AppData.getInstance(); 
		appData.setFlightsInfo(dataSvc.loadFlightsData(flightsFileName));
		appData.setBookingList(dataSvc.loadBookingData(bookingFileName));

		appState = ApplicationState.INITIALIZED;
		gui.displayWelcomeScreen();

	}

	public void execute() {
		try {

			if(appState == ApplicationState.UNINITIALIZED) {
				start();
			}

			run();

			if(appState == ApplicationState.TERMINATED) {
				terminate();
			}

		}
		catch (Exception e) {
		}
		finally {
		}
	}

	private void run() throws HWAirportException {
		do {
			//run the whole simulation in steps.
		} while (appState != ApplicationState.TERMINATED);
	}

	private void terminate() throws HWAirportException {
		// cleans up the services & shuts down the executable.
	}

	public ApplicationState getAppState() {
		return appState;
	}
}
