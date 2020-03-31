package com.hw.airport.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.hw.airport.model.Booking.CheckedIn;
import com.hw.airport.service.BookingSvc;
import com.hw.airport.service.BookingSvcImpl;

public class PassQueue {

	private LinkedList<Booking> passengerQ;
	private BookingSvc BKsvc = new BookingSvcImpl();
	private int size;

	public PassQueue(int sz) {
		this.size = sz;
		this.setPassengerQ();
	}

	public Booking dropQueue() {
		Booking drop = passengerQ.removeFirst();
		BKsvc.updateCheckin(drop.getRefCode(), CheckedIn.PROCESS);
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

	public void fillQueue() {
		int csize = passengerQ.size();

		while (csize < size) {
			this.addQueue();
			csize = passengerQ.size();

		}

	}

	private void addQueue() {

		boolean dupe = true;

		while (dupe) {
			Booking add = BKsvc.extractRandBooking();
			if (!this.isDupe(add.getRefCode()) && add.isCheckedIn()==CheckedIn.OUT) {

				passengerQ.add(add);
				dupe = false;

			}

		}
	}

	private boolean isDupe(String ref) {

		boolean dupe = false;

		for (Booking Book : passengerQ) {
			if (Book.getRefCode().equals(ref)) {
				dupe = true;

			}
		}
		return dupe;

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
