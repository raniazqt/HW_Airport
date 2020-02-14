package com.hw.airport.service;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.AppData;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Flight;

public class BookingSvcImpl implements BookingSvc {
	AppData appData = AppData.getInstance();


	@Override
	public Booking findBookingByLastNameAndRefCode(String lastName, String refCode) {
		return appData.getBookingList().get(refCode);
	}

	@Override
	public boolean updateBookingStatus(String lastName, String refCode, boolean status) {
		boolean bookingExists = appData.getBookingList().containsKey(refCode);
		if(!bookingExists) {
			return false;
		}

		Booking updatedBooking = findBookingByLastNameAndRefCode(lastName, refCode);
		updatedBooking.setCheckedIn(status);
		appData.getBookingList().put(refCode, updatedBooking);

		return true;
	}

	@Override
	public int getCountOfCheckedInPassengersByFlight(String flightCode) {
		boolean flightExists = appData.getFlightsInfo().containsKey(flightCode);
		int checkedInFlightsCount = 0;
		if(flightExists) {
			for (Booking booking : appData.getBookingList().values()) {
				boolean checkedInForFlight = (booking.getFlightCode().equals(flightCode)) && booking.isCheckedIn();
				if(checkedInForFlight) {
					checkedInFlightsCount += 1;
				}
			}
		}

		return checkedInFlightsCount;
	}

	@Override
	public double calculateExtraChargeForFlight(String flightCode) {
		boolean flightExists = appData.getFlightsInfo().containsKey(flightCode);
		double totalExtraWghtChrg = 0.0;
		double totalExtraVolChrg = 0.0;
		if(flightExists) {
			for (Booking booking : appData.getBookingList().values()) {
				boolean checkedInForFlight = (booking.getFlightCode().equals(flightCode)) && booking.isCheckedIn();
				if(checkedInForFlight) {
					totalExtraWghtChrg += booking.getXtraBagWghtChrg();
					totalExtraVolChrg += booking.getXtraBagVolChrg();
				}
			}
		}
		return totalExtraVolChrg + totalExtraWghtChrg;
	}
}
