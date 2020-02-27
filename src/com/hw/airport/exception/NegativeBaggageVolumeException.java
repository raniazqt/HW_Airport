package com.hw.airport.exception;

public class NegativeBaggageVolumeException extends HWAirportException {
    @Override
    public String getMessage() {
        return "Cannot have negative baggage volume, please check the values and try again";
    }
}
