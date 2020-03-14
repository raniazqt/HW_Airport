package com.hw.airport.service;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.exception.MissingFlightException;
import com.hw.airport.model.AppData;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Flight;

public class FlightSvcImpl implements FlightSvc {
	AppData appData = AppData.getInstance();
	
	BaggageSvc baggageService = new BaggageSvcImpl();
	// 1. check if flight is overloaded for volume / weight / passenger count

	
	@Override
	public int getPassengerCountForFlight(String flightCode) throws HWAirportException {
		int currentCheckedInPsngrCount = 0;
		for(Booking booking : appData.getBookingList().values()) {
			boolean isBookingOnFlightAndCheckedIn = (booking.getFlightCode().equals(flightCode)) && booking.isCheckedIn();
			if(isBookingOnFlightAndCheckedIn) {
				currentCheckedInPsngrCount += 1;
			}
		}
		return currentCheckedInPsngrCount;
	}
	
	/**
	 * gets the maximum allowed volume per flight, this is important to know if we are over the volume limit.
	 * @param flightCode the flight to find the max volume for.
	 * @return the max volume
	 * @throws HWAirportException throws missing flight exception if no flight is found with the given flight code.
	 */
	@Override
	public double getMaxVolumePerBagForFlight(String flightCode) throws HWAirportException {
		Flight flight = appData.getFlightsInfo().get(flightCode);
		if (flight == null) {
			throw new MissingFlightException(flightCode, "flight service");
		}
		return flight.getMaxBagVolume();
	}
/** 
	/**
	 * gets the maximum allowed weight per bag for a given flight.
	 * @param flightCode flight code to fetch the flight.
	 * @return the max weight for the given flight.
	 * @throws HWAirportException throws a missing fligt exception if no flight is found with the given flight code.
	 */
	@Override
	public double getMaxWeightPerBagForFlight(String flightCode) throws HWAirportException {
		Flight flight = appData.getFlightsInfo().get(flightCode);
		if (null == flight) {
			throw new MissingFlightException(flightCode, "flight service");
		}
		return flight.getMaxBagWeight();
	}

	/**
	 * gets the maximum capacity of passengers for a given flight.
	 * @param flightCode the flight code to fetch the flight.
	 * @return returns the maximum count of passengers.
	 * @throws HWAirportException throws a missing flight exception if no flight is found given the flight code.
	 */
	@Override
	public double getFlightMaxPassengerCount(String flightCode) throws HWAirportException {
		Flight flight = appData.getFlightsInfo().get(flightCode);
		if (null == flight) {
			throw new MissingFlightException(flightCode, "flight service");
		}
		return flight.getMaxPasngrCnt();
	}

	/**
	 * checks to see if the maximum volume for a given flight is exceeded.
	 * @param flightCode the flight code to fetch the flight.
	 * @param totalVolume total volume to check against
	 * @return boolean signalling if max weight exceeded.
	 * @throws HWAirportException throws missing flight exception if no flight is found given the flight code.
	 */
	@Override
	public boolean isMaxVolumeExceededForFlight(String flightCode, double totalVolume) throws HWAirportException {
		Flight flight = appData.getFlightsInfo().get(flightCode);
		if (null == flight) {
			throw new MissingFlightException(flightCode, "flight service");
		}
		return totalVolume > flight.getMaxFlightVolume();
	}
	
	@Override
	public boolean isMaxWeightExceededForFlight(String flightCode, double totalWeight) throws HWAirportException {
		Flight flight = appData.getFlightsInfo().get(flightCode);
		if (null == flight) {
			throw new MissingFlightException(flightCode, "flight service");
		}
		return totalWeight > flight.getMaxFlightWeight();
	}

	@Override
	public boolean isMaxPassengerCountExceededForFlight(String flightCode, int totalPassenger)
			throws HWAirportException {
		Flight flight = appData.getFlightsInfo().get(flightCode);
		if (null == flight) {
			throw new MissingFlightException(flightCode, "flight service");
		}
		return totalPassenger > flight.getMaxPasngrCnt();
	}
	
	
	/**
	 * fetches flight given a flight code
	 */
	@Override
	public Flight getFlightByCode(String code) {
		Flight flight = appData.getFlightsInfo().get(code);
		return flight;
	}

}
