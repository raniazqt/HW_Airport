package com.hw.airport.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking.BookingStatus;
import com.hw.airport.service.BookingSvc;
import com.hw.airport.service.BookingSvcImpl;

public class PassengerQueue {

	private LinkedList<Booking> passengerQ = new LinkedList<Booking>();
	private BookingSvc bookingSvc = new BookingSvcImpl();
	private int maxSize;

	private PassengerQueue() {
	}
	
	
	private static PassengerQueue passengerQueue;

	public static PassengerQueue getInstance() {
		if (passengerQueue == null) {
			passengerQueue = new PassengerQueue();
		}
		return passengerQueue;
	}

	public void setMaxSize(int sz) {
		this.maxSize = sz;

	}

	public int getMaxSize() {
		return maxSize;
	}

	public LinkedList<Booking> getPassengerQ() {
		return passengerQ;
	}

	public void setPassengerQ() {
		List<Booking> temp = bookingSvc.extractBookingList();
		Collections.shuffle(temp);
		temp = temp.subList(0, maxSize);
		passengerQ = new LinkedList<Booking>(temp);
	}

	public void addPassengerToQueue() throws HWAirportException {
		Booking passengerToAdd = bookingSvc.getRandomBooking();
		
		if (null != passengerToAdd && passengerToAdd.getCheckInStatus().equals(BookingStatus.NOT_CHECKED_IN)) {
			bookingSvc.setRandomBaggageDimensions(passengerToAdd);
			passengerQ.add(passengerToAdd);
			bookingSvc.updateCheckInStatus(passengerToAdd.getRefCode(), BookingStatus.PROCESSING);
		}
	}

	public Booking removePassengerFromQueue() {
		Booking removedPassenger = passengerQ.removeFirst();
		return removedPassenger;

	}

	public void fillQueue() throws HWAirportException {
		int csize = passengerQ.size();

		while (csize < maxSize) {
			this.addPassengerToQueue();
			csize = passengerQ.size();

		}

	}
	
	public int getQueueSize() {
		return this.passengerQ.size();
	}

	public void printQ() {

		for (Booking book : passengerQ) {

			if (book == null) {
				break;
			} else {
				System.out.println(book.getRefCode());
			}

		}

	}

}
