package com.hw.airport.service;

public interface CheckInSvc {
	public double calculateExtraBaggageCharge(String flightCode, int baggageCnt);
	public double getExtraBaggageChargeByFlight(String flightCode);
	public boolean doCheckIn(String lastName, String bookingRef);
	
	

}
