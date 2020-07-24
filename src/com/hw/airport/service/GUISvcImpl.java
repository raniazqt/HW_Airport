package com.hw.airport.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.config.AppContainer;
import com.hw.airport.enums.DESK_STATUS;
import com.hw.airport.model.ActiveFlight;
import com.hw.airport.model.AppData;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Desk;
import com.hw.airport.model.DeskManager;


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
		/*
		 * Booking dummyBooking = new Booking("Spider", "Man", "AX234",
		 * "F214",Booking.BookingStatus.NOT_CHECKED_IN);
		 * dummyBooking.setTotalBaggageVolume(27.5);
		 * dummyBooking.setTotalBaggageWeight(122.2); List<Booking> dummyQueue = new
		 * ArrayList<>(Arrays.asList(dummyBooking, dummyBooking, dummyBooking,
		 * dummyBooking, dummyBooking, dummyBooking, dummyBooking, dummyBooking,
		 * dummyBooking, dummyBooking, dummyBooking, dummyBooking, dummyBooking,
		 * dummyBooking, dummyBooking, dummyBooking, dummyBooking, dummyBooking,
		 * dummyBooking, dummyBooking)); return dummyQueue;
		 */
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
