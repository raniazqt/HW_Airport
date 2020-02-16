package com.hw.airport.service;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.AppData;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Flight;

public class BaggageSvcImpl implements BaggageSvc {
	
	private AppData appData = AppData.getInstance();
	private FlightSvc flightSvc = new FlightSvcImpl();

	@Override
	public double getTheTotalBagVolumesOnFlight(String flightCode) throws HWAirportException {
		Flight flight = flightSvc.getFlightByCode(flightCode);
		if(flight == null) {
			throw new HWAirportException("no flight was found using the provided flight code");
		}

		double totalVolume = 0.0;
		for(Booking booking : appData.getBookingList().values()) {
			boolean isBookingOnFlight = (booking.getFlightCode().equals(flight.getCode()));
			if(isBookingOnFlight) {
				totalVolume += booking.getTotalBaggageVolume();
			}
		}

		return totalVolume;
	}

	@Override
	public double getTheTotalBagWeightOnFlight(String flightCode) throws HWAirportException {
		Flight flight = flightSvc.getFlightByCode(flightCode);
		if(flight == null) {
			throw new HWAirportException("no flight was found using the provided flight code");
		}

		double totalBaggageWeight = 0.0;
		for(Booking booking : appData.getBookingList().values()) {
			boolean isBookingOnFlight = (booking.getFlightCode().equals(flight.getCode()));
			if(isBookingOnFlight) {
				totalBaggageWeight += booking.getTotalBaggageWeight();
			}
		}

		return totalBaggageWeight;
	}
}
