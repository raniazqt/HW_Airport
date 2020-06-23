package com.hw.airport.main;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.config.AppContainer;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.PassengerQueue;
import com.hw.airport.service.QueueSvc;

public class QueueTimer extends TimerTask{

	AirportSimulator simulator = AirportSimulator.getInstnce();
	QueueSvc queueSvc = AppContainer.getQueueSvc();
	@Override
	public void run() {
		//TODO:logger
		populateQueueTask();
		System.out.println("passenger was added");
	}
	private void populateQueueTask() {
		PassengerQueue queue = AppContainer.getCheckInQueue();
		try {
			queueSvc.addPassengerToQueue();
		} catch (HWAirportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(queue.getQueueSize());
	}
}
