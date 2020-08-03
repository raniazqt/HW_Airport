package com.hw.airport.GUI;

public interface AirportGUI extends com.hw.airport.observer.Observer
{
	void displayConfigScreen();
	void displayAirportMonitorScreen();
	void setAirportGuiSettings(String fileName);
}
