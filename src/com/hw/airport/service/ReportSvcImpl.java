package com.hw.airport.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.AppData;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Flight;
import com.hw.airport.model.FlightExtrasAndCharges;
import com.hw.airport.model.ReportData;

public class ReportSvcImpl implements ReportSvc{
	BookingSvc bookingSvc = new BookingSvcImpl();
	FlightSvc flightSvc = new FlightSvcImpl();

	AppData appData = AppData.getInstance();
	private BaggageSvc bagSvc = new BaggageSvcImpl();

	@Override
	public ReportData generateSummaryReportPerFlight(String flightCode, List<Booking> bookings) {

		int psgrCnt = 0;

		ReportData data = new ReportData();
		FlightExtrasAndCharges xtraCharge = new FlightExtrasAndCharges() ;

		Flight flight = flightSvc.getFlightByCode(flightCode);

		if (null == flight) {
			//do something
		}

		data.setFlightCode(flightCode);
		try {
			xtraCharge = bookingSvc.calculateExtraChargeForFlight(flightCode);
		} catch (HWAirportException e) {
			// TODO Auto-generated catch block
		}
		try {
			psgrCnt = bookingSvc.getCountOfCheckedInPassengersByFlight(flightCode);
		} catch (HWAirportException e) {
			// TODO Auto-generated catch block
		}
		double totalVol = 0;
		try {
			totalVol= bagSvc.getTheTotalBagVolumesOnFlight(flightCode);
		} catch (HWAirportException e) {
			// TODO Auto-generated catch block
		}
		double totalWgth = 0;

		try {
			totalWgth= bagSvc.getTheTotalBagWeightOnFlight(flightCode);
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
		List<ReportData> reportDataList= new ArrayList<ReportData>();
		for (String b : bookingsByFlight.keySet() ) {
			try {
				data = this.generateSummaryReportPerFlight(b, bookingsByFlight.get(b));
				reportDataList.add(data);
			}catch (Exception ex){

			}
		}
		this.writToTxtFile(reportDataList);
	}

	public void writToTxtFile(List<ReportData> data) throws FileNotFoundException, IOException {
		File output = new File("./resources/files/FlightSummaryReport.txt"); 
		//String newLine = System.getProperty("line.separator");

		//File output = new File("BookingReport.txt"); 
		FileWriter fr = null;
		BufferedWriter br = null;

		fr = new FileWriter(output);
		br = new BufferedWriter(fr);

		String newLine = System.getProperty("line.separator");
		try {
			br.write(
					String.format("%-20s", "Flight#") 
					+ String.format("%-20s","Passengers Count")											
					+ String.format("%-20s","Total Volume") 
					+ String.format("%-20s","Total Weight")
					+ String.format("%-20s","Extra Fees")
					+ String.format("%-20s","Extra Pasgr") 
					+ String.format("%-20s","Extra Weight")
					+ String.format("%-20s","Extra Volume")
					+ newLine);

			for (ReportData flight : data) {
				br.write(
						String.format("%-20s",flight.getFlightCode().toUpperCase())  
						+ String.format("%-20s", flight.getTotalPsgrCnt()) 
						+ String.format("%-20s",flight.getTotalVolume())
						+ String.format("%-20s", flight.getTotalWeight())
						+ String.format("%-20s",flight.getXtraPaidFees())    						 
						+ String.format("%-20s",(flight.isExceededPsngrCnt()==true?"Yes" : "N"))
						+ String.format("%-20s",(flight.isExceededWeight()==true?"Yes" : "N")) 
						+ String.format("%-20s",(flight.isExceededVolume()==true?"Yes" : "N"))
						+ newLine);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
