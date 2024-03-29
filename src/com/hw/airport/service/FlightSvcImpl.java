package com.hw.airport.service;

import com.hw.airport.config.AppContainer;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.exception.InvalidFlightCodeException;
import com.hw.airport.exception.MissingFlightException;
import com.hw.airport.model.AppData;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Booking.BookingStatus;
import com.hw.airport.model.Flight;
import com.hw.airport.model.Passenger.CheckInProgress;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class FlightSvcImpl implements FlightSvc {
	

//	BookingSvc bookingSvc = AppContainer.getBookingSvc();

	private Map<String, Flight> flights = AppData.getFlightsInfo();
private BookingSvc bookingSvc = AppContainer.getBookingSvc();

	/**
	 * @param flightCode the flight code to check
	 * @return the number of checked in passengers on a given flight as per
	 *         flightCode.
	 * @throws HWAirportException throws an invalid flight code exception if no
	 *                            flight is found.
	 */
	
	
	@Override
	public int getPassengerCountForFlight(String flightCode) throws HWAirportException {
		int currentCheckedInPsngrCount = 0;
		if (flightCode.equalsIgnoreCase("")) {
			throw new InvalidFlightCodeException();
		}

		List<Booking> bookingsForFlight = bookingSvc .findAllBookingForFlight(flightCode);
		for (Booking booking : bookingsForFlight) {
			if (booking.getCheckInStatus() == BookingStatus.CHECKED_IN) {
				currentCheckedInPsngrCount++;
			}
		}
		return currentCheckedInPsngrCount;
	}

	/**
	 * gets the maximum allowed volume per flight, this is important to know if we
	 * are over the volume limit.
	 * 
	 * @param flightCode the flight to find the max volume for.
	 * @return the max volume
	 * @throws HWAirportException throws missing flight exception if no flight is
	 *                            found with the given flight code.
	 */
	@Override
	public double getMaxVolumePerBagForFlight(String flightCode) throws HWAirportException {
		Flight flight = flights .get(flightCode);
		if (flight == null) {
			throw new MissingFlightException(flightCode, "flight service");
		}
		return flight.getMaxBagVolume();
	}

	/**
	 * gets the maximum allowed weight per bag for a given flight.
	 * 
	 * @param flightCode flight code to fetch the flight.
	 * @return the max weight for the given flight.
	 * @throws HWAirportException throws a missing flight exception if no flight is
	 *                            found with the given flight code.
	 */
	@Override
	public double getMaxWeightPerBagForFlight(String flightCode) throws HWAirportException {
		Flight flight = flights.get(flightCode);
		if (null == flight) {
			throw new MissingFlightException(flightCode, "flight service");
		}
		return flight.getMaxBagWeight();
	}

	/**
	 * gets the maximum capacity of passengers for a given flight.
	 * 
	 * @param flightCode the flight code to fetch the flight.
	 * @return returns the maximum count of passengers.
	 * @throws HWAirportException throws a missing flight exception if no flight is
	 *                            found given the flight code.
	 */
	@Override
	public double getFlightMaxPassengerCount(String flightCode) throws HWAirportException {
		Flight flight = flights.get(flightCode);
		if (null == flight) {
			throw new MissingFlightException(flightCode, "flight service");
		}
		return flight.getMaxPasngrCnt();
	}

	/**
	 * checks to see if the maximum volume for a given flight is exceeded.
	 * 
	 * @param flightCode  the flight code to fetch the flight.
	 * @param totalVolume total volume to check against
	 * @return boolean signaling if max weight exceeded.
	 * @throws HWAirportException throws missing flight exception if no flight is
	 *                            found given the flight code.
	 */
	@Override
	public boolean isMaxVolumeExceededForFlight(String flightCode, double totalVolume) throws HWAirportException {
		Flight flight = flights.get(flightCode);
		if (null == flight) {
			throw new MissingFlightException(flightCode, "flight service");
		}
		return totalVolume > flight.getMaxFlightVolume();
	}

	/**
	 * @param flightCode  flight code for the flight we're checking for.
	 * @param totalWeight total weight accumilated so far for the given flight.
	 * @return a boolean indicating if the total weight so far exceeds the maximum
	 *         allowed weight for the flight.
	 * @throws HWAirportException throws a missing flight exception if no flight is
	 *                            found with the given flight code.
	 */
	@Override
	public boolean isMaxWeightExceededForFlight(String flightCode, double totalWeight) throws HWAirportException {
		Flight flight = flights.get(flightCode);
		if (null == flight) {
			throw new MissingFlightException(flightCode, "flight service");
		}
		return totalWeight > flight.getMaxFlightWeight();
	}

	/**
	 * @param flightCode     flight code for the flight we're checking for.
	 * @param totalPassenger total passengers checked in the our given flight so
	 *                       far.
	 * @return a boolean indicating if we exceeded the total passengers allowed for
	 *         the flight.
	 * @throws HWAirportException throws a missing flight exception if no flight is
	 *                            found with the given flightCode.
	 */
	@Override
	public boolean isMaxPassengerCountExceededForFlight(String flightCode, int totalPassenger)
			throws HWAirportException {
		Flight flight = flights.get(flightCode);
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
		Flight flight = flights.get(code.toLowerCase());
		return flight;
	}

	@Override
	public Map<String, Flight> getFlights() {
		return flights;
	}

	@Override
	public void setFlights(Map<String, Flight> flights) {
		this.flights = flights;
	}
	
	/*
	 * public void flightCapacity() {
	 * 
	 * int passFilled = 0; int passMax = this.plane.getMaxPasngrCnt(); double
	 * volFilled = 0; double volMax = this.plane.getMaxBagVolume(); double
	 * weightFilled = 0; double weightMax = this.plane.getMaxFlightWeight();
	 * 
	 * try { passFilled =
	 * appData.getBookingSvc().getCountOfCheckedInPassengersByFlight(this.plane.
	 * getCode()); volFilled =
	 * appData.getBaggageSvc().getTheTotalBagVolumesOnFlight(this.plane.getCode());
	 * weightFilled =
	 * appData.getBaggageSvc().getTheTotalBagWeightOnFlight(this.plane.getCode());
	 * 
	 * int passCapacity = passMax - passFilled; double bagCapacity = (volMax -
	 * volFilled) + (weightMax - weightFilled); double capacity = passCapacity +
	 * bagCapacity;
	 * 
	 * if (capacity == 0) {
	 * 
	 * this.clearDesk();
	 * 
	 * }
	 * 
	 * } catch (HWAirportException e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * }
	 * 
	 */
	
	

}
