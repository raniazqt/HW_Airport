package com.hw.airport.service;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking;
import com.hw.airport.model.BookingCharge;
import com.hw.airport.model.Flight;

public class CheckInSvcImpl implements CheckInSvc {

	private BookingSvc bookingSvc = new BookingSvcImpl();
	private FlightSvc flightSvc = new FlightSvcImpl();

	@Override
	public Booking retrieveBookingByCodeAndLastName(String lastName, String bookingRef) throws HWAirportException {
		Booking booking = bookingSvc.findBookingByLastNameAndRefCode(lastName, bookingRef);
		if (null == booking) {
			throw new HWAirportException("No booking with provided information was found");
		}
		return booking;
	}

	@Override
	public BookingCharge calculateXtraChargeForPasngr(BookingCharge charge) throws HWAirportException {
		Booking booking = this.retrieveBookingByCodeAndLastName(
				charge.getLastName(), charge.getRefCode());
		Flight flight = flightSvc.getFlightByCode(booking.getFlightCode().toLowerCase());
		if(null == flight) {
			throw new HWAirportException("Flight information not found");
		}
		double volume = charge.getLength() * charge.getWidth() * charge.getDepth();
		if (volume > flight.getMaxBagVolume()) {
			charge.setVolumeCharge(flight.getXtraVolumeCharge());
		}
		if (charge.getWeight() > flight.getMaxBagWeight()) {
			charge.setWeightCharge(flight.getXtraWghtChargePerKg() * 
					charge.getWeight() - flight.getMaxBagWeight());
		}
		return charge;
	}

	@Override
	public void doCheckIn(String lastName, String bookingRef) throws HWAirportException {
		Booking booking = bookingSvc.findBookingByLastNameAndRefCode(lastName, bookingRef);
		if (null == booking) {
			System.out.println("No booking found for given last name and reference code");
		}else {
			bookingSvc.updateBookingStatus(lastName, bookingRef, true);
		}
	}

	@Override
	public boolean confirmCheckin(Booking booking) {
		
		boolean status= false;
		try {
			status = bookingSvc.updateBookingStatus(booking.getLastName(), booking.getRefCode(), true);
		} catch (HWAirportException e) {
			status = false;
		}
		return status;
	}
}
