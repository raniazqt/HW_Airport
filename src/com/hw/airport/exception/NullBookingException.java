package com.hw.airport.exception;

public class NullBookingException extends HWAirportException {
    @Override
    public String getMessage() {
        return "null booking for the provided reference and last name, please check the values and try again";
    }
}
