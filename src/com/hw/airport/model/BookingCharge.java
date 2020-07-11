package com.hw.airport.model;

public class BookingCharge {
	
	String refCode;
	String lastName;
	int bagCnt;
	double length, width, depth, weight;
	double weightCharge;
	double volumeCharge;

	public BookingCharge() {
		super();
	}

	public BookingCharge(String refCode, String lastName, int bagCnt, double length, double width, double depth,
			double weight) {
		super();
		this.refCode = refCode;
		this.lastName = lastName;
		this.bagCnt = bagCnt;
		this.length = length;
		this.width = width;
		this.depth = depth;
		this.weight = weight;
	}

	public BookingCharge(String refCode, String lastName, int bagCnt, double length, double width, double depth,
			double weight, double weightCharge, double volumeCharge) {
		super();
		this.refCode = refCode;
		this.lastName = lastName;
		this.bagCnt = bagCnt;
		this.length = length;
		this.width = width;
		this.depth = depth;
		this.weight = weight;
		this.weightCharge = weightCharge;
		this.volumeCharge = volumeCharge;
	}

	public String getRefCode() {
		return refCode;
	}

	public void setRefCode(String refCode) {
		this.refCode = refCode;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getBagCnt() {
		return bagCnt;
	}

	public void setBagCnt(int bagCnt) {
		this.bagCnt = bagCnt;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWeightCharge() {
		return weightCharge;
	}

	public void setWeightCharge(double weightCharge) {
		this.weightCharge = weightCharge;
	}

	public double getVolumeCharge() {
		return volumeCharge;
	}

	public void setVolumeCharge(double volumeCharge) {
		this.volumeCharge = volumeCharge;
	}

	public double getTotalChg() {
		return this.volumeCharge + this.weightCharge;
	}
	
	public double getVolume() {
		
		return depth * width * length;
	}
}
