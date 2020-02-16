package com.hw.airport.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hw.airport.model.AppData;
import com.hw.airport.model.Booking;

public class BookingSvcImpl implements BookingSvc {
	AppData appData = AppData.getInstance();


	@Override
	public Booking findBookingByLastNameAndRefCode(String lastName, String refCode) {

		return appData.getBookingList().get(refCode);
	}

	@Override
	public boolean updateBookingStatus(String lastName, String refCode, boolean status) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCountOfCheckedInPassengersByFlight(String flightCode) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double claculateXtraFeeChargedForFlight(String flightCode) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Booking> findBookingByFlightCode(String flightCode) {
		List<Booking> flightBooking = new ArrayList<Booking>();
		List<Booking> bookingList = this.extractBookingList();
		for(Booking booking : bookingList) {
			if (booking.getFlightCode().equalsIgnoreCase(flightCode)) {
			flightBooking.add(booking);
			}
		}
		return flightBooking;
	}

	private List<Booking> extractBookingList() {
		List<Booking> bookingList = new ArrayList<Booking>();
		Map<String, Booking> bookingMap = appData.getBookingList();
		for (String key : bookingMap.keySet()) {
			bookingList.add(bookingMap.get(key));
		}
		return bookingList;
	}
	
	@Override
	public Map<String, List<Booking>> groupBookingByFlightCode(){
		Map<String, List<Booking>> bookingByFlight = new HashMap<String, List<Booking>>();
		List<Booking> bookings = this.extractBookingList();
		for (Booking booking : bookings) {
			String flightCd = booking.getFlightCode();
			List<Booking> flightBookingList;
			if (bookingByFlight.containsKey(flightCd)) {
				flightBookingList = bookingByFlight.get(flightCd);
				
			}else {
				flightBookingList= new ArrayList<Booking>();
			}
			flightBookingList.add(booking);
			bookingByFlight.put(flightCd, flightBookingList);
		}
		return bookingByFlight;
	}

}
