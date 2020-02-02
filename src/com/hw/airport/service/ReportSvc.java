package com.hw.airport.service;

public interface ReportSvc {
	
	public void generateSummaryReportPerFlight(String flightCode);
	public void generateSummaryReportForAllFlights();

}
