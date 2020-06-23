package com.hw.airport.service;

import java.util.Random;

import com.hw.airport.config.AppContainer;
import com.hw.airport.enums.DESK_STATUS;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Desk;
import com.hw.airport.model.AppData;
import com.hw.airport.model.Flight;

public class DeskSvcImpl implements DeskSvc{

	
	private QueueSvc queueSvc = AppContainer.getQueueSvc();
	
	@Override
	public Desk openDesk() {
		return new Desk(new Random(0).nextInt());
	}
	
	@Override
	public void closeDesk(Desk desk) {
		desk.setId(null);
		desk.setPassenger(null);
		desk.setStatus(DESK_STATUS.CLOSED.toString());
	}
	
	/*
	 * Request passenger (booking) from the queue to be processed
	 * After assigning the selected booking from the queue, the desk status is set to busy
	 */
	@Override
	public void loadDesk(Desk desk) throws HWAirportException {
		if (!desk.getStatus().equalsIgnoreCase(DESK_STATUS.AVAILABLE.toString())) {
			throw new HWAirportException("Check-in Desk is currently busy assisting other customers");
		}
		Booking passenger = queueSvc.getPassengerFromQueue();
		//TODO: Handle the case where passeneger is empty
		if (null == passenger) {
			desk.setStatus(DESK_STATUS.AVAILABLE.toString());
			desk.setPassenger(null);
		}else {
			desk.setStatus(DESK_STATUS.BUSY.toString());
			desk.setPassenger(passenger);
		}
	}
	
	@Override
	public Desk getDeskDetails() {
		return null;
	}

	
	/*
	 * public void calcCharges() {
	 * 
	 * this.passenger.calcXtraVolChrg(this.plane.getMaxBagVolume(),
	 * this.plane.getXtraVolumeCharge());
	 * this.passenger.calcXtraWghtChrg(this.plane.getMaxFlightWeight(),
	 * this.plane.getXtraWghtChargePerKg());
	 * this.setCheckinProgress(deskProgress.EXTRA_FEE_CALCULATION);
	 * 
	 * }
	 */

	
}
