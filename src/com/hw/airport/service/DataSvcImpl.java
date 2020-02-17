package com.hw.airport.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hw.airport.model.Booking;
import com.hw.airport.model.Flight;
import com.hw.airport.util.FileHandler;

public class DataSvcImpl implements DataSvc {

	//reads the data from flights file then convert it into a hashmap
	@Override
	public Map<String, Flight> loadFlightsData(String flightsFileName) {
		List<String[]> flightsData = FileHandler.parseFile(flightsFileName);
		//read file data into hashmap
		//Temp code to populate the flight map
		flightsData.add(new String[] {"AA123", "DXB", "DFW", "AAL","200", "1", "23", "60", "150", "10", "50","1000","2000"});
		flightsData.add(new String[] {"AF999", "DXB", "LAX", "AFR","120", "1", "23", "90", "250", "30", "100","1000","2000"});
		flightsData.add(new String[] {"AI123", "DXB", "DEL", "AIC","300", "1", "30", "90", "350", "70", "80","1000","2000"});
		
				
		Map<String, Flight> flights = new HashMap<String, Flight>();
		
		for(String[] line : flightsData ) {
			Flight flight = new Flight(line[0], line[1], line[2], line[3],Integer.parseInt(line[4]),
					Integer.parseInt(line[5]), Integer.parseInt(line[6]), Double.parseDouble(line[7]),
					Double.parseDouble(line[8]),Double.parseDouble(line[9]),Double.parseDouble(line[10]),
					Double.parseDouble(line[11]), Double.parseDouble(line[12]));
			flights.put(line[0],flight);
		}
		/*
		 * flights.put("AA123", new Flight("AA123", "DXB", "DFW", "AAL",200, 1, 23, 60,
		 * 150, 10, 50)); flights.put("AF999", new Flight("AF999", "DXB", "LAX",
		 * "AFR",120, 1, 23, 90, 250, 30, 100)); flights.put("AI123", new
		 * Flight("AI123", "DXB", "DEL", "AIC",300, 1, 30, 90, 350, 70, 80));
		 * flights.put("CA123", new Flight("CA123", "DXB", "CAN", "CCA",400, 1, 35, 100,
		 * 220, 100, 150)); flights.put("MS123", new Flight("MS123", "DXB", "CAI",
		 * "MSR",330, 1, 23, 160, 420, 50, 420)); flights.put("GA123", new
		 * Flight("GA123", "DXB", "BDO", "GAI",200, 1, 23, 160, 150, 10, 50));
		 * flights.put("ME123", new Flight("ME123", "DXB", "BEY", "MEL",170, 1, 27, 120,
		 * 125, 70, 150));
		 */
		return flights;
	}

	@Override
	public Map<String, Booking> loadBookingData(String bookingFileName) {
		List<String[]> bookingData = FileHandler.parseFile(bookingFileName);
		
		bookingData.add(new String[] {"Martin","Raymond","ABC123","AA123","FALSE"});
		bookingData.add(new String[] {"Martin","Raymond","SAL777","AI123","FALSE"});

		bookingData.add(new String[] {"Rose","Henry","DES220","AA123","FALSE"});
		bookingData.add(new String[] {"Betty","Wayne","OPR900","AF999","FALSE"});


		Map<String, Booking> bookingList = new HashMap<String, Booking>();
		Booking booking;
		for(String[] line : bookingData) {
			String refCode = line[2];
			booking = new Booking(line[0], line[1], line[2], line[3], Boolean.getBoolean(line[4]));
			bookingList.put(refCode, booking);
		}

		/*bookingList.put("ABC123",new Booking("Martin","Raymond","ABC123","AA123",Boolean.FALSE));
		bookingList.put("SAL777",new Booking("Martin","Raymond","SAL777","MS123",Boolean.FALSE));
		bookingList.put("DES220",new Booking("Rose","Henry","DES220","AA123",Boolean.FALSE));
		bookingList.put("OPR900",new Booking("Betty","Wayne","OPR900","GA123",Boolean.FALSE));
		bookingList.put("QRSUIP",new Booking("Donald","Francis","QRSUIP","ME123",Boolean.FALSE));
		bookingList.put("GGHQSM",new Booking("Gilbert","Leonard","GGHQSM","CA123",Boolean.FALSE));
		bookingList.put("SDSAAA",new Booking("Sarah","Kamal","SDSAAA","CA123",Boolean.FALSE));
		bookingList.put("ORMORM",new Booking("Calvin","Ralph","ORMORM","GA123",Boolean.FALSE));
		bookingList.put("HASOOO",new Booking("Gilbert","Leonard","HASOOO","AF999",Boolean.FALSE));*/
		return bookingList;
	}

}
