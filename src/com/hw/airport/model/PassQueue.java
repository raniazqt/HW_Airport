package com.hw.airport.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.hw.airport.service.BookingSvc;
import com.hw.airport.service.BookingSvcImpl;

public class PassQueue {

	private LinkedList<Booking> passengerQ;
	private BookingSvc BKsvc = new BookingSvcImpl();
	private int size;

	public PassQueue() {
	}

	public Booking dropQueue() {

		Booking drop = passengerQ.removeFirst();
		
		
		
		
		return drop;

	}

	public void setSize(int sz) {

		this.size = sz;

	}

	public LinkedList<Booking> getPassengerQ() {
		return passengerQ;
	}

	public void setPassengerQ() {

		List<Booking> temp = BKsvc.extractBookingList();
		Collections.shuffle(temp);
		temp = temp.subList(0, size);
		passengerQ = new LinkedList<Booking>(temp);
	}

	public int getSize() {
		return size;
	}

	public void addQueue() {

		boolean dupe = true;
		Booking up = null;
		int csize = passengerQ.size();

		while (csize != size && dupe) {
			Booking add = BKsvc.extractRandBooking();
			for (Booking book : passengerQ) {
				if (add.getRefCode() == book.getRefCode()) {
					dupe = false;
					up = add;
					break;
				}
			}
		}

		passengerQ.add(up);

	}

	public LinkedList<Booking> getQueue() {

		return passengerQ;

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
