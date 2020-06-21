package com.hw.airport.main;

import com.hw.airport.exception.HWAirportException;

public class ApplicationStart {

	public static void main(String[] args) throws HWAirportException {
		ApplicationManager appManager = new ApplicationManager();
		appManager.execute();
		
		
	}
}