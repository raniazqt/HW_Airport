package com.hw.airport.main;

import java.util.LinkedList;
import java.util.List;

import com.hw.airport.GUI.AirportGUI;
import com.hw.airport.GUI.AirportGUIImpl;
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
		PassengerQueue passQ = PassengerQueue.getInstance();
		AppData appData = AppData.getInstance();
		try {
			appData.setFlightsInfo(dataSvc.loadFlightsData(flightsFileName));
			appData.setBookingList(dataSvc.loadBookingData(bookingFileName));
		} catch (HWAirportException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		appState = ApplicationState.INITIALIZED;

		passQList = passQ.getPassengerQ();
		passQ.addPassengerToQueue();
		passQ.addPassengerToQueue();

		passQ.printQ();

		passQ.removePassengerFromQueue();

		passQ.printQ();

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
