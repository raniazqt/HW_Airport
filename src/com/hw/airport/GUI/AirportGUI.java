package com.hw.airport.GUI;

import com.hw.airport.config.AirportGuiSettings;

public interface AirportGUI extends com.hw.airport.observer.Observer
{
	void displayConfigScreen();
	void displayAirportMonitorScreen();
	void displayEndOfSimulationScreen();
	void setAirportGuiSettings(String fileName);
	AirportGuiSettings getAirportGuiSettings();
}
