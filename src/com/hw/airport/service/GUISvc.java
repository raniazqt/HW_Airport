package com.hw.airport.service;

import java.util.LinkedList;
import java.util.List;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.model.ActiveFlight;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Desk;

public interface GUISvc {

	AirportSimulator retriveSimulatorSettings();

	//retrieve Current Passenger Count in Queue 
	int getCrnCntOfPsngrInQueue();

	LinkedList<Booking> getQueuePassengersList();

	List<Desk> getOpenedDeskList();

	List<ActiveFlight> getActiveFlightsInformation();

}