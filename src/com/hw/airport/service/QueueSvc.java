package com.hw.airport.service;

import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Flight;
import com.hw.airport.model.FlightExtrasAndCharges;

public interface QueueSvc {

	public List<Booking> createQueue(int qSize) throws HWAirportException;

	public void addQueue(List<Booking> Queue) throws HWAirportException;

	public void dropQueue(List<Booking> Queue, Map<String, Booking> bookingMap) throws HWAirportException;

}
