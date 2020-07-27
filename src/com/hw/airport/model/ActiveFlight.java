package com.hw.airport.model;

public class ActiveFlight {

	//TODO: must be set correctly, used to track flight panels.
	String flightCode;
	String flightCd;
	int timer;
	int boardedPsngrCnt;
	double totalVolume;
	double totalWeight;
	double xtraChargeCollected;
	
	
	public double getXtraChargeCollected() {
		return xtraChargeCollected;
	}
	public void setXtraChargeCollected(double xtraChargeCollected) {
		this.xtraChargeCollected = xtraChargeCollected;
	}
	public ActiveFlight() {
		super();
	}
	public ActiveFlight(String flightCd, int timer) {
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
	public int getBoardedPsngrCnt() {
		return boardedPsngrCnt;
	}
	public double getTotalVolume() {
		return totalVolume;
	}
	public double getTotalWeight() {
		return totalWeight;
	}
	public void setBoardedPsngrCnt(int boardedPsngrCnt) {
		this.boardedPsngrCnt = boardedPsngrCnt;
	}
	public void setTotalVolume(double volume) {
		this.totalVolume = volume;
	}
	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}
	public void setFlightCode(String flightCode) {this.flightCode = flightCode;}
	public String getFlightCode() {return this.flightCode;}
	
}
