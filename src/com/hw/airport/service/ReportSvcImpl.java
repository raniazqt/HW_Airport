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

		String heading = "Flight Code,Passengers Boarded,Total Extra Baggage Charge, Total Baggage Weight, Total Baggage Volume \n ";

		String report = "";

		for (ActiveFlight flight : airSim.getActiveFlight()) {

			report = report + flight.getFlightCd() + "," + flight.getBoardedPsngrCnt() + ","
					+ flight.getXtraChargeCollected() + "," + flight.getTotalWeight() + "," + flight.getTotalVolume();
			System.out.println("**********************RPT**********");
		}

		report = "Check In Report\n" + heading + report;

		try {
			Files.deleteIfExists(Paths.get("./resources/files/Report.csv"));

		} catch (NoSuchFileException e) {
			System.out.println("No such file/directory exists");
		} catch (DirectoryNotEmptyException e) {
			System.out.println("Directory is not empty.");
		} catch (IOException e) {
			System.out.println("Invalid permissions.");
		}

		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("./resources/files/Report.csv"));

			writer.write(report);

			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void getSuccPassengerReport() {
		
	
		
	}
	
	public void getFailPassengerReport() {
		
	
		
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
