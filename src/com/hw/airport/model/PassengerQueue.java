package com.hw.airport.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking.CheckedIn;
import com.hw.airport.service.BookingSvc;

public class PassengerQueue {

	private LinkedList<Booking> passengerQ = new LinkedList<Booking>();
	private AppData appData = AppData.getInstance();
	private BookingSvc bookingSvc = appData.getBookingSvc();

	private int maxSize;

	public PassengerQueue() {
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

		if (passengerToAdd.getCheckInStatus().equals(CheckedIn.OUT)) {
			bookingSvc.setRandomBaggageDimensions(passengerToAdd);
			passengerQ.add(passengerToAdd);
			bookingSvc.updateCheckInStatus(passengerToAdd.getRefCode(), CheckedIn.PROCESS);

		}

	}

	public Booking removePassengerFromQueue() {
		Booking removedPassenger = passengerQ.removeFirst();
		return removedPassenger;

	}

	public Booking firstPassengerFromQueue() {
		Booking firstPassenger = passengerQ.getFirst();
		return firstPassenger;

	}

	public void fillQueue() throws HWAirportException {
		int csize = passengerQ.size();

		while (csize < maxSize) {
			this.addPassengerToQueue();
			csize = passengerQ.size();

		}

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
