package com.hw.airport.service;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.model.ActiveFlight;
import com.hw.airport.model.AppData;
import com.hw.airport.model.Booking;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class ReportSvcImpl implements ReportSvc {

	private AppData data = AppData.getInstance();
//	private AirportSimulator airSim = AirportSimulator.getInstnce();

	@Override
	public void getFlightReport() {

		/*
		 * try { Files.deleteIfExists(Paths.get("./resources/files/FlightsReport.txt"));
		 * 
		 * } catch (NoSuchFileException e) {
		 * System.out.println("No such file/directory exists"); } catch
		 * (DirectoryNotEmptyException e) {
		 * System.out.println("Directory is not empty."); } catch (IOException e) {
		 * System.out.println("Invalid permissions."); }
		 */

		File output = new File("./resources/files/FlightsReport.txt");
		FileWriter fr = null;
		BufferedWriter br = null;

		try {
			fr = new FileWriter(output);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		br = new BufferedWriter(fr);

		String newLine = System.getProperty("line.separator");
		try {
			br.write(String.format("%-20s", "Flight#") + String.format("%-20s", "Passengers Count")
					+ String.format("%-20s", "Total Volume") + String.format("%-20s", "Total Weight")
					+ String.format("%-20s", "Extra Fees") + newLine);

			for (ActiveFlight flight : data.getActiveFlights()) {
				br.write(String.format("%-20s", flight.getFlightCd())
						+ String.format("%-20s", flight.getBoardedPsngrCnt())
						+ String.format("%-20s", flight.getTotalVolume())
						+ String.format("%-20s", flight.getTotalWeight())
						+ String.format("%-20s", flight.getXtraChargeCollected()) + newLine);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void getSuccPassengerReport() {

		try {
			Files.deleteIfExists(Paths.get("./resources/files/PassengerSucessReport.txt"));

		} catch (NoSuchFileException e) {
			System.out.println("No such file/directory exists");
		} catch (DirectoryNotEmptyException e) {
			System.out.println("Directory is not empty.");
		} catch (IOException e) {
			System.out.println("Invalid permissions.");
		}

		File output = new File("./resources/files/PassengerSucessReport.txt");
		FileWriter fr = null;
		BufferedWriter br = null;

		try {
			fr = new FileWriter(output);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		br = new BufferedWriter(fr);
		String newLine = System.getProperty("line.separator");

		Map<String, List<Booking>> psngerMap = data.getCheckedInPsngrsByFlight();

		for (Map.Entry<String, List<Booking>> entry : psngerMap.entrySet()) {

			String key = entry.getKey();
			try {
				br.write(String.format("%-20s", "Flight#") + newLine + String.format("%-20s", key) + newLine
						+ String.format("%-20s", "Reference Code") + String.format("%-20s", "Passengers Name")
						+ String.format("%-20s", "Total Weight") + String.format("%-20s", "Total Volume")
						+ String.format("%-20s", "Extra Fees") +String.format("%-20s", "Check In Status")+ newLine);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (Booking passenger : entry.getValue()) {

				try {
					br.write(String.format("%-20s", passenger.getRefCode())
							+ String.format("%-20s", passenger.getFullName())
							+ String.format("%-20s", passenger.getTotalBaggageWeight())
							+ String.format("%-20s", passenger.getTotalBaggageVolume())
							+ String.format("%-20s",
									String.valueOf((passenger.getXtraBagVolChrg() + passenger.getXtraBagWghtChrg())))
							+ String.format("%-20s", passenger.getCheckInStatus()) + newLine);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	@Override
	public void getFailPassengerReport() {

		try {
			Files.deleteIfExists(Paths.get("./resources/files/PassengerFailReport.txt"));

		} catch (NoSuchFileException e) {
			System.out.println("No such file/directory exists");
		} catch (DirectoryNotEmptyException e) {
			System.out.println("Directory is not empty.");
		} catch (IOException e) {
			System.out.println("Invalid permissions.");
		}

		File output = new File("./resources/files/PassengerFailReport.txt");
		FileWriter fr = null;
		BufferedWriter br = null;

		try {
			fr = new FileWriter(output);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		br = new BufferedWriter(fr);
		String newLine = System.getProperty("line.separator");

		Map<String, List<Booking>> psngerMap = data.getFailedToChkInPsngrsByFlight();

		for (Map.Entry<String, List<Booking>> entry : psngerMap.entrySet()) {

			String key = entry.getKey();
			try {
				br.write(String.format("%-20s", "Flight#") + newLine + String.format("%-20s", key) + newLine
						+ String.format("%-20s", "Reference Code") + String.format("%-20s", "Passengers Name")
						+ String.format("%-20s", "Total Weight") + String.format("%-20s", "Total Volume")
						+ String.format("%-20s", "Extra Fees") +String.format("%-20s", "Check In Status")+ newLine);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (Booking passenger : entry.getValue()) {

				try {
					br.write(String.format("%-20s", passenger.getRefCode())
							+ String.format("%-20s", passenger.getFullName())
							+ String.format("%-20s", passenger.getTotalBaggageWeight())
							+ String.format("%-20s", passenger.getTotalBaggageVolume())
							+ String.format("%-20s",
									String.valueOf((passenger.getXtraBagVolChrg() + passenger.getXtraBagWghtChrg())))
							+ String.format("%-20s", passenger.getCheckInStatus()) + newLine);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
}
