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

	// flights to check in ( flight code , check in period in seconds)
	static List<ActiveFlight> activeFlights = new ArrayList<>();
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

	public static List<ActiveFlight> getActiveFlight() {
		return activeFlights;
	}

	public static String genReport() {

		int totalPassengers = 0;
		int totalCharge = 0;
		int totalBaggageWeight = 0;
		int totalBaggageVol = 0;
		String heading = "Flight Code,Passengers Boarded,Total Extra Baggage Charge, Total Baggage Weight, Total Baggage Volume \n ";
		String total = "";
		String report = "";

		for (ActiveFlight flight : AirportSimulator.getActiveFlight()) {
			totalPassengers += flight.getBoardedPsngrCnt();
			totalCharge += flight.getXtraChargeCollected();
			totalBaggageWeight += flight.getTotalWeight();
			totalBaggageVol += flight.getTotalVolume();

			report = report + flight.getFlightCd() + "," + flight.getBoardedPsngrCnt() + ","
					+ flight.getXtraChargeCollected() + "," + flight.getTotalWeight() + "," + flight.getTotalVolume();

		}

		total = "Passengers Checked In,Excess Baggage Charge,Checked In Baggage Weight,Checked In Baggage Volume\n"
				+ totalPassengers + "," + totalCharge + "," + totalBaggageWeight + "," + totalBaggageVol + "\n";

		report = "Check In Report\n" + "Desk Totals\n" + total + heading + report;

		return report;
	}

	public static void saveReport(String report) throws IOException {

		try {
			Files.deleteIfExists(Paths.get("./resources/files/Report.csv"));

		} catch (NoSuchFileException e) {
			System.out.println("No such file/directory exists");
		} catch (DirectoryNotEmptyException e) {
			System.out.println("Directory is not empty.");
		} catch (IOException e) {
			System.out.println("Invalid permissions.");
		}

		BufferedWriter writer = new BufferedWriter(new FileWriter("./resources/files/Report.csv"));
		writer.write(report);

		writer.close();
	}

}
