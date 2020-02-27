package com.hw.airport.exception;

public class MissingBookingException extends HWAirportException {
    @Override
    public String getMessage() {
        return "no booking was found for the provided last name and reference, please check the values and try again";
    }
}
