package com.hw.airport.service;

import com.hw.airport.model.AppData;
import com.hw.airport.model.Booking;

public class BookingSvcImpl implements BookingSvc {
	AppData appData = AppData.getInstance();


	@Override
	public Booking findBookingByLastNameAndRefCode(String lastName, String refCode) {
		return appData.bookingList.get("HW123");
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

}
