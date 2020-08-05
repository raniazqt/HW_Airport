package com.hw.airport.service;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.config.AppContainer;
import com.hw.airport.model.*;
import com.hw.airport.threading.DeskManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GUISvcImpl implements GUISvc {
	private QueueSvc queueSvc = AppContainer.getQueueSvc();
	private DeskManager deskManager = AppContainer.getDeskManager();
	
	@Override
	public Map<String, Integer> retrieveSimulatorSettings()
	{
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("Simulation Rate: ", AirportSimulator.getSimExcRate());
		map.put("Max Open Desks: ", AirportSimulator.getMaxOpndCheckinDesk());
		map.put("Queue Population Rate: ", AirportSimulator.getQueuePopulatingRate());
		map.put("Check-In Speed: ", AirportSimulator.getSimRunningRate());
		
		return map;
	}

	//retrieve Current Passenger Count in Queue
	@Override
	public int getCrnCntOfPsngrInQueue() {
		return queueSvc.getCountOfPassangerInQueue();
	}
	
	@Override
	public List<Booking> getQueuePassengersList()
	{
		return queueSvc.getAllPassengersFromQueue();
	}
	
	@Override
	public List<Desk> getOpenedDeskList() {
		return deskManager.getOpenedDeskList();
	}
	
	@Override
	public List<ActiveFlight> getActiveFlightsInformation() {
		return AppData.getActiveFlights();
	}

	@Override
	public Desk getDeskById(Integer id) {
		List<Desk> deskList = this.getOpenedDeskList();
		for(Desk desk : deskList) {
			if (id == desk.getId()) {
				return desk;
			}
		}
		return null;
	}
	
	
	
	
}
