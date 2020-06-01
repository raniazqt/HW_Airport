package com.hw.airport.service;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Desk;

public interface DeskSvc {

	Desk openDesk();

	void closeDesk();

	void addPassengerToDesk(Desk desk) throws HWAirportException;

	Desk getDeskDetails();

}
