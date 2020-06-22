package com.hw.airport.main;

import java.util.LinkedList;
import java.util.List;

import com.hw.airport.GUI_S1.AirportGUI;
import com.hw.airport.GUI_S1.AirportGUIImpl;
import com.hw.airport.config.AppContainer;
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
		ApplicationManager manager = new ApplicationManager();
		
		manager.InitializeApplication();
		
		AirportGUI gui;
		DataSvc dataSvc;
		QueueSvc queueSvc;

		LinkedList<Booking> passQList;
		String flightsFileName = "flights.csv";
		String bookingFileName = "bookings.csv";
		gui = new AirportGUIImpl();
		dataSvc = AppContainer.getDataSvc();
		queueSvc = AppContainer.getQueueSvc();

		// any setup logic here.
		// PassengerQueue passQ = new PassengerQueue();

		AppData appData = AppData.getInstance();

		PassengerQueue passQ = AppContainer.getCheckInQueue();
		
		
		
	//	DeskSvc checkDesk = new DeskSvcImpl();
		
		

		passQList = passQ.getPassengerList();			

		passQ.setQueueMaxSize(10);
		//BIG ERROR IF QUEUE EXCEEDS BOOKINGS NEEDS BREAK POINT
		queueSvc.fillQueue();
		
		System.out.println("Filled Queue");
		passQ.printPassegerQueue();
		
		queueSvc.addPassengerToQueue();
		System.out.println("Added Passenger");		
		passQ.printPassegerQueue();
		
		passQ.removePassengerFromQueue();
		System.out.println("Removed Passenger");	
		passQ.printPassegerQueue();
		
		System.out.println("Appdata Ref Queue");
		passQ.printPassegerQueue();
		 
		System.out.println(appData.getBookingList().get(passQ.removePassengerFromQueue().getRefCode()).getCheckInStatus());
		
		/*
		 * System.out.println("Check In Desk"); checkDesk.loadDesk();
		 * System.out.println(checkDesk.getPassenger().getRefCode()); Booking check =
		 * checkDesk.getPassenger();
		 * 
		 * System.out.println(appData.getBookingList().get(check.getRefCode()).
		 * getCheckInStatus()); checkDesk.validate(); checkDesk.calcCharges();
		 * checkDesk.checkinDesk();
		 */
		
		/*
		 * System.out.println("Passenger");
		 * System.out.println(appData.getBookingList().get(check.getRefCode()).
		 * getCheckInStatus());
		 */

		/*
		 * List <Booking> qList = Queues.createQueue(10); Queues.addQueue(qList);
		 * Queues.dropQueue(qList, appData.getBookingList()); passQ.getInstance();
		 * System.out.println("Queue"); passQ.printPassegerQueue();
		 * System.out.println("Drop"+"\n"+passQ.removePassengerFromQueue().getRefCode())
		 * ;
		 * 
		 * System.out.println("Queue"); passQ.printPassegerQueue();
		 */

	}

}
