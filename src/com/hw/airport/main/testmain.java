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

		try {
			appData.setFlightsInfo(dataSvc.loadFlightsData(flightsFileName));
			appData.setBookingList(dataSvc.loadBookingData(bookingFileName));
		} catch (HWAirportException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		appState = ApplicationState.INITIALIZED;

		passQList = passQ.getPassengerQ();			

		passQ.setMaxSize(10);
		//BIG ERROR IF QUEUE EXCEEDS BOOKINGS NEEDS BREAK POINT
		passQ.fillQueue();
		
		System.out.println("Filled Queue");
		passQ.printQ();
		
		passQ.addPassengerToQueue();
		System.out.println("Added Passenger");		
		passQ.printQ();
		
		passQ.removePassengerFromQueue();
		System.out.println("Removed Passenger");	
		passQ.printQ();
		
		System.out.println("Appdata Ref Queue");
		appData.getPassengerQueue().printQ();
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
