package com.hw.airport.model;

import com.hw.airport.enums.DESK_STATUS;

public class Desk {
	
	//passenger being checked in 
	private Booking passenger;
	
	//Desk ID
	private Integer id;
	
	//Desk status from ENUM
	private DESK_STATUS status;
	
	private String threadName;
	
	/*
	 * Constructor to create new Desk instance. To insure ID is uniuque, 
	 * ID generator code is used when construction the Desk object 
	 * which uses the thread safe AtomicInteger type. 
	 * When first creating a desk its status is available and ready to take passengers  
	 */
	public Desk(Integer id, DESK_STATUS status) {
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

	public DESK_STATUS getStatus() {
		return status;
	}

	public void setPassenger(Booking passenger) {
		this.passenger = passenger;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setStatus(DESK_STATUS status) {
		this.status = status;
	}
	public String getThreadName() {
		return threadName;
	}
	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}
	
}
