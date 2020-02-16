package com.hw.airport.model;

public class Flight {
	//flight number
	private String code;
	private String toAirport;
	private String fromAirport;
	//Airline name
	private String carrier;
	//Number of passengers allowed on the flight
	private int maxPasngrCnt;
	//Count of baggeges allowed for each traveller
	private int bagPerPsngrCnt;
	//maximum weight of each baggage
	private int maxBagWeight;
	//maximum volume allowed for each bag. Calculated based on the lugg luggage dimensions
	private double maxBagVolume;
	//charge for each extra luggage
	private double xtraBagCharge;
	//charge for extra weight per luggage 
	private double xtraWghtChargePerKg;
	private double xtraVolumeCharge;
	
	private double maxFlightVolume;
	private double maxFlightWeight;
	
	
	
	
	public Flight(String code, String toAirport, String fromAirport, String carrier, int maxPasngrCnt,
			int bagPerPsngrCnt, int maxBagWeight, double maxBagVolume, double xtraBagCharge, double xtraWghtChargePerKg,
			double xtraVolumeCharge) {
		super();
		this.code = code;
		this.toAirport = toAirport;
		this.fromAirport = fromAirport;
		this.carrier = carrier;
		this.maxPasngrCnt = maxPasngrCnt;
		this.bagPerPsngrCnt = bagPerPsngrCnt;
		this.maxBagWeight = maxBagWeight;
		this.maxBagVolume = maxBagVolume;
		this.xtraBagCharge = xtraBagCharge;
		this.xtraWghtChargePerKg = xtraWghtChargePerKg;
		this.xtraVolumeCharge = xtraVolumeCharge;
	}


	public Flight(String code, String toAirport, String fromAirport, String carrier) {
		super();
		this.code = code;
		this.toAirport = toAirport;
		this.fromAirport = fromAirport;
		this.carrier = carrier;
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getToAirport() {
		return toAirport;
	}
	public void setToAirport(String toAirport) {
		this.toAirport = toAirport;
	}
	public String getFromAirport() {
		return fromAirport;
	}
	public void setFromAirport(String fromAirport) {
		this.fromAirport = fromAirport;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public int getMaxPasngrCnt() {
		return maxPasngrCnt;
	}
	public void setMaxPasngrCnt(int maxPasngrCnt) {
		this.maxPasngrCnt = maxPasngrCnt;
	}
	public int getBagPerPsngrCnt() {
		return bagPerPsngrCnt;
	}
	public void setBagPerPsngrCnt(int bagPerPsngrCnt) {
		this.bagPerPsngrCnt = bagPerPsngrCnt;
	}
	public int getMaxBagWeight() {
		return maxBagWeight;
	}
	public void setMaxBagWeight(int maxBagWeight) {
		this.maxBagWeight = maxBagWeight;
	}
	public double getMaxBagVolume() {
		return maxBagVolume;
	}
	public void setMaxBagVolume(double maxBagVolume) {
		this.maxBagVolume = maxBagVolume;
	}
	public double getXtraBagCharge() {
		return xtraBagCharge;
	}
	public void setXtraBagCharge(double xtraBagCharge) {
		this.xtraBagCharge = xtraBagCharge;
	}
	
	public double getXtraWghtChargePerKg() {
		return xtraWghtChargePerKg;
	}


	public void setXtraWghtChargePerKg(double xtraWghtChargePerKg) {
		this.xtraWghtChargePerKg = xtraWghtChargePerKg;
	}


	public double getXtraVolumeCharge() {
		return xtraVolumeCharge;
	}


	public void setXtraVolumeCharge(double xtraVolumeCharge) {
		this.xtraVolumeCharge = xtraVolumeCharge;
	}


	public double getMaxFlightVolume() {
		return maxFlightVolume;
	}


	public void setMaxFlightVolume(double maxFlightVolume) {
		this.maxFlightVolume = maxFlightVolume;
	}


	public double getMaxFlightWeight() {
		return maxFlightWeight;
	}


	public void setMaxFlightWeight(double maxFlightWeight) {
		this.maxFlightWeight = maxFlightWeight;
	}
	
	

}
