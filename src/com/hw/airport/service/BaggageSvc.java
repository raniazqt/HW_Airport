package com.hw.airport.service;

public interface BaggageSvc {

	public double getTheTotalBagVolumesOnFlight(String flightCode);
	public double getTheTotalBagWeightOnFlight(String flightCode);
}
