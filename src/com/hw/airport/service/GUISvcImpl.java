package com.hw.airport.service;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.config.AppContainer;
import com.hw.airport.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GUISvcImpl implements GUISvc {
	private QueueSvc queueSvc = AppContainer.getQueueSvc();
	private DeskManager deskManager = AppContainer.getDeskManager();
	
	@Override
	public Map<String, Double> retrieveSimulatorSettings()
	{
		HashMap<String, Double> map = new HashMap<String,Double>();
		map.put("Simulation Rate: ", AirportSimulator.getSimExcRate());
		map.put("Max Open Desks: ", AirportSimulator.getMaxOpndCheckinDesk());
		map.put("Queue Population Rate: ", AirportSimulator.getQueuePopulatingRate());
		
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
