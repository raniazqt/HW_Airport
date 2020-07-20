package com.hw.airport.service;

import com.hw.airport.enums.DESK_STATUS;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Desk;

public interface DeskSvc {

	Desk openDesk();

	void loadDesk(Desk desk) throws HWAirportException;

	Desk getDeskDetails();

	void closeDesk(Desk desk);
	
	void clearDesk(Desk desk);

	//void processPassengersQueue(Desk desk) throws HWAirportException;

	void updateStatus(Desk desk, DESK_STATUS status);


}
