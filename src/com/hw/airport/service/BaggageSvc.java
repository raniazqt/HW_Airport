package com.hw.airport.service;

import com.hw.airport.exception.HWAirportException;

public interface BaggageSvc {

	public double getTheTotalBagVolumesOnFlight(String flightCode) throws HWAirportException;
	public double getTheTotalBagWeightOnFlight(String flightCode) throws HWAirportException;
}
