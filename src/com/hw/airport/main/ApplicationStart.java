package com.hw.airport.main;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.hw.airport.GUI.ScreenTemplate;
import com.hw.airport.model.AppData;
import com.hw.airport.model.Flight;
import com.hw.airport.service.DataSvc;
import com.hw.airport.service.DataSvcImpl;
import com.hw.airport.service.FlightSvc;
import com.hw.airport.service.FlightSvcImpl;

public class ApplicationStart {

	public static void main(String[] args) {
		AppData appData = AppData.getInstance();

		DataSvc dataSvc = new DataSvcImpl();
		
		FlightSvc flightSvc = new FlightSvcImpl();

		String flightsFileName = null; 
		String bookingFileName = null;

		appData.flightsInfo = dataSvc.loadFlightsData(flightsFileName); 
		appData.bookingList = dataSvc.loadBookingData(bookingFileName);
		

		Flight flight = flightSvc.getFlightByCode("HW123");
		System.out.println("Flight data " + flight.getCarrier() + " " + flight.getToAirport());
		JPanel contentPanel = new JPanel(new FlowLayout(SwingConstants.LEADING));
		contentPanel.setBorder(new LineBorder(Color.cyan, 4));


		ScreenTemplate template = new ScreenTemplate();
		template.createGUITemplate(contentPanel);
	}
}
