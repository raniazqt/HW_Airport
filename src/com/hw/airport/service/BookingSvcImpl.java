package com.hw.airport.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hw.airport.exception.*;
import com.hw.airport.model.AppData;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Booking.CheckedIn;
import com.hw.airport.model.BookingCharge;
import com.hw.airport.model.Flight;
import com.hw.airport.model.FlightExtrasAndCharges;

public class BookingSvcImpl implements BookingSvc {
	AppData appData = AppData.getInstance();
	FlightSvc flightSvc = new FlightSvcImpl();

	/**
	 * Search for passenger booking in the booking list. It is found if the booking
	 * reference and last name are matching the given parameters
	 * 
	 * @param refCode  Booking reference number
	 * @param lastName for the passenger
	 * @return Passenger booking object if found and null if not
	 */
	@Override
	public Booking findBookingByLastNameAndRefCode(String lastName, String refCode) throws HWAirportException {
		Booking booking = appData.getBookingList().get(refCode.toLowerCase());

		if (booking == null) {
			throw new NullBookingException();
		}

		if (!lastName.equalsIgnoreCase(booking.getLastName())) {
			throw new BookingLastNameMismatchException();
		}

		return booking;
	}

	/**
	 * Updates the check in status of a booking
	 * 
	 * @param refCode  Booking reference number
	 * @param lastName for the passenger
	 * @return true when successfully update the record
	 * @throws HWAirportException
	 */
	@Override
	public boolean updateBookingStatus(Booking booking, BookingCharge bookingChg) throws HWAirportException {
		Booking updatedBooking = findBookingByLastNameAndRefCode(booking.getLastName(), booking.getRefCode());
		if (null == updatedBooking) {
			throw new MissingBookingException();
		}
		updatedBooking.setCheckedIn(CheckedIn.IN);
		double volume = bookingChg.getDepth() * bookingChg.getLength() * bookingChg.getWidth();
		updatedBooking.setTotalBaggageVolume(volume);
		updatedBooking.setTotalBaggageWeight(bookingChg.getWeight());
		updatedBooking.setXtraBagVolChrg(bookingChg.getVolumeCharge());
		updatedBooking.setXtraBagWghtChrg(bookingChg.getWeightCharge());
		appData.getBookingList().put(booking.getRefCode().toLowerCase(), updatedBooking);
		System.out.println(updatedBooking.getTotalBaggageWeight());
		System.out.println(updatedBooking.getTotalBaggageVolume());
		return true;
	}

	/**
	 * Count the number of passengers in a given flight. The passenger is counted
	 * only if the check in status is true
	 * 
	 * @param flightCode for which the passengers are booked
	 * @return the number of checked in passenger on the given flight
	 */
	@Override
	public int getCountOfCheckedInPassengersByFlight(String flightCode) throws HWAirportException {
		List<Booking> flightBookings = this.findAllBookingForFlight(flightCode);

		if (null == flightBookings || flightBookings.isEmpty()) {
			throw new HWAirportException("No bookings were found for flight " + flightCode);
		}
		int checkedInFlightsCount = 0;
		for (Booking booking : flightBookings) {
			if (booking.isCheckedIn() == CheckedIn.IN) {
				checkedInFlightsCount += 1;
			}
		}
		return checkedInFlightsCount;
	}

	/**
	 * Calculate the extra charges for weight and volume for a giving flight. The
	 * charges are summed up from the booking data for passenger who are checked in
	 * the given flight.
	 * 
	 * @param flightCode
	 * @throws HWAirportException
	 */
	@Override
	public FlightExtrasAndCharges calculateExtraChargeForFlight(String flightCode) throws HWAirportException {
		Flight flight = flightSvc.getFlightByCode(flightCode);
		double totalExtraWghtChrg = 0.0;
		double totalExtraVolChrg = 0.0;
		double totalExtraWght = 0.0;
		double totalExtraVol = 0.0;

		if (null == flight) {
			throw new MissingFlightException(flightCode, "booking service");
		}

		List<Booking> bookingsByFlight = this.findAllBookingForFlight(flightCode);
		for (Booking booking : bookingsByFlight) {
			if (booking.isCheckedIn() == CheckedIn.IN) {
				totalExtraVol += booking.getTotalBaggageVolume();
				totalExtraWght += booking.getTotalBaggageWeight();
				totalExtraWghtChrg += booking.getXtraBagWghtChrg();
				totalExtraVolChrg += booking.getXtraBagVolChrg();
			}
		}

		return new FlightExtrasAndCharges(flightCode, totalExtraWght, totalExtraVol, totalExtraWghtChrg,
				totalExtraVolChrg);
	}

	/**
	 * Retrieves the list of booking for a fiven flight
	 */
	@Override
	public List<Booking> findAllBookingForFlight(String flightCode) {
		List<Booking> flightBooking = new ArrayList<Booking>();
		List<Booking> bookingList = this.extractBookingList();
		for (Booking booking : bookingList) {
			if (booking.getFlightCode().equalsIgnoreCase(flightCode)) {
				flightBooking.add(booking);
			}
		}
		return flightBooking;
	}

	/**
	 * Helper method that extracts the booking from the Map into a flat list for
	 * easier manipulation
	 * 
	 * @return Flat list of all bookings
	 */
	public List<Booking> extractBookingList() {
		List<Booking> bookingList = new ArrayList<Booking>();

		Map<String, Booking> bookingMap = appData.getBookingList();

		for (String key : bookingMap.keySet()) {
			bookingList.add(bookingMap.get(key));
		}
		return bookingList;
	}

	public List<Booking> extractRandBookingList() {
		List<Booking> bookingList = this.extractBookingList();
		Collections.shuffle(bookingList);
		return bookingList;
	}

	public Booking extractRandBooking() {
		Booking booking = this.extractRandBookingList().get(0);

		return booking;
	}

	/**
	 * Generates a list of booking for every flight from the booking data.
	 */
	@Override
	public Map<String, List<Booking>> groupBookingByFlightCode() {
		Map<String, List<Booking>> bookingByFlight = new HashMap<String, List<Booking>>();
		List<Booking> bookings = this.extractBookingList();
		for (Booking booking : bookings) {
			String flightCd = booking.getFlightCode();
			List<Booking> flightBookingList;
			if (bookingByFlight.containsKey(flightCd)) {
				flightBookingList = bookingByFlight.get(flightCd);

			} else {
				flightBookingList = new ArrayList<Booking>();
			}
			flightBookingList.add(booking);
			bookingByFlight.put(flightCd, flightBookingList);
		}
		return bookingByFlight;
	}

}
