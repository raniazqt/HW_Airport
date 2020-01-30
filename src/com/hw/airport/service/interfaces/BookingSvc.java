package com.hw.airport.service.interfaces;

public interface BookingSvc {
	public double calculateExtraBaggageCharge(String flightCode, int baggageCnt);
	public double getExtraBaggageChargeByFlight(String flightCode);
	
	

}
