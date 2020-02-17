package com.hw.airport.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.AppData;
import com.hw.airport.model.Flight;



class FlightSvcImplTest {
	
	@Mock
	AppData appData;
	
	@InjectMocks
	FlightSvc flightSvc;
	
	
	
	
	Map<String, Flight> flights = new HashMap<String, Flight>();
	
	@Before
	public void createFlightMockData() throws HWAirportException {
		
		flights.put("AA123", new Flight("AA123", "DXB", "DFW", "AAL",200, 1, 23, 60, 150, 10, 50, 0, 0));
		flights.put("AF999", new Flight("AF999", "DXB", "LAX", "AFR",120, 1, 23, 90, 250, 30, 100, 0, 0));
		
		when(appData.getFlightsInfo()).thenReturn(flights);
		
	}
	

	@Test
	void testGetMaxVolumePerBagForInvalidFlight() throws HWAirportException {
		
		Flight flight = flightSvc.getFlightByCode("AA123");
		
		assertEquals("AA123", flight.getCode());
		
	}

	@Test
	void testGetMaxWeightPerBagForFlight() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFlightMaxCapacity() {
		fail("Not yet implemented");
	}

	@Test
	void testIsMaxVolumeExceededForFlight() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFlightByCode() {
		fail("Not yet implemented");
	}

}
