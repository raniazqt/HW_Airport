package com.hw.airport.service;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Flight;

public interface FlightSvc {

	// Is flight full or not? 
	// details of passenger 
	// flight service and chcekin service 
	// public int getPassengerCountForFlight(String flightCode) throws HWAirportException;
	public int getPassengerCountForFlight(String flightCode) throws HWAirportException;
	public double getMaxVolumePerBagForFlight(String flightCode) throws HWAirportException;
	public double getMaxWeightPerBagForFlight(String flightCode) throws HWAirportException;
	public double getFlightMaxPassengerCount(String flightCode) throws HWAirportException;
	public boolean isMaxVolumeExceededForFlight(String flightCode, double totalVolum) throws HWAirportException;
	public boolean isMaxWeightExceededForFlight(String flightCode, double totalWeight) throws HWAirportException;
	public boolean isMaxPassengerCountExceededForFlight(String flightCode, int totalPassenger) throws HWAirportException;
	
	public Flight getFlightByCode(String code);
	
}