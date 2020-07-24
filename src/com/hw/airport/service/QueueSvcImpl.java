package com.hw.airport.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Random;

import com.hw.airport.config.AppContainer;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Booking.BookingStatus;
import com.hw.airport.model.Flight;
import com.hw.airport.model.PassengerQueue;
import com.hw.airport.service.BookingSvc;

public class QueueSvcImpl extends Observable implements QueueSvc {

	BookingSvc bookingSvc = AppContainer.getBookingSvc();

	private PassengerQueue passengerQ = PassengerQueue.getInstance();


	@Override
	public Booking getPassengerFromQueue() {
		Booking passenger = passengerQ.removePassengerFromQueue();
		setChanged();
		notifyObservers();
		return passenger ;
	}

	@Override
	public void addQueue(List<Booking> Queue) throws HWAirportException {
		int size = Queue.size();		
		boolean dupe = false;
		while (size < 10 && size != 0) {
			Booking up = this.createQueue(1).get(0);
			for (Booking book : Queue) {
				if (!dupe && up.getRefCode() == book.getRefCode()) {
					dupe = true;
				}
			}

			if (!(up.getCheckInStatus() == BookingStatus.NOT_CHECKED_IN || up.getCheckInStatus() == BookingStatus.PROCESSING)) {

				Queue.add(up);
				size++;
			}

		}

	}
	//TODO:WHAT IS THIS?
	@Override
	public void dropQueue(List<Booking> Queue, Map<String, Booking> bookingMap) throws HWAirportException {

		bookingMap.get(Queue.remove(0).getRefCode()).setCheckInStatus(BookingStatus.PROCESSING);

	}

	@Override
	public List<Booking> createQueue(int qSize) throws HWAirportException {

		List<Booking> Queue = bookingSvc.extractBookingList().subList(0, qSize);
		Collections.shuffle(Queue);

		return Queue;
	}

	@Override
	public List<Booking> Deskloadexample(Map<String, Booking> bookingMap, Map<String, Flight> flightMap)
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

	@Override
	public List<Booking> queue() {

		return bookingSvc.extractBookingList();
	}


	@Override
	public void setPassengerQ() {
		List<Booking> temp = bookingSvc.extractBookingList();
		Collections.shuffle(temp);
		temp = temp.subList(0, passengerQ.getQueueMaxSize());
		passengerQ.setPassengerList(new LinkedList<Booking>(temp));
	}

	@Override
	public Booking addPassengerToQueue() throws HWAirportException {
		Booking passengerToAdd = bookingSvc.getRandomBooking();

		if (null != passengerToAdd && passengerToAdd.getCheckInStatus().equals(BookingStatus.NOT_CHECKED_IN)) {
			bookingSvc.setRandomBaggageDimensions(passengerToAdd);
			passengerQ.addPassengerToQueue(passengerToAdd);
			bookingSvc.updateCheckInStatus(passengerToAdd.getRefCode(), BookingStatus.PROCESSING);

			//notify observer - DeskManager - with the change
			setChanged();
			notifyObservers();
		}
		return passengerToAdd;
	}


	@Override
	public Booking firstPassengerFromQueue() {
		Booking firstPassenger = passengerQ.removePassengerFromQueue();
		return firstPassenger;

	}

	@Override
	public void fillQueue() throws HWAirportException {
		int csize = passengerQ.getQueueMaxSize();

		while (csize < passengerQ.getQueueMaxSize()) {
			this.addPassengerToQueue();
			csize = passengerQ.getQueueMaxSize();

		}

	}

	@Override
	public int getCountOfPassangerInQueue() {
		return passengerQ.getQueueSize();
	}
	
	@Override
	public LinkedList<Booking> getAllPassengersFromQueue() {
		return passengerQ.getPassengerList();
	}
	 {
		
}
}


