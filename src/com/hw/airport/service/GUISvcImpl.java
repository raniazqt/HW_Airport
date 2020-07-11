package com.hw.airport.service;

import java.util.LinkedList;
import java.util.List;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.config.AppContainer;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Desk;
import com.hw.airport.model.DeskManager;
import com.hw.airport.model.FlightSettings;

public class GUISvcImpl implements GUISvc {
	private QueueSvc queueSvc = AppContainer.getQueueSvc();
	private DeskManager deskManager = AppContainer.getDeskManager();
			
	
	@Override
	public AirportSimulator retriveSimulatorSettings() {
		return AirportSimulator.getInstnce();
	}
	
	//retrieve Current Passenger Count in Queue 
	@Override
	public int getCrnCntOfPsngrInQueue() {
		return queueSvc.getCountOfPassangerInQueue();
	}
	
	@Override
	public LinkedList<Booking> getQueuePassengersList() {
		return queueSvc.getAllPassengersFromQueue();
	}
	
	@Override
	public List<Desk> getOpenedDeskList() {
		return deskManager.getOpenedDeskList();
	}
	
	@Override
	public List<FlightSettings> getActiveFlightsInformation() {
		return AirportSimulator.getActiveFlights();
	}
	
	
	
	
}
