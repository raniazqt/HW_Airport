package com.hw.airport.main;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.config.AppContainer;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.PassengerQueue;

public class QueueTimer extends TimerTask{

	AppContainer appContainer = AppContainer.getInstance();

	AirportSimulator simulator = AirportSimulator.getInstnce();
	@Override
	public void run() {
		//TODO:logger
		populateQueueTask();
		System.out.println("passenger was added");
	}
	private void populateQueueTask() {
		PassengerQueue queue = appContainer.getCheckInQueue();
		try {
			queue.addPassengerToQueue();
		} catch (HWAirportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(queue.getQueueSize());
	}
}
