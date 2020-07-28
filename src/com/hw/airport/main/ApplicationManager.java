package com.hw.airport.main;

import com.hw.airport.GUI_S2.AirportGUI;
import com.hw.airport.config.AirportSimulator;
import com.hw.airport.config.AppContainer;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.ActiveFlight;
import com.hw.airport.model.AppData;
import com.hw.airport.model.DeskManager;
import com.hw.airport.service.CheckInSvcImpl;
import com.hw.airport.service.DataSvc;
import com.hw.airport.service.DataSvcImpl;
import com.hw.airport.service.FlightSvc;
import com.hw.airport.service.QueueSvcImpl;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.SwingUtilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ApplicationManager {
	private static final Logger LOG = LogManager.getLogger(ApplicationManager.class);
	private static AirportGUI gui= AppContainer.getInstance().getGui();
	private DataSvc dataSvc;
	String flightsFileName = "flights.csv"; 
	String bookingFileName = "bookings.csv";

	public void InitializeApplication() throws Exception {
		LOG.debug ("Initialising application");
		AppData.getInstance();
		AirportSimulator.getInstnce();

		//gui = AppContainer.getGui();
		//register the DeskManager as an observer to the QueueSvs
		QueueSvcImpl queueSvc = (QueueSvcImpl) AppContainer.getQueueSvc();
		queueSvc.addObserver(AppContainer.getDeskManager());
		queueSvc.addObserver(gui);
		
		DeskManager deskManager = AppContainer.getDeskManager();
		deskManager.addObserver(gui);
		
		CheckInSvcImpl checkInSvc = (CheckInSvcImpl) AppContainer.getCheckinSvc();
		checkInSvc.addObserver(gui);
		
		DataSvcImpl dataSvc = (DataSvcImpl) AppContainer.getDataSvc();
		dataSvc.addObserver(gui);
		/*
		 * if (null == appContainer) { throw new RuntimeErrorException(null,
		 * "Application did not start correctly. Notify adminstrator "); }
		 */

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

	//TODO: MUST BE CALLED FROM THE CONFIG FRAME TO START THE SIMULATION. 
	public void start() throws Exception {
		InitializeApplication();

		long rate = (long) AirportSimulator.getQueuePopulatingRate();
		long appRate = rate / 6;

		TimerTask queuePopulatingTask = new QueuePopulatingTask();
		//running timer task as daemon thread
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(queuePopulatingTask, 0, appRate);
		System.out.println("TimerTask started");
		
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		    	AppContainer.getGui().displayAirportMonitorScreen();
		    }
		});
		
	
	}

	/*
	 * public static void main(String[] args) throws Exception { ApplicationManager
	 * appManager = new ApplicationManager(); gui.displayConfigScreen();
	 * //appManager.start(); }
	 */
}
