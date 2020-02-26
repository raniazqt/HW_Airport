package com.hw.airport.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hw.airport.exception.HWAirportException;



public class FileHandler {

	//Reads the data from the file with the given name and load it in a list of string array.
	public static List<String[]> parseFile(String fileName) throws HWAirportException{

		File file = new File("resources/files/" +fileName);
		List<String> records = new ArrayList<String>();
		List<String[]> data = new ArrayList<String[]>();
		records = readFile(file);
		data = splitRowsIntoFields(records);

		return data;
	}

	private static List<String[]> splitRowsIntoFields(List<String> rows) {
		List<String> data = new ArrayList<String>();
		List<String[]> appData = new ArrayList<String[]>();
		Scanner scanner = null ;
		for(String row : rows) {
			scanner = new Scanner(row);
			scanner.useDelimiter(",");
			 data = new ArrayList<String>();

			while (scanner.hasNext()) {
				data.add(scanner.next());
			}
			appData.add(data.toArray(new String[data.size()]));
			try {
			}catch(Exception ex) {
				System.out.println("Error occured while loading record " + data);
				System.out.println("Record ignored");
			}
		}
		scanner.close();
		return appData;

	}

	public static List<String> readFile(File file) throws HWAirportException {
		Scanner scanner = null;
		List<String> records = new ArrayList<String>();
		try {
			scanner = new Scanner(file);
			//skip header line
			scanner.nextLine();
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				records.add(line);
			}
		} catch (FileNotFoundException e) {
			HWAirportException ex = new HWAirportException("Application failed to start! The data file was not found");
			ex.printStackTrace(); 
		}finally {
			scanner.close();
		}
		return records;
	}





}
