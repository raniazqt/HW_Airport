package com.hw.airport.model;

import java.util.Map;

import com.hw.airport.service.BaggageSvc;
import com.hw.airport.service.BaggageSvcImpl;
import com.hw.airport.service.BookingSvc;
import com.hw.airport.service.BookingSvcImpl;
import com.hw.airport.service.FlightSvc;
import com.hw.airport.service.FlightSvcImpl;

public class AppData {

	// Hashmap to hold the list of passengers booking loaded from the text file.
	// The key is the reference code
	private Map<String, Booking> bookingList;

	// Hashmap to hold the list of flights loaded from the text file. The key is the
	// flight code
	private Map<String, Flight> flightsInfo;

	private static BookingSvc bookingSvc;
	private static FlightSvc flightSvc;
	private static BaggageSvc baggageSvc;

	private static AppData appData;

	public static AppData getInstance() {
		if (appData == null) {
			appData = new AppData();
			AppData.setBookingSvc();
			AppData.setFlightSvc();
			AppData.setBaggageSvc();
		}

		return appData;
	}

	public static AppData setBookingSvc() {
		if (bookingSvc == null) {
			bookingSvc = new BookingSvcImpl();
		}

		return appData;
	}

	public static AppData setFlightSvc() {
		if (flightSvc == null) {
			flightSvc = new FlightSvcImpl();
		}

		return appData;
	}
	
	public static AppData setBaggageSvc() {
		if (baggageSvc == null) {
			baggageSvc = new BaggageSvcImpl();
		}

		return appData;
	}

	public BookingSvc getBookingSvc() {

		return AppData.bookingSvc;
	}
	
	public FlightSvc getFlightSvc() {

		return AppData.flightSvc;
	}
	
	public BaggageSvc getBaggageSvc() {

		return AppData.baggageSvc;
	}

	public Map<String, Booking> getBookingList() {
		return bookingList;
	}

	public void setBookingList(Map<String, Booking> bookingList) {
		this.bookingList = bookingList;
	}

	public Map<String, Flight> getFlightsInfo() {
		return flightsInfo;
	}

	public void setFlightsInfo(Map<String, Flight> flightsInfo) {
		this.flightsInfo = flightsInfo;
	}

}