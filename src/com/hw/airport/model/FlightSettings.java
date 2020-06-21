package com.hw.airport.model;

import java.util.ArrayList;
import java.util.List;

public class FlightSettings {
	String flightCd;
	int timer;
	
	
	public FlightSettings() {
		super();
	}
	public FlightSettings(String flightCd, int timer) {
		super();
		this.flightCd = flightCd;
		this.timer = timer;
	}
	public String getFlightCd() {
		return flightCd;
	}
	public void setFlightCd(String flightCd) {
		this.flightCd = flightCd;
	}
	public int getTimer() {
		return timer;
	}
	public void setTimer(int timer) {
		this.timer = timer;
	}
	
	
	

}
