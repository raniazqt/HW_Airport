package com.hw.airport.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Flight;
import com.hw.airport.observer.Observer;

public interface QueueSvc {

	public List<Booking> createQueue(int qSize) throws HWAirportException;

	public void addQueue(List<Booking> Queue) throws HWAirportException;

	public void emptyQueue();

	Booking getPassengerFromQueue();

	List<Booking> Deskloadexample(Map<String, Booking> bookingMap, Map<String, Flight> flightMap)
			throws HWAirportException;

	List<Booking> queue();

	void setPassengerQ();

	Booking addPassengerToQueue() throws HWAirportException;

	Booking firstPassengerFromQueue();

	void fillQueue() throws HWAirportException;

	public int getCountOfPassangerInQueue();


	LinkedList<Booking> getAllPassengersFromQueue();




}

