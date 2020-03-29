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

	public PassQueue() {
	}

	public Booking dropQueue() {

		return passengerQ.removeFirst();

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

		boolean dupe = false;

		while (size < 10 && size != 0) {
			Booking up = BKsvc.extractRandBooking();
			for (Booking book : passengerQ) {
				if (!dupe && up.getRefCode() == book.getRefCode()) {
					dupe = true;
				}
			}

			if (!(up.isCheckedIn() == CheckedIn.OUT || up.isCheckedIn() == CheckedIn.PROCESS)) {

				passengerQ.add(up);
				size++;
			}

		}

	}

}
