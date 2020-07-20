package com.hw.airport.service;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.config.AppContainer;
import com.hw.airport.enums.DESK_STATUS;
import com.hw.airport.model.ActiveFlight;
import com.hw.airport.model.AppData;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Desk;
import com.hw.airport.model.DeskManager;
import javafx.util.Pair;

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
	public List<Booking> getQueuePassengersList()
	{
		Booking dummyBooking = new Booking("Spider", "Man", "AX234", "F214",Booking.BookingStatus.NOT_CHECKED_IN);
		dummyBooking.setTotalBaggageVolume(27.5);
		dummyBooking.setTotalBaggageWeight(122.2);
		List<Booking> dummyQueue = new ArrayList<>(Arrays.asList(dummyBooking, dummyBooking,
				dummyBooking, dummyBooking, dummyBooking, dummyBooking, dummyBooking, dummyBooking, dummyBooking, dummyBooking, dummyBooking,
				dummyBooking, dummyBooking, dummyBooking, dummyBooking, dummyBooking, dummyBooking, dummyBooking, dummyBooking, dummyBooking));
		return dummyQueue;
	}
	
	@Override
	public List<Desk> getOpenedDeskList() {
		Desk dummyDesk = new Desk(0, DESK_STATUS.AVAILABLE);
		dummyDesk.setPassenger(new Booking("Bat", "Man", "AX234", "F214",Booking.BookingStatus.NOT_CHECKED_IN));

		List<Desk> dummyDeskList = new ArrayList<>(Arrays.asList(dummyDesk, dummyDesk, dummyDesk, dummyDesk));
		return dummyDeskList;
	}
	
	@Override
	public List<ActiveFlight> getActiveFlightsInformation() {
		return AppData.getActiveFlights();
		/*ActiveFlight dummyFlight = new ActiveFlight("VX_123", 1);
		dummyFlight.setBoardedPsngrCnt(44);
		dummyFlight.setTotalVolume(40.256);
		dummyFlight.setTotalWeight(14.22);
		dummyFlight.setXtraChargeCollected(89.67);

		List<ActiveFlight> dummyFlights = new ArrayList<>(Arrays.asList(dummyFlight, dummyFlight, dummyFlight));
		return dummyFlights;
*/
	}
	
	
	
	
}
