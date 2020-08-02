package com.hw.airport.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.config.AppContainer;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.ActiveFlight;
import com.hw.airport.model.AppData;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Flight;
import com.hw.airport.model.FlightExtrasAndCharges;
import com.hw.airport.model.ReportData;

public class ReportSvcImpl implements ReportSvc {

	private BookingSvc bookingSvc = AppContainer.getBookingSvc();
	private FlightSvc flightSvc = AppContainer.getFlightSvc();
	private BaggageSvc baggageSvc = AppContainer.getBaggageSvc();
	AppData data = AppData.getInstance();

	private AirportSimulator airSim = AirportSimulator.getInstnce();

	public void getFlightReport() {

		try {
			Files.deleteIfExists(Paths.get("./resources/files/FlightsReport.txt"));

		} catch (NoSuchFileException e) {
			System.out.println("No such file/directory exists");
		} catch (DirectoryNotEmptyException e) {
			System.out.println("Directory is not empty.");
		} catch (IOException e) {
			System.out.println("Invalid permissions.");
		}

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

			for (ActiveFlight flight : airSim.getActiveFlight()) {
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

	@Override
	public ReportData generateSummaryReportPerFlight(String flightCode, List<Booking> bookings) {

		int psgrCnt = 0;

		ReportData data = new ReportData();
		FlightExtrasAndCharges xtraCharge = new FlightExtrasAndCharges();

		Flight flight = flightSvc.getFlightByCode(flightCode);

		if (null == flight) {
			// do something
		}

		data.setFlightCode(flightCode);
		/**
		 * try { xtraCharge = bookingSvc.calculateExtraChargeForFlight(flightCode); }
		 * catch (HWAirportException e) { // TODO Auto-generated catch block }
		 */
		try {
			psgrCnt = bookingSvc.getCountOfCheckedInPassengersByFlight(flightCode);
		} catch (HWAirportException e) {
			// TODO Auto-generated catch block
		}
		double totalVol = 0;
		try {
			totalVol = baggageSvc.getTheTotalBagVolumesOnFlight(flightCode);
		} catch (HWAirportException e) {
			// TODO Auto-generated catch block
		}
		double totalWgth = 0;

		try {
			totalWgth = baggageSvc.getTheTotalBagWeightOnFlight(flightCode);
		} catch (HWAirportException e) {
			// TODO Auto-generated catch block
		}

		data.setTotalPsgrCnt(psgrCnt);
		data.setTotalVolume(totalVol);
		data.setTotalWeight(totalWgth);
		data.setXtraPaidFees(xtraCharge.getXtraWeightCharge() + xtraCharge.getXtraVolumeCharge());

		if (data.getTotalPsgrCnt() > flight.getMaxPasngrCnt()) {
			data.setExceededPsngrCnt(true);
		}

		if (data.getTotalVolume() > flight.getMaxFlightVolume()) {
			data.setExceededVolume(true);
		}

		if (data.getTotalWeight() > flight.getMaxFlightWeight()) {
			data.setExceededWeight(true);
		}
		return data;

	}

	@Override
	public void generateSummaryReportForAllFlights() throws FileNotFoundException, IOException {
		Map<String, List<Booking>> bookingsByFlight = bookingSvc.groupBookingByFlightCode();
		ReportData data;
		List<ReportData> reportDataList = new ArrayList<ReportData>();
		for (String b : bookingsByFlight.keySet()) {
			try {
				data = this.generateSummaryReportPerFlight(b, bookingsByFlight.get(b));
				reportDataList.add(data);
			} catch (Exception ex) {

			}
		}
		this.writToTxtFile(reportDataList);
	}

	public void writToTxtFile(List<ReportData> data) throws FileNotFoundException, IOException {

		try {
			Files.deleteIfExists(Paths.get("./resources/files/FlightSummaryReport.txt"));

		} catch (NoSuchFileException e) {
			System.out.println("No such file/directory exists");
		} catch (DirectoryNotEmptyException e) {
			System.out.println("Directory is not empty.");
		} catch (IOException e) {
			System.out.println("Invalid permissions.");
		}

		File output = new File("./resources/files/FlightSummaryReport.txt");
		FileWriter fr = null;
		BufferedWriter br = null;

		fr = new FileWriter(output);
		br = new BufferedWriter(fr);

		String newLine = System.getProperty("line.separator");
		try {
			br.write(String.format("%-20s", "Flight#") + String.format("%-20s", "Passengers Count")
					+ String.format("%-20s", "Total Volume") + String.format("%-20s", "Total Weight")
					+ String.format("%-20s", "Extra Fees") + String.format("%-20s", "Extra Pasgr")
					+ String.format("%-20s", "Extra Weight") + String.format("%-20s", "Extra Volume") + newLine);

			for (ReportData flight : data) {
				br.write(String.format("%-20s", flight.getFlightCode().toUpperCase())
						+ String.format("%-20s", flight.getTotalPsgrCnt())
						+ String.format("%-20s", flight.getTotalVolume())
						+ String.format("%-20s", flight.getTotalWeight())
						+ String.format("%-20s", flight.getXtraPaidFees())
						+ String.format("%-20s", (flight.isExceededPsngrCnt() == true ? "Yes" : "N"))
						+ String.format("%-20s", (flight.isExceededWeight() == true ? "Yes" : "N"))
						+ String.format("%-20s", (flight.isExceededVolume() == true ? "Yes" : "N")) + newLine);

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
	public void writeToReportFile() {
		// TODO Auto-generated method stub

	}

}
