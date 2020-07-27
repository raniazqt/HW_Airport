package com.hw.airport.service;

import com.hw.airport.config.AppContainer;
import com.hw.airport.enums.DESK_STATUS;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Desk;

import java.util.Random;

public class DeskSvcImpl implements DeskSvc{


	private QueueSvc queueSvc = AppContainer.getQueueSvc();
	private CheckInSvc checkinSvc = AppContainer.getCheckinSvc();

	@Override
	public Desk openDesk() {
		return new Desk(new Random().nextInt(),DESK_STATUS.AVAILABLE);
	}

	@Override
	public void closeDesk(Desk desk) {
		desk.setId(null);
		desk.setPassenger(null);
		desk.setStatus(DESK_STATUS.CLOSED);
		
	}

	/*
	 * Request passenger (booking) from the queue to be processed
	 * After assigning the selected booking from the queue, the desk status is set to busy
	 */
	@Override
	public void loadDesk(Desk desk) throws HWAirportException {
		if (!desk.getStatus().equals(DESK_STATUS.AVAILABLE)) {
			throw new HWAirportException("Desk - " + desk.getThreadName() + " - is currently busy assisting other customers");
		}
		Booking passenger = queueSvc.getPassengerFromQueue();
		//TODO: Handle the case where passeneger is empty
		if (null == passenger) {
			this.updateStatus(desk, DESK_STATUS.AVAILABLE);
			desk.setPassenger(null);
		}else {
			this.updateStatus(desk, DESK_STATUS.BUSY);
			desk.setPassenger(passenger);
		}
	}

	@Override
	public Desk getDeskDetails() {
		return null;
	}

	/*
	 * @Override public void processPassengersQueue(Desk desk) throws
	 * HWAirportException { while (!desk.getStatus().equals(DESK_STATUS.CLOSED)) {
	 * if (queueSvc.getCountOfPassangerInQueue() == 0) { //close desk & stop thread
	 * }else { this.loadDesk(desk); System.out.println("Desk - " +
	 * desk.getThreadName() + " - processing passenger " +
	 * desk.getPassenger().getFullName()); this.updateStatus(desk,
	 * DESK_STATUS.AVAILABLE); } }
	 * 
	 * }
	 */
	@Override
	public void clearDesk(Desk desk) {
		desk.setPassenger(null);
		this.updateStatus(desk, DESK_STATUS.AVAILABLE);

	}

	@Override
	public void updateStatus(Desk desk, DESK_STATUS status) {
		desk.setStatus(status);

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
