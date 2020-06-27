package com.hw.airport.config;

import java.util.ArrayList;
import java.util.List;

import com.hw.airport.model.FlightSettings;
import com.hw.airport.model.PassengerQueue;

public class AirportSimulator {

	//flights to check in ( flight code , check in period in seconds)
	static List<FlightSettings> activeFlights = new ArrayList<>();
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
			activeFlights.add(new FlightSettings("ABC123", 10));
			activeFlights.add(new FlightSettings("XYZ123", 10));
			queuePopulatingRate = 600;
			maxOpndCheckinDesk = 2;
			passToDeskRatio = 5;

		}
		return simulator;
	}

	public static List<FlightSettings> getActiveFlights() {
		return activeFlights;
	}

	public int getPassToDeskRatio() {
		return passToDeskRatio;
	}

	public static long getQueuePopulatingRate() {
		return queuePopulatingRate;
	}

	public static int getMaxOpndCheckinDesk() {
		return maxOpndCheckinDesk;
	}

	public static long getSimExcRate() {
		return simExcRate;
	}

	public static void setActiveFlights(List<FlightSettings> activeFlights) {
		AirportSimulator.activeFlights = activeFlights;
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
	
	
	
	
	
	

}
