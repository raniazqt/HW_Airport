package com.hw.airport.exception;

public class InvalidFlightCodeException extends HWAirportException {
    @Override
    public String getMessage() {
        return "no flight was found for the given flight code, please check the flight code provided and try again.";
    }
}
