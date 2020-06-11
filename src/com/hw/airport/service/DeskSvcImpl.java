package com.hw.airport.service;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.AppData;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Booking.CheckedIn;
import com.hw.airport.model.Flight;

public class DeskSvcImpl implements DeskSvc {

	AppData appData = AppData.getInstance();

	public enum deskAvailabilty {
		Available, Busy
	}

	// More stages
	public enum deskProgress {
		WAITING, BOOKING_VALIDATION, EXTRA_FEE_CALCULATION
	}

	private Booking passenger;
	private Flight plane;
	private String id;
	private deskAvailabilty deskStatus = deskAvailabilty.Available;
	private deskProgress checkinProgress = deskProgress.WAITING;

	public void loadDesk() {

		if (passenger == null) {

			passenger = appData.getPassengerQueue().removePassengerFromQueue();
			this.id = passenger.getRefCode();
			this.deskStatus = deskAvailabilty.Busy;
			this.plane = appData.getFlightsInfo().get(passenger.getFlightCode());
		}

	}

	public void validate() {

		Booking valid = appData.getBookingList().get(this.id);

		this.checkinProgress = deskProgress.BOOKING_VALIDATION;

		if (valid == null) {

			this.clearDesk();

		}

	}

	public void flightCapacity() {

		int passFilled = 0;
		int passMax = this.plane.getMaxPasngrCnt();
		double volFilled = 0;
		double volMax = this.plane.getMaxBagVolume();
		double weightFilled = 0;
		double weightMax = this.plane.getMaxFlightWeight();

		try {
			passFilled = appData.getBookingSvc().getCountOfCheckedInPassengersByFlight(this.plane.getCode());
			volFilled = appData.getBaggageSvc().getTheTotalBagVolumesOnFlight(this.plane.getCode());
			weightFilled = appData.getBaggageSvc().getTheTotalBagWeightOnFlight(this.plane.getCode());

			int passCapacity = passMax - passFilled;
			double bagCapacity = (volMax - volFilled) + (weightMax - weightFilled);
			double capacity = passCapacity + bagCapacity;

			if (capacity == 0) {

				this.clearDesk();

			}

		} catch (HWAirportException e) {

			e.printStackTrace();
		}

	}

	public void calcCharges() {

		this.passenger.calcXtraVolChrg(this.plane.getMaxBagVolume(), this.plane.getXtraVolumeCharge());
		this.passenger.calcXtraWghtChrg(this.plane.getMaxFlightWeight(), this.plane.getXtraWghtChargePerKg());
		this.checkinProgress = deskProgress.EXTRA_FEE_CALCULATION;

	}

	public void clearDesk() {
		passenger.setCheckInStatus(CheckedIn.OUT);
		appData.getBookingList().replace(passenger.getRefCode(), passenger);

	}
	
	public void checkinDesk() {
		passenger.setCheckInStatus(CheckedIn.IN);
		appData.getBookingList().replace(passenger.getRefCode(), passenger);

	}

	public Booking getPassenger() {

		return passenger;

	}

}
