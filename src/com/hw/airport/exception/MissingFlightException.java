package com.hw.airport.exception;

public class MissingFlightException extends HWAirportException {
    private String flightRef;
    private String serviceUsed;

    public MissingFlightException(){
        super();
    }
    public MissingFlightException(String flightRefUsed, String serviceUsingFlight) {
        super();
        flightRef = flightRefUsed;
        serviceUsed = serviceUsingFlight;
    }

    @Override
    public String getMessage() {
        return "No flight was found with the flight code: " + flightRef + " please check the flight code provided to " + serviceUsed + " and try again";
    }
}
