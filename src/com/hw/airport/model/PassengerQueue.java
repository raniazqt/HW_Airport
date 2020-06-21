package com.hw.airport.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking.CheckedIn;
import com.hw.airport.service.BookingSvc;

public class PassengerQueue {

	private LinkedList<Booking> passengerQList = new LinkedList<Booking>();
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

	public LinkedList<Booking> getPassengerQList() {
		return passengerQList;
	}

	public void setPassengerQList() {
		List<Booking> temp = bookingSvc.extractBookingList();
		Collections.shuffle(temp);
		temp = temp.subList(0, maxSize);
		passengerQList = new LinkedList<Booking>(temp);
	}

	public void addPassengerToQList() throws HWAirportException {
		Booking passengerToAdd = bookingSvc.getRandomBooking();

		if (passengerToAdd.getCheckInStatus().equals(CheckedIn.OUT)) {
			bookingSvc.setRandomBaggageDimensions(passengerToAdd);
			passengerQList.add(passengerToAdd);
			bookingSvc.updateCheckInStatus(passengerToAdd.getRefCode(), CheckedIn.PROCESS);

		}

	}

	public Booking removePassengerFromQList() {
		Booking removedPassenger = passengerQList.removeFirst();
		return removedPassenger;

	}

	public Booking firstPassengerFromQList() {
		Booking firstPassenger = passengerQList.getFirst();
		return firstPassenger;

	}

	public void fillQList() throws HWAirportException {
		int csize = passengerQList.size();

		while (csize < maxSize) {
			this.addPassengerToQList();
			csize = passengerQList.size();

		}

	}

	public void printQList() {

		for (Booking book : passengerQList) {

			if (book == null) {
				break;
			} else {
				System.out.println(book.getRefCode());
			}

		}

	}

}
