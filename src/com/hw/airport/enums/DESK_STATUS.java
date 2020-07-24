package com.hw.airport.enums;

public enum DESK_STATUS {

		AVAILABLE ("Available"), 
		BUSY ("Busy"), 
		CLOSED ("Closed"), 
		GET_PASSENGER_FROM_QUEUE ("Greeting Customer"), 
		VALIDATE_PASSENGER_DATA ("Validate customer data"), 
		CHECK_FLIGHT_STATUS ("Checking flight status"), 
		CALCULATE_XTRA_CHARGES ("Calculating baggaes extra charge"), 
		PROCESS_PAYMENT ("Processing payment"), 
		UPDATE_PASSENGER_FLIGHT_DATA ("Updating passengers and flight information");

	    private String value;
	    
		DESK_STATUS(String value) {
			this.value= value;
		}
		
		
		public String getValue() {
			return value;
		}


		public void setValue(String value) {
			this.value = value;
		}


		@Override
		public String toString() {
			return this.getValue();
		}
		
		
}
