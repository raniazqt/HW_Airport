package com.hw.airport.model;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.service.QueueSvc;

public class CheckInDesk {
	
	//passenger being checked in 
	private Booking passenger;
	
	
	private int id;
	private String status;
	
	private QueueSvc queueSvc;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Booking getPassenger() {
		return passenger;
	}

	/*
	 * Request passenger (booking) from the queue to be processed
	 * After assigning the selected booking from the queue, the desk status should be set to busy
	 */
	public void setPassenger(Booking passenger) throws HWAirportException {
		if (!this.status.equalsIgnoreCase("AVAILABLE")) {
			throw new HWAirportException("Check-in Desk is current;y busy assisting other customers");
		}
		//this.passenger = queueSvc.getPassengerFromQueue();
		this.status = "BUSY";
		this.passenger = passenger;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	 
	

}
