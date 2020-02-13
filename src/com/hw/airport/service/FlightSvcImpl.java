package com.hw.airport.service;

import com.hw.airport.model.AppData;
import com.hw.airport.model.Flight;

public class FlightSvcImpl implements FlightSvc {
	AppData appData = AppData.getInstance();

	@Override
	public double getMaxVolumePerBagForFlight(String flightCode) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getMaxWeightPerBagForFlight(String flightCode) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getFlightMaxCapacity(String flightCode) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isMaxVolumeExceededForFlight(String flightCode, double totalVolum) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Flight getFlightByCode(String code) {
		return appData.flightsInfo.get(code);
	}

}
