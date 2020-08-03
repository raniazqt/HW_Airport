package com.hw.airport.config;

import com.hw.airport.model.ActiveFlight;
import com.hw.airport.model.Booking;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirportSimulator {

	// ratio of number of passengers in queue to number of opened checkin desks
	static int passToDeskRatio = 5;
	// rate for adding passengers to queue in seconds
	static int queuePopulatingRate;
	// maximum number of allowed check-in desks
	static int maxOpndCheckinDesk;
	// Simulator execution rate
	static int simExcRate;

	private static AirportSimulator simulator;

	private AirportSimulator() {

	}

	public static AirportSimulator getInstnce() {
		if (simulator == null) {
			simulator = new AirportSimulator();
			// collect the settings from the user and create the simulator
			// TODO:launch user interface to read the simulator settings
			// TODO: Ask user about the flights to check in and the time, max size of the
			// queue, how often to fill the queue

			// queuePopulatingRate = 6000;
			// maxOpndCheckinDesk = 2;
			// passToDeskRatio = 5;

		}
		return simulator;
	}

	public int getPassToDeskRatio() {
		return passToDeskRatio;
	}

	public static int getQueuePopulatingRate() {
		return queuePopulatingRate;
	}

	public static int getMaxOpndCheckinDesk() {
		return maxOpndCheckinDesk;
	}

	public static int getSimExcRate() {
		return simExcRate;
	}

	public void setPassToDeskRatio(int passToDeskRatio) {
		this.passToDeskRatio = passToDeskRatio;
	}

	public void setQueuePopulatingRate(int queuePopulatingRate) {
		this.queuePopulatingRate = queuePopulatingRate;
	}

	public void setMaxOpndCheckinDesk(int maxOpndCheckinDesk) {
		this.maxOpndCheckinDesk = maxOpndCheckinDesk;
	}

	public void setSimExcRate(int simExcRate) {
		this.simExcRate = simExcRate;
	}

	public static AirportSimulator getSimulator() {
		return simulator;
	}
	
}
