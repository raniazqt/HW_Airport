package com.hw.airport.exception;

/**
 * an exception that's thrown when there is a mismatch between the provided last name and the last name in the data records for a given booking reference.
 */
public class BookingLastNameMismatchException extends HWAirportException {
    @Override
    public String getMessage() {
        return "last name provided does not match our records for the provided booking reference, please check the values and try again";
    }
}
