package com.hw.airport.service;

import java.util.List;
import java.util.Map;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.model.ActiveFlight;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Desk;



public interface GUISvc {

	Map<String, Integer> retrieveSimulatorSettings();

	//retrieve Current Passenger Count in Queue 
	int getCrnCntOfPsngrInQueue();

	List<Booking> getQueuePassengersList();

	List<Desk> getOpenedDeskList();

	List<ActiveFlight> getActiveFlightsInformation();

	Desk getDeskById(Integer id);

}