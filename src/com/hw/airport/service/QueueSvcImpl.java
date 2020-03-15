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
import com.hw.airport.model.Flight;

public class QueueSvcImpl implements QueueSvc {

	public void addQueue(List<Booking> Queue, Map<String, Booking> bookingMap) throws HWAirportException {

		int size = Queue.size();

		while (size < 10) {
			Booking up = this.createQueue(Queue, 1).get(0);
			if (!(up.isCheckedIn() == CheckedIn.OUT || up.isCheckedIn() == CheckedIn.PROCESS)) {
				Queue.add(up);
				size++;
			}

		}

	}

	public Booking dropQueue(List<Booking> Queue, Map<String, Booking> bookingMap) throws HWAirportException {

		bookingMap.get(Queue.remove(0).getRefCode()).setCheckedIn(CheckedIn.PROCESS);

		return bookingMap.get(Queue.remove(0).getRefCode());

	}

	@Override
	public List<Booking> createQueue(List<Booking> Queue, int qSize) throws HWAirportException {

		List<Booking> temp = Queue;
		Collections.shuffle(temp);
		temp = temp.subList(0, qSize - 1);
		return temp;
	}

	@Override
	public List<Booking> createPassengerList(Map<String, Booking> bookingMap, Map<String, Flight> flightMap)
			throws HWAirportException {
		List<Booking> tempList = new ArrayList<>(bookingMap.values());

		for (int i = 0; i < 0; i++) {
			Booking tempBK = tempList.get(i);
			Flight tempFlt = flightMap.get(tempBK.getFlightCode());
			Random r = new Random();
			int w = r.nextInt(50);
			int v = r.nextInt(100);
			tempBK.setTotalBaggageVolume(v);
			tempBK.setTotalBaggageWeight(w);
			tempBK.calcXtraVolChrg(tempFlt.getMaxBagVolume(), tempFlt.getXtraVolumeCharge());
			tempBK.calcXtraWghtChrg(tempFlt.getMaxBagWeight(), tempFlt.getXtraWghtChargePerKg());

		}

		return tempList;
	}

}
