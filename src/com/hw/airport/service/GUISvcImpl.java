package com.hw.airport.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.config.AppContainer;
import com.hw.airport.model.*;
import javafx.util.Pair;

import javax.swing.*;

public class GUISvcImpl implements GUISvc {
	private QueueSvc queueSvc = AppContainer.getQueueSvc();
	private DeskManager deskManager = AppContainer.getDeskManager();
	
	@Override
	public List<Pair<String, Double>> retrieveSimulatorSettings()
	{
		return Arrays.asList(new Pair<>("Simulation Rate: ", AirportSimulator.getSimExcRate()),
				new Pair<>("Max Open Desks: ", AirportSimulator.getMaxOpndCheckinDesk()),
				new Pair<>("Queue Population Rate: ", AirportSimulator.getQueuePopulatingRate()));
	}

		//retrieve Current Passenger Count in Queue
	@Override
	public int getCrnCntOfPsngrInQueue() {
		return queueSvc.getCountOfPassangerInQueue();
	}
	
	@Override
	public DefaultListModel<Booking> getQueuePassengersList()
	{
		DefaultListModel<Booking> queuePsngrListModel = new DefaultListModel<Booking>();
		queuePsngrListModel.addAll(PassengerQueue.getInstance().getPassengerList());
		return queuePsngrListModel;
	}
	
	@Override
	public List<Desk> getOpenedDeskList() {
		return deskManager.getOpenedDeskList();
	}
	
	@Override
	public List<ActiveFlight> getActiveFlightsInformation() {
		return AppData.getActiveFlights();
	}
	
	
	
	
}
