package com.hw.airport.model;

import java.util.LinkedList;


public class PassengerQueue {

	private volatile LinkedList<Booking> passengerList = new LinkedList<Booking>();
	
	private int queueMaxSize;

	private static PassengerQueue passengerQueue;

	
	private PassengerQueue() {
		
	}
	
	public static PassengerQueue getInstance() {
		if (passengerQueue == null) {
			passengerQueue = new PassengerQueue();
		}
		return passengerQueue;
	}

	
	
	public LinkedList<Booking> getPassengerList() {
		return passengerList;
	}

	public int getQueueMaxSize() {
		return queueMaxSize;
	}

	public void setPassengerList(LinkedList<Booking> passengerList) {
		this.passengerList = passengerList;
	}

	public void setQueueMaxSize(int queueMaxSize) {
		this.queueMaxSize = queueMaxSize;
	}

	public Booking removePassengerFromQueue() {
		Booking removedPassenger = passengerList.removeFirst();
		return removedPassenger;
	}
	
	public void addPassengerToQueue(Booking passenger) {
		this.passengerList.add(passenger);
	}

	public void printPassegerQueue() {

		for (Booking book : passengerList) {

			if (book == null) {
				break;
			} else {
				System.out.println(book.getRefCode());
			}

		}

	}
	
	public int getQueueSize() {
		return passengerList.size();
	}

}
