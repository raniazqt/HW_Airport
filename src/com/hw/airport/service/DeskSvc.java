package com.hw.airport.service;

import com.hw.airport.model.Booking;
import com.hw.airport.model.Booking.CheckedIn;

public interface DeskSvc {

	public void loadDesk();

	public void clearDesk();

	public Booking getPassenger();
}
