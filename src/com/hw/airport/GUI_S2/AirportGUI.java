package com.hw.airport.GUI_S2;

import com.hw.airport.config.AirportGuiSettings;

public interface AirportGUI extends com.hw.airport.observer.Observer
{
	void displayConfigScreen();
	void displayAirportMonitorScreen();
	void setAirportGuiSettings(String fileName);
	AirportGuiSettings getAirportGuiSettings();
}
