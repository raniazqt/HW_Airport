package com.hw.airport.model;

import java.util.Date;



public class Booking {	
	public enum BookingStatus {
		CHECKED_IN, NOT_CHECKED_IN, PROCESSING
	}

	private String firstName;
	private String lastName;
	private Date dob;
	private String refCode;
	private String flightCode;
	private BookingStatus checkInStatus;
	private double totalBaggageWeight;
	private double totalBaggageVolume;
	private double baggageHeight;
	private double baggageWidth;
	private double baggageLength;
	private double xtraBagVolChrg;
	private double xtraBagWghtChrg;

	public Booking() {
		super();
	}

	public Booking(String firstName, String lastName, String refCode, String flightCode, BookingStatus isCheckedIn) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.refCode = refCode;
		this.flightCode = flightCode;
		this.checkInStatus = isCheckedIn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getRefCode() {
		return refCode;
	}

	public void setRefCode(String refCode) {
		this.refCode = refCode;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public BookingStatus getCheckInStatus() {
		return checkInStatus;
	}

	public void setCheckInStatus(BookingStatus isCheckedIn) {
		this.checkInStatus = isCheckedIn;
	}

	public double getTotalBaggageWeight() {
		return totalBaggageWeight;
	}

	public void setTotalBaggageWeight(double totalBaggageWeight) {
		this.totalBaggageWeight = totalBaggageWeight;
	}

	public double getTotalBaggageVolume() {
		return totalBaggageVolume;
	}

	public void setTotalBaggageVolume(double totalBaggageVolume) {
		this.totalBaggageVolume = totalBaggageVolume;
	}

	public double getXtraBagVolChrg() {
		return xtraBagVolChrg;
	}

	public void setXtraBagVolChrg(double xtraBagVolChrg) {
		this.xtraBagVolChrg = xtraBagVolChrg;
	}

	public double getXtraBagWghtChrg() {
		return xtraBagWghtChrg;
	}

	public void setXtraBagWghtChrg(double xtraBagWghtChrg) {
		this.xtraBagWghtChrg = xtraBagWghtChrg;
	}

	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	public double getBaggageHeight() {
		return baggageHeight;
	}

	public void setBaggageHeight(double baggageHeight) {
		this.baggageHeight = baggageHeight;
	}

	public double getBaggageWidth() {
		return baggageWidth;
	}

	public void setBaggageWidth(double baggageWidth) {
		this.baggageWidth = baggageWidth;
	}

	public double getBaggageLength() {
		return baggageLength;
	}

	public void setBaggageLength(double baggageLength) {
		this.baggageLength = baggageLength;
	}

	public void calcXtraWghtChrg(double weightLimit, double weightRate) {

		if (this.totalBaggageWeight > 0) {

			this.setXtraBagWghtChrg((this.totalBaggageWeight - weightLimit) * weightRate);
		}

	}

	public void calcXtraVolChrg(double volumeLimit, double volumeRate) {
		if (this.totalBaggageVolume > 0) {

			this.setXtraBagVolChrg((this.totalBaggageVolume - volumeLimit) * volumeRate);
		}
	}

}
