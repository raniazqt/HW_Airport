package com.hw.airport.service;

import com.hw.airport.model.Flight;

public interface FlightSvc {

	
	public double getMaxVolumePerBagForFlight(String flightCode);
	public double getMaxWeightPerBagForFlight(String flightCode);
	public double getFlightMaxCapacity(String flightCode);
	public boolean isMaxVolumeExceededForFlight(String flightCode, double totalVolum);
	public Flight getFlightByCode(String code);
}
