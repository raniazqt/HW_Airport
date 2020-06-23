package com.hw.airport.model;

import java.util.Date;

/*
 * A class to hold the passenger information during the check in process.
 * In addition to the booking information, the baggage diminsioons and weight is added.
 * The status is for indictation the check in progress (IN_QUEUE, AT_DESK, PAYING_FEE,..) 
 */
public class Passenger {

	public enum CheckInProgress {
		IN_QUEUE, AT_DESK, PAYING_FEE
	}

	private String firstName;
	private String lastName;
	private Date dob;
	private String refCode;
	private String flightCode;
	private double baggageHeight;
	private double baggageWidth;
	private double baggageLength;
	private double xtraBagVolChrg;
	private double xtraBagWghtChrg;
	private CheckInProgress checkInStatus;
	
	public Passenger() {
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

	public CheckInProgress getCheckInStatus() {
		return checkInStatus;
	}

	public void setCheckInStatus(CheckInProgress checkInStatus) {
		this.checkInStatus = checkInStatus;
	}
	
	public void copyBookingToPassenger(Booking passenger) {
		
		
	}
	
}
