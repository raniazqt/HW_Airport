package com.hw.airport.service;

import java.util.List;
import java.util.Map;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.ActiveFlight;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Flight;

public interface DataSvc {
	public Map<String, Flight> loadFlightsData(String flightsFileName) throws HWAirportException ;

	public Map<String, Booking> loadBookingData(String bookingFileName) ;


	void updateActiveFlight(String flightCd, int psngrCnt, double weight, double volume, double totalChg);

	public List<ActiveFlight> getFlightsActivelyBoarding();

	public void addPsgrToCheckedInList(Booking passenger);

	public void addPsgrToFailedToCheckedList(Booking passenger);

	default ActiveFlight getActiveFlight(String flightCd) {
		List<ActiveFlight> activeFlights = getFlightsActivelyBoarding();
	
		for(ActiveFlight flight : activeFlights){
			if (flight.getFlightCd().equalsIgnoreCase(flightCd)) {
				return flight;
			}
		}
		return null;
	}

}
