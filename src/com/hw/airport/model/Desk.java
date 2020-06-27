package com.hw.airport.model;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.service.QueueSvc;

public class Desk {
	
	public enum deskStatus{AVAILABLE, BUSY}
	
	//passenger being checked in 
	private Booking passenger;
	
	//Desk ID
	private Integer id;
	
	//Desk status from ENUM
	private String status;
	
	/*
	 * Constructor to create new Desk instance. To insure ID is uniuque, 
	 * ID generator code is used when construction the Desk object 
	 * which uses the thread safe AtomicInteger type. 
	 * When first creating a desk its status is available and ready to take passengers  
	 */
	public Desk(Integer id, String status) {
		super();
		this.id = id;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public Booking getPassenger() {
		return passenger;
	}

	public String getStatus() {
		return status;
	}

	public void setPassenger(Booking passenger) {
		this.passenger = passenger;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	 
	

}
