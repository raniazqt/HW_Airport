package com.hw.airport.service;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.exception.MissingFlightException;
import com.hw.airport.exception.NegativeBaggageVolumeException;
import com.hw.airport.exception.NegativeBaggageWeightException;
import com.hw.airport.model.AppData;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Flight;

public class BaggageSvcImpl implements BaggageSvc {
	
	private AppData appData = AppData.getInstance();
	private FlightSvc flightSvc = new FlightSvcImpl();

	/**
	 * gets total volume on a flight.
	 * @param flightCode the provided flight code, if no flight is found an exception is thrown
	 * @return the total baggage volume for the entire flight
	 * @throws HWAirportException throws a missingFlightException if no flight was found.
	 */
	@Override
	public double getTheTotalBagVolumesOnFlight(String flightCode) throws HWAirportException {
		Flight flight = flightSvc.getFlightByCode(flightCode);
		if(flight == null) {
			throw new MissingFlightException(flightCode, "baggage service");
		}

		double totalVolume = 0.0;
		for(Booking booking : appData.getBookingList().values()) {
			boolean isBookingOnFlight = (booking.getFlightCode().equals(flight.getCode()));
			if(isBookingOnFlight) {
				totalVolume += booking.getTotalBaggageVolume();
			}
		}

		if(totalVolume < 0.0) {
			throw new NegativeBaggageVolumeException();
		}

		return totalVolume;
	}

	/**
	 * gets total weight for bags on a flight.
	 * @param flightCode the provided flight code, if no flight is found an exception is thrown
	 * @return the total baggage weight currently on the flight.
	 * @throws HWAirportException  throws a missingFlightException if no flight was found.
	 */
	@Override
	public double getTheTotalBagWeightOnFlight(String flightCode) throws HWAirportException {
		Flight flight = flightSvc.getFlightByCode(flightCode);
		if(flight == null) {
			throw new MissingFlightException(flightCode, "baggage service");
		}

		double totalBaggageWeight = 0.0;
		for(Booking booking : appData.getBookingList().values()) {
			boolean isBookingOnFlight = (booking.getFlightCode().equalsIgnoreCase(flight.getCode()));
			if(isBookingOnFlight) {
				totalBaggageWeight += booking.getTotalBaggageWeight();
			}
		}

		if(totalBaggageWeight < 0.0) {
			throw new NegativeBaggageWeightException();
		}

		return totalBaggageWeight;
	}
}
