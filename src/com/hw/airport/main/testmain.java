package com.hw.airport.main;

import com.hw.airport.GUI_S2.AirportGUIImpl;
import com.hw.airport.config.AppContainer;
import com.hw.airport.model.AppData;
import com.hw.airport.model.PassengerQueue;
import com.hw.airport.service.QueueSvc;

public class testmain {

	public static void main(String[] args) throws Exception {
		ApplicationManager manager = new ApplicationManager();
		
		QueueSvc queueSvc;

		new AirportGUIImpl();
		AppContainer.getDataSvc();
		queueSvc = AppContainer.getQueueSvc();

		// any setup logic here.
		// PassengerQueue passQ = new PassengerQueue();

		AppData appData = AppData.getInstance();

		PassengerQueue passQ = AppContainer.getCheckInQueue();
		
		manager.InitializeApplication();
		
	//	DeskSvc checkDesk = new DeskSvcImpl();
		
		

		passQ.getPassengerList();			

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
