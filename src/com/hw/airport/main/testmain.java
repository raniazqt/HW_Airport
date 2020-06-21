package com.hw.airport.main;

import java.util.LinkedList;
import java.util.List;

import com.hw.airport.GUI_S1.AirportGUI;
import com.hw.airport.GUI_S1.AirportGUIImpl;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.AppData;
import com.hw.airport.model.Booking;
import com.hw.airport.model.PassengerQueue;
import com.hw.airport.service.DataSvc;
import com.hw.airport.service.DataSvcImpl;
import com.hw.airport.service.DeskSvc;
import com.hw.airport.service.DeskSvcImpl;
import com.hw.airport.service.QueueSvc;
import com.hw.airport.service.QueueSvcImpl;

public class testmain {

	public static void main(String[] args) throws HWAirportException {
		AirportGUI gui;
		ApplicationState appState;
		DataSvc dataSvc;
		QueueSvc Queues;

		LinkedList<Booking> passQList;
		String flightsFileName = "flights.csv";
		String bookingFileName = "bookings.csv";
		gui = new AirportGUIImpl();
		dataSvc = new DataSvcImpl();
		Queues = new QueueSvcImpl();
		appState = ApplicationState.UNINITIALIZED;

		// any setup logic here.
		// PassengerQueue passQ = new PassengerQueue();

		AppData appData = AppData.getInstance();

		PassengerQueue passQ = appData.getPassengerQueue();
		
		DeskSvc checkDesk = new DeskSvcImpl();

		try {
			appData.setFlightsInfo(dataSvc.loadFlightsData(flightsFileName));
			appData.setBookingList(dataSvc.loadBookingData(bookingFileName));
		} catch (HWAirportException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		appState = ApplicationState.INITIALIZED;

		passQList = passQ.getPassengerQList();			

		passQ.setMaxSize(10);
		//BIG ERROR IF QUEUE EXCEEDS BOOKINGS NEEDS BREAK POINT
		passQ.fillQList();
		
		System.out.println("Filled Queue");
		passQ.printQList();
		
		passQ.addPassengerToQList();
		System.out.println("Added Passenger");		
		passQ.printQList();
		
		passQ.removePassengerFromQList();
		System.out.println("Removed Passenger");	
		passQ.printQList();
		
		System.out.println("Appdata Ref Queue");
		appData.getPassengerQueue().printQList();
		 
		System.out.println(appData.getBookingList().get(passQ.firstPassengerFromQList().getRefCode()).getCheckInStatus());
		
		System.out.println("Check In Desk");
		checkDesk.loadDesk();
		System.out.println(checkDesk.getPassenger().getRefCode());	
		Booking check = checkDesk.getPassenger();
		
		System.out.println(appData.getBookingList().get(check.getRefCode()).getCheckInStatus());
		checkDesk.validate();
		checkDesk.calcCharges();
		checkDesk.checkinPassenger();
		
		System.out.println("Passenger");
		System.out.println(appData.getBookingList().get(check.getRefCode()).getCheckInStatus());
		

		/*
		 * List <Booking> qList = Queues.createQueue(10); Queues.addQueue(qList);
		 * Queues.dropQueue(qList, appData.getBookingList()); passQ.getInstance();
		 * System.out.println("Queue"); passQ.printQ();
		 * System.out.println("Drop"+"\n"+passQ.removePassengerFromQueue().getRefCode())
		 * ;
		 * 
		 * System.out.println("Queue"); passQ.printQ();
		 */

	}

}
