package com.hw.airport.model;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.service.QueueSvc;

public class CheckInDesk {
	
	//passenger being checked in 
	private Booking passenger;
	
	
	private int id;
	private String status;
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Booking getPassenger() {
		return passenger;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	 
	

}
