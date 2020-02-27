package com.hw.airport.model;

public class FlightExtrasAndCharges {
	private String flightCode;
	private double xtraWeight;
	private double xtraVolume;
	private double xtraWeightCharge;
	private double xtraVolumeCharge;

	public FlightExtrasAndCharges() {
		super();
	}

	public FlightExtrasAndCharges(String flightCode, double xtraWeight, double xtraVolume, double xtraWeightCharge,
			double xtraVolumeCharge) {
		super();
		this.flightCode = flightCode;
		this.xtraWeight = xtraWeight;
		this.xtraVolume = xtraVolume;
		this.xtraWeightCharge = xtraWeightCharge;
		this.xtraVolumeCharge = xtraVolumeCharge;
	}

	public double getXtraWeight() {
		return xtraWeight;
	}

	public void setXtraWeight(double xtraWeight) {
		this.xtraWeight = xtraWeight;
	}

	public double getXtraVolume() {
		return xtraVolume;
	}

	public void setXtraVolume(double xtraVolume) {
		this.xtraVolume = xtraVolume;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public double getXtraWeightCharge() {
		return xtraWeightCharge;
	}

	public void setXtraWeightCharge(double xtraWeightCharge) {
		this.xtraWeightCharge = xtraWeightCharge;
	}

	public double getXtraVolumeCharge() {
		return xtraVolumeCharge;
	}

	public void setXtraVolumeCharge(double xtraVolumeCharge) {
		this.xtraVolumeCharge = xtraVolumeCharge;
	}
}
