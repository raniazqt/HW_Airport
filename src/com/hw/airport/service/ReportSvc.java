package com.hw.airport.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import com.hw.airport.model.Booking;
import com.hw.airport.model.ReportData;

public interface ReportSvc {
	
	public void generateSummaryReportForAllFlights() throws FileNotFoundException, IOException;
	ReportData generateSummaryReportPerFlight(String flightCode, List<Booking> bookings);
	void writeToReportFile();

}
