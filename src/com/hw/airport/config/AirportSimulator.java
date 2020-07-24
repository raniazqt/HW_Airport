package com.hw.airport.config;

import java.util.ArrayList;
import java.util.List;

import com.hw.airport.model.ActiveFlight;
import com.hw.airport.model.PassengerQueue;

public class AirportSimulator {

	//flights to check in ( flight code , check in period in seconds)
	static List<ActiveFlight> activeFlights = new ArrayList<>();
	//ratio of number of passengers in queue to number of opened checkin desks
	static int passToDeskRatio;
	//rate for adding passengers to queue in seconds
	static long queuePopulatingRate;
	//maximum number of allowed check-in desks
	static int maxOpndCheckinDesk;
	//Simulator execution rate
	static long simExcRate;

	private static AirportSimulator simulator;

	private AirportSimulator() {

	}

	public static AirportSimulator getInstnce() {
		if (simulator == null) {
			simulator = new AirportSimulator();
			//collect the settings from the user and create the simulator
			//TODO:launch user interface to read the simulator settings		
			//TODO: Ask user about the flights to check in and the time, max size of the queue, how often to fill the queue 
			
			queuePopulatingRate = 6000;
			maxOpndCheckinDesk = 1;
			passToDeskRatio = 5;

		}
		return simulator;
	}

	
	public int getPassToDeskRatio() {
		return passToDeskRatio;
	}

	public static double getQueuePopulatingRate() {
		return queuePopulatingRate;
	}

	public static double getMaxOpndCheckinDesk() {
		return maxOpndCheckinDesk;
	}

	public static double getSimExcRate() {
		return simExcRate;
	}

	public void setPassToDeskRatio(int passToDeskRatio) {
		this.passToDeskRatio = passToDeskRatio;
	}

	public void setQueuePopulatingRate(long queuePopulatingRate) {
		this.queuePopulatingRate = queuePopulatingRate;
	}

	public void setMaxOpndCheckinDesk(int maxOpndCheckinDesk) {
		this.maxOpndCheckinDesk = maxOpndCheckinDesk;
	}

	public void setSimExcRate(long simExcRate) {
		this.simExcRate = simExcRate;
	}

	public static AirportSimulator getSimulator() {
		return simulator;
	}
	
	
	
	
	
	

}
