package com.hw.airport.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.ActiveFlight;
import com.hw.airport.model.AppData;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Booking.BookingStatus;
import com.hw.airport.model.Flight;
import com.hw.airport.util.FileHandler;

public class DataSvcImpl extends Observable implements DataSvc {

	/**
	 * loads file data from the flight file line by line.
	 * @param flightsFileName the file name for flight details.
	 * @return returns a hash map of (flight details, flight code).
	 * @throws HWAirportException throws a ParsingFileError.
	 */
	@Override
	public Map<String, Flight> loadFlightsData(String flightsFileName) throws HWAirportException {
		List<String[]> flightsData;
		try {
			flightsData = FileHandler.parseFile(flightsFileName);
		} catch (HWAirportException e) {
			throw new HWAirportException("Error parsing the file data");
		}
		Map<String, Flight> flights = new HashMap<String, Flight>();
		
		try {
		for(String[] line : flightsData ) {
			Flight flight = new Flight(line[0].toLowerCase(), line[1], line[2], line[3],Integer.parseInt(line[4]),
					Integer.parseInt(line[5]), Integer.parseInt(line[6]), Double.parseDouble(line[7]),
					Double.parseDouble(line[8]),Double.parseDouble(line[9]),Double.parseDouble(line[10]),
					Double.parseDouble(line[11]), Double.parseDouble(line[12]));
			flights.put(line[0].toLowerCase(),flight);
		}
		}catch (Exception ex){
			ex.printStackTrace();
		}
				return flights;
	}

	/**
	 * reads the data from the booking file into a hashmap.
	 * @param bookingFileName the name of the file containing the booking details.
	 * @return a hashmap of (booking reference, booking details) this data is stored in and accessed by all services.
	 */
	@Override
	public Map<String, Booking> loadBookingData(String bookingFileName)  {
		List<String[]> bookingData = new ArrayList<String[]>();
		try {
			bookingData = FileHandler.parseFile(bookingFileName);
		} catch (HWAirportException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		Map<String, Booking> bookingList = new HashMap<String, Booking>();
		Booking booking;
		for(String[] line : bookingData) {
			String refCode = line[2].toLowerCase();
			booking = new Booking(line[0].toLowerCase(), 
					line[1].toLowerCase(), line[2].toLowerCase(), line[3].toLowerCase(), BookingStatus.valueOf(line[4]));
			bookingList.put(refCode, booking);
		}
		return bookingList;
	}

	@Override
	public void updateActiveFlight(String flightCd, int psngrCnt, double weight, double volume, double totalChg) {
		List<ActiveFlight> flights = AppData.getActiveFlights();
		ActiveFlight activeFlight = null;
		for (ActiveFlight flight : flights) {
			if (flight.getFlightCd().equalsIgnoreCase(flightCd)) {
				flight.setTotalVolume(volume);
				flight.setTotalWeight(weight);
				flight.setXtraChargeCollected(totalChg);
				flight.setBoardedPsngrCnt(flight.getBoardedPsngrCnt()+1);
				activeFlight = flight;
			}
		}
		setChanged();
		notifyObservers(activeFlight);
	}

	@Override
	public List<ActiveFlight> getFlightsActivelyBoarding() {
		return AppData.getActiveFlights();
	}

	@Override
	public void addPsgrToCheckedInList(Booking passenger) {
		AppData.addPsngrToCheckedInList(passenger.getFlightCode(), passenger);
		
	}

	@Override
	public void addPsgrToFailedToCheckedList(Booking passenger) {
		AppData.addPsngrToFailedToCheckInList(passenger.getFlightCode(), passenger);
		
	}
	

}
