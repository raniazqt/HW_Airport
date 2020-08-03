package com.hw.airport.main;

import com.hw.airport.GUI.AirportGUI;
import com.hw.airport.config.AirportSimulator;
import com.hw.airport.config.AppContainer;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.ActiveFlight;
import com.hw.airport.model.AppData;
import com.hw.airport.model.SimulationTimer;
import com.hw.airport.service.*;
import javax.swing.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ApplicationManager {

	static Logger LOG = LogManager.getLogger(ApplicationManager.class);
	private static AirportGUI gui= AppContainer.getInstance().getGui();

	String flightsFileName = "flights.csv";
	String bookingFileName = "bookings.csv";
	static DeskManager deskManager = AppContainer.getDeskManager();

	public void InitializeApplication() throws Exception {

		AppData.getInstance();
		AirportSimulator.getInstnce();

		QueueSvcImpl queueSvc = (QueueSvcImpl) AppContainer.getQueueSvc();
		queueSvc.registerObserver(AppContainer.getDeskManager());
		queueSvc.registerObserver(gui);

		DeskManager deskManager = AppContainer.getDeskManager();
		deskManager.registerObserver(gui);


		CheckInSvcImpl checkInSvc = (CheckInSvcImpl) AppContainer.getCheckinSvc();
		checkInSvc.registerObserver(gui);

		DataSvcImpl dataSvc = (DataSvcImpl) AppContainer.getDataSvc();
		dataSvc.registerObserver(gui);

		//load flights and booking data from files
		try {
			AppData.setFlightsInfo(dataSvc.loadFlightsData(flightsFileName));
			AppData.setBookingList(dataSvc.loadBookingData(bookingFileName));
		} catch (HWAirportException e) {
			throw new Exception("Application failed to load data. Contact adminstrator");
		}

		//create list of flights being boarding based on user entry
		/*
		 * AppData.getActiveFlights().add(new ActiveFlight("AF999", 10));
		 * AppData.getActiveFlights().add(new ActiveFlight("AA123", 10));
		 */
		FlightSvc flightSvc = AppContainer.getFlightSvc();
		flightSvc.setFlights(AppData.getFlightsInfo());
	}

	//TODO: MUST BE CALLED FROM THE CONFIG FRAME TO START THE SIMULATION.
	public void start() throws Exception {
		InitializeApplication();

		TimerManager timerManager = new TimerManager();
		SimulationTimer appTimer = timerManager.setupTimer();
		//register observers which need to be notified every time the timer task is executed
		//DeskManager need to be notified when attempting to add passenger the queue
		appTimer.registerObserver(AppContainer.getDeskManager());
		//TimerManager needs to be notified when the simulation time has ended to stop the queue populating task
		deskManager.registerObserver(timerManager);
		appTimer.registerObserver(gui);


	}

	public static void main(String[] args) throws Exception {
		ApplicationManager appManager = new ApplicationManager();
		appManager.InitializeApplication();
		LOG.debug("Collecting settings from user");
		gui.displayConfigScreen();
	}
}
