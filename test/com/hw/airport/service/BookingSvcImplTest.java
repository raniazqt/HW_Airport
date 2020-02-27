package com.hw.airport.service;

import static org.junit.jupiter.api.Assertions.*;

import org.mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.hw.airport.model.AppData;

class BookingSvcImplTest {

	@InjectMocks
	FlightSvc flightSvc;

	@InjectMocks
	AppData mockData;

	@Mock
	BookingSvc bookingSvc;

	@org.junit.jupiter.api.BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@org.junit.jupiter.api.AfterEach
	void tearDown() {
	}

	@org.junit.jupiter.api.Test
	void findBookingByLastNameAndRefCode() {
	}

	@org.junit.jupiter.api.Test
	void updateBookingStatus() {
	}

	@org.junit.jupiter.api.Test
	void getCountOfCheckedInPassengersByFlight() {
	}

	@org.junit.jupiter.api.Test
	void calculateExtraChargeForFlight() {
	}

	@org.junit.jupiter.api.Test
	void findAllBookingForFlight() {
	}

	@org.junit.jupiter.api.Test
	void groupBookingByFlightCode() {
	}
}