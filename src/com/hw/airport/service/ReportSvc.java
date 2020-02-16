package com.hw.airport.service;

import java.util.List;
import java.util.Map;

import com.hw.airport.model.Booking;

public interface ReportSvc {
	
	public Map<String, List<Booking>> generateSummaryReportForAllFlights();
	void generateSummaryReportPerFlight(String flightCode, List<Booking> bookings);

}
