package com.hw.airport.service;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.AppData;
import com.hw.airport.model.Flight;

public class FlightSvcImpl implements FlightSvc {
	AppData appData = AppData.getInstance();

	@Override
	public double getMaxVolumePerBagForFlight(String flightCode) throws HWAirportException {
		Flight flight = appData.getFlightsInfo().get(flightCode);
		if (null == flight) {
			throw new HWAirportException("No flight was found with the code " + flightCode);
		}
		return flight.getMaxBagVolume();
	}

	@Override
	public double getMaxWeightPerBagForFlight(String flightCode) throws HWAirportException {
		Flight flight = appData.getFlightsInfo().get(flightCode);
		if (null == flight) {
			throw new HWAirportException("No flight was found with the code " + flightCode);
		}
		return flight.getMaxBagWeight();
	}

	@Override
	public double getFlightMaxCapacity(String flightCode) throws HWAirportException {
		Flight flight = appData.getFlightsInfo().get(flightCode);
		if (null == flight) {
			throw new HWAirportException("No flight was found with the code " + flightCode);
		}
		return flight.getMaxPasngrCnt();
	}

	@Override
	public boolean isMaxVolumeExceededForFlight(String flightCode, double totalVolume) throws HWAirportException {
		Flight flight = appData.getFlightsInfo().get(flightCode);
		if (null == flight) {
			throw new HWAirportException("No flight was found with the code " + flightCode);
		}
		return flight.getMaxBagVolume() > totalVolume;
	}
	
	@Override
	public Flight getFlightByCode(String code) {
		Flight flight = appData.getFlightsInfo().get(code);
		return flight;
	}

}
