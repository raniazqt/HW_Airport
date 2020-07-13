package com.hw.airport.main;

import java.util.TimerTask;
import com.hw.airport.config.AppContainer;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking;
import com.hw.airport.service.QueueSvc;

public class QueuePopulatingTask extends TimerTask{

	QueueSvc queueSvc = AppContainer.getQueueSvc();
	@Override
	public void run() {
		//TODO:logger
		try {
			Booking passenger = queueSvc.addPassengerToQueue();
			int queueSize = queueSvc.getCountOfPassangerInQueue();
			String fullName = null;
			if (null != passenger) {
				fullName  = passenger.getFullName();
			}
			System.out.println("Queue Size = " + queueSize + " passenger " + fullName + " was added to the queue ");
		} catch (HWAirportException e) {
			e.printStackTrace();
		}
	}
}
