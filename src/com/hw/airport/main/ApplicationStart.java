package com.hw.airport.main;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.hw.airport.GUI.ScreenTemplate;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.AppData;
import com.hw.airport.model.Flight;
import com.hw.airport.service.DataSvc;
import com.hw.airport.service.DataSvcImpl;
import com.hw.airport.service.FlightSvc;
import com.hw.airport.service.FlightSvcImpl;

public class ApplicationStart {

	public static void main(String[] args) throws HWAirportException {
		//we need an ApplicationManager that allocates and initializes all services and handles the simulation otherwise the main function would be messy
		// service dependencies should be handled on construction.
		//this  stuff is why we had to create an architecture upfront.
		AppData appData = AppData.getInstance();
		DataSvc dataSvc = new DataSvcImpl();
		FlightSvc flightSvc = new FlightSvcImpl();

		String flightsFileName = null; 
		String bookingFileName = null;

		appData.setFlightsInfo(dataSvc.loadFlightsData(flightsFileName)); 
		appData.setBookingList(dataSvc.loadBookingData(bookingFileName));
		
		Flight flight = flightSvc.getFlightByCode("AA123");
		System.out.println("Flight data " + flight.getCarrier() + " " + flight.getToAirport());
		String code = "AA123";

		System.out.println("Baggage max volume allowed for Flight code " + code + " is " + flightSvc.getMaxVolumePerBagForFlight(code));
		System.out.println("Baggage max weight allowed for Flight code " + code + " is " + flightSvc.getMaxWeightPerBagForFlight(code));
		
		/*
		 * JPanel contentPanel = new JPanel(new FlowLayout(SwingConstants.LEADING));
		 * contentPanel.setBorder(new LineBorder(Color.cyan, 4));
		 * 
		 * ScreenTemplate template = new ScreenTemplate();
		 * template.createGUITemplate(contentPanel);
		 */
	}
}
