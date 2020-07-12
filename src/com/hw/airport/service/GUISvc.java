package com.hw.airport.service;

import java.util.List;
import com.hw.airport.model.ActiveFlight;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Desk;
import javafx.util.Pair;

import javax.swing.*;

public interface GUISvc {

	List<Pair<String, Double>> retrieveSimulatorSettings();

	//retrieve Current Passenger Count in Queue 
	int getCrnCntOfPsngrInQueue();

	List<Booking> getQueuePassengersList();

	List<Desk> getOpenedDeskList();

	List<ActiveFlight> getActiveFlightsInformation();

}