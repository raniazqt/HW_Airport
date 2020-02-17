package com.hw.airport.model;

public class ReportData {

	String flightCode;
	int totalPsgrCnt;
	double totalWeight;
	double totalVolume;
	double xtraPaidFees;
	boolean exceededWeight;
	boolean exceededVolume;
	boolean exceededPsngrCnt;
	public String getFlightCode() {
		return flightCode;
	}
	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}
	public int getTotalPsgrCnt() {
		return totalPsgrCnt;
	}
	public void setTotalPsgrCnt(int totalPsgrCnt) {
		this.totalPsgrCnt = totalPsgrCnt;
	}
	public double getTotalWeight() {
		return totalWeight;
	}
	public void setTotalWeight(double totalWeiht) {
		this.totalWeight = totalWeiht;
	}
	public double getTotalVolume() {
		return totalVolume;
	}
	public void setTotalVolume(double totalVolume) {
		this.totalVolume = totalVolume;
	}
	public double getXtraPaidFees() {
		return xtraPaidFees;
	}
	public void setXtraPaidFees(double xtraPaidFees) {
		this.xtraPaidFees = xtraPaidFees;
	}
	public boolean isExceededWeight() {
		return exceededWeight;
	}
	public void setExceededWeight(boolean exceededWeight) {
		this.exceededWeight = exceededWeight;
	}
	public boolean isExceededVolume() {
		return exceededVolume;
	}
	public void setExceededVolume(boolean exceededVolume) {
		this.exceededVolume = exceededVolume;
	}
	public boolean isExceededPsngrCnt() {
		return exceededPsngrCnt;
	}
	public void setExceededPsngrCnt(boolean exceededPsngrCnt) {
		this.exceededPsngrCnt = exceededPsngrCnt;
	}
}
