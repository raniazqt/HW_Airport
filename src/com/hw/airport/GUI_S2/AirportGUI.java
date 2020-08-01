package com.hw.airport.GUI_S2;

import java.util.Observer;

public interface AirportGUI extends com.hw.airport.observer.Observer
{
	void displayConfigScreen();
	void displayAirportMonitorScreen();
}
