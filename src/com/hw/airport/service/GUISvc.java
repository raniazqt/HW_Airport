package com.hw.airport.service;

import java.util.LinkedList;
import java.util.List;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Desk;
import com.hw.airport.model.FlightSettings;
import javafx.util.Pair;

import javax.swing.*;

public interface GUISvc {

	List<Pair<String, Double>> retrieveSimulatorSettings();

	//retrieve Current Passenger Count in Queue 
	int getCrnCntOfPsngrInQueue();

	DefaultListModel<Booking> getQueuePassengersList();

	List<Desk> getOpenedDeskList();

	List<FlightSettings> getActiveFlightsInformation();

}