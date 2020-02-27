package com.hw.airport.exception;

public class NegativeBaggageWeightException extends HWAirportException {
    @Override
    public String getMessage() {
        return "cannot have -ve value for baggage weight, please check the values and try again.";
    }
}
