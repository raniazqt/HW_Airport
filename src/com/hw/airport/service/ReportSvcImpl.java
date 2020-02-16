package com.hw.airport.service;

import java.util.List;
import java.util.Map;

import com.hw.airport.model.AppData;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Flight;
import com.hw.airport.model.ReportData;

public class ReportSvcImpl implements ReportSvc{
	BookingSvc bookingSvc = new BookingSvcImpl();
	FlightSvc flightSvc = new FlightSvcImpl();
	
	AppData appData = AppData.getInstance();

	@Override
	public void generateSummaryReportPerFlight(String flightCode, List<Booking> bookings) {
		
		double totalVolume = 0;
		double totalWeight = 0;
		int psgrCnt = 0;
		
		ReportData data = new ReportData();
		
		Flight flight = flightSvc.getFlightByCode(flightCode);
		
		if (null == flight) {
			//do something
		}
		
		data.setFlightCode(flightCode);
		for(Booking booking : bookings) {
			if (booking.isCheckedIn()) {
				totalVolume += booking.getTotalBaggageVolume();
				totalWeight += booking.getTotalBaggageWeight();
				psgrCnt ++;
			}
		}
		data.setTotalPsgrCnt(psgrCnt);
		data.setTotalVolume(totalVolume);
		data.setTotalWeight(totalWeight);

		if (data.getTotalPsgrCnt() > flight.getMaxPasngrCnt()) {
			data.setExceededPsngrCnt(true);
		}
		
		if (data.getTotalVolume() > flight.getMaxFlightVolume()) {
			data.setExceededVolume(true);
		}
		
		if (data.getTotalWeight() > flight.getMaxFlightWeight()) {
			data.setExceededWeight(true);
		}
	}

	@Override
	public Map<String, List<Booking>> generateSummaryReportForAllFlights() {
		Map<String, List<Booking>> bookingsByFlight = bookingSvc.groupBookingByFlightCode();
		for (String b : bookingsByFlight.keySet() ) {
			this.generateSummaryReportPerFlight(b, bookingsByFlight.get(b));
		}
		return bookingsByFlight;
	}
}
