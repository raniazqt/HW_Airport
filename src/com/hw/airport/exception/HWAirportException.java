package com.hw.airport.exception;

public class HWAirportException extends Exception {

	public HWAirportException() {
		super();
	}

	public HWAirportException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public HWAirportException(String message, Throwable cause) {
		super(message, cause);
	}

	public HWAirportException(String message) {
		super(message);
	}

	public HWAirportException(Throwable cause) {
		super(cause);
	}
}
