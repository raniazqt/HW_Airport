package com.hw.airport.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Booking.CheckedIn;

public class QueueSvcImpl implements QueueSvc {

	public List<Booking> createQueue(Map<String, Booking> bookingMap, int qSize) throws HWAirportException {

		List<Booking> temp = new ArrayList<>(bookingMap.values());
		Collections.shuffle(temp);
		List<Booking> Queue = temp.subList(0, qSize - 1);

		for (int i = 0; i < 0; i++) {

			Random r = new Random();
			int w = r.nextInt(50);
			int v = r.nextInt(100);
			Queue.get(i).setTotalBaggageVolume(v);
			Queue.get(i).setTotalBaggageWeight(w);
			// add a flight check to find the limins per flight using the booking code to
			// search the flight list object
			Queue.get(i).calcXtraVolChrg(10);
			Queue.get(i).calcXtraVolChrg(10);

		}

		return Queue;
	}

	public void addQueue(List<Booking> Queue, Map<String, Booking> bookingMap) throws HWAirportException {

		int size = Queue.size();

		while (size < 10) {
			Booking up = this.createQueue(bookingMap, 1).get(0);
			if (!(up.isCheckedIn() == CheckedIn.OUT || up.isCheckedIn() == CheckedIn.PROCESS)) {
				Queue.add(up);
				size++;
			}

		}

	}

	public void dropQueue(List<Booking> Queue, Map<String, Booking> bookingMap) throws HWAirportException {

		bookingMap.get(Queue.remove(0).getRefCode()).setCheckedIn(CheckedIn.IN);

	}

}
