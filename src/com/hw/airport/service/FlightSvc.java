package com.hw.airport.service;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Flight;

public interface FlightSvc {

	
	public double getMaxVolumePerBagForFlight(String flightCode) throws HWAirportException;
	public double getMaxWeightPerBagForFlight(String flightCode) throws HWAirportException;
	public double getFlightMaxCapacity(String flightCode) throws HWAirportException;
	public boolean isMaxVolumeExceededForFlight(String flightCode, double totalVolum) throws HWAirportException;
	public Flight getFlightByCode(String code);
}
