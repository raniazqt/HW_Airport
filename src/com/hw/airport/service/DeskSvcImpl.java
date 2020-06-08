package com.hw.airport.service;

import com.hw.airport.model.AppData;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Booking.CheckedIn;

public class DeskSvcImpl implements DeskSvc {

	AppData appData = AppData.getInstance();

	Booking passenger;

	public void loadDesk() {

		if (passenger == null) {

			passenger = appData.getPassengerQueue().removePassengerFromQueue();

		}

	}

	public void clearDesk() {
		passenger.setCheckInStatus(CheckedIn.IN);
		appData.getBookingList().replace(passenger.getRefCode(), passenger);

	}
	
	public Booking getPassenger() {
		
		return passenger;
		
	}

}
