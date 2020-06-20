package com.hw.airport.service;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Booking.CheckedIn;
import com.hw.airport.service.DeskSvcImpl.deskAvailabilty;
import com.hw.airport.service.DeskSvcImpl.deskProgress;

public interface DeskSvc {

	public void loadDesk();

	public void clearDesk();

	public Booking getPassenger();
	
	public void validate();
	
	public void flightStatus();
	
	public void boardingTimeCheck();

	public void flightCapacity();

	public void calcCharges();

	public void checkinPassenger();


}
