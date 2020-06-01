package com.hw.airport.service;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Desk;

public class DeskSvcImpl implements DeskSvc{
	
	private QueueSvc queueSvc;
	
	@Override
	public Desk openDesk() {
		return null;
	}
	
	@Override
	public void closeDesk() {
		
	}
	
	/*
	 * Request passenger (booking) from the queue to be processed
	 * After assigning the selected booking from the queue, the desk status should be set to busy
	 */
	@Override
	public void addPassengerToDesk(Desk desk) throws HWAirportException {
		if (!desk.getStatus().equalsIgnoreCase("AVAILABLE")) {
			throw new HWAirportException("Check-in Desk is currently busy assisting other customers");
		}
		Booking passenger = queueSvc.getPassengerFromQueue();
		//TODO: Handle the case where passeneger is empty
		if (null == passenger) {
			desk.setStatus("AVAILABLE");
			desk.setPassenger(null);
		}else {
			desk.setStatus("BUSY");
			desk.setPassenger(passenger);
		}
	}
	
	@Override
	public Desk getDeskDetails() {
		return null;
		
	}

}
