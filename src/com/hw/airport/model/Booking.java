package com.hw.airport.model;

import java.util.Date;

public class Booking {
	private String firstName;
	private String lastName;
	private Date dob;
	//booking reference code
	private String refCode;
	private String flightCode;
	private boolean isCheckedIn;
	private double totalBaggageWeight;
	private double totalBaggageVolume;
	private double xtraBagVolChrg;
	private double xtraBagWghtChrg;
	
	
	
	public Booking() {
		super();
	}
	public Booking(String firstName, String lastName, String refCode, String flightCode,
			boolean isCheckedIn) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.refCode = refCode;
		this.flightCode = flightCode;
		this.isCheckedIn = isCheckedIn;
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
	public boolean isCheckedIn() {
		return isCheckedIn;
	}
	public void setCheckedIn(boolean isCheckedIn) {
		this.isCheckedIn = isCheckedIn;
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
}
