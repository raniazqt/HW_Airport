package com.hw.airport.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.AppData;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Flight;
import com.hw.airport.model.FlightExtrasAndCharges;
import com.hw.airport.model.ReportData;

public class ReportSvcImpl implements ReportSvc{
	BookingSvc bookingSvc = new BookingSvcImpl();
	FlightSvc flightSvc = new FlightSvcImpl();
	
	AppData appData = AppData.getInstance();

	@Override
	public ReportData generateSummaryReportPerFlight(String flightCode, List<Booking> bookings) {
		
		int psgrCnt = 0;
		
		ReportData data = new ReportData();
		FlightExtrasAndCharges xtraCharge = new FlightExtrasAndCharges() ;
		
		Flight flight = flightSvc.getFlightByCode(flightCode);
		
		if (null == flight) {
			//do something
		}
		
		data.setFlightCode(flightCode);
		try {
			xtraCharge = bookingSvc.calculateExtraChargeForFlight(flightCode);
		} catch (HWAirportException e) {
			// TODO Auto-generated catch block
		}
		try {
			psgrCnt = bookingSvc.getCountOfCheckedInPassengersByFlight(flightCode);
		} catch (HWAirportException e) {
			// TODO Auto-generated catch block
		}
		
		data.setTotalPsgrCnt(psgrCnt);
		data.setTotalVolume(xtraCharge.getXtraVolumeCharge());
		data.setTotalWeight(xtraCharge.getXtraWeightCharge());

		if (data.getTotalPsgrCnt() > flight.getMaxPasngrCnt()) {
			data.setExceededPsngrCnt(true);
		}
		
		if (data.getTotalVolume() > flight.getMaxFlightVolume()) {
			data.setExceededVolume(true);
		}
		
		if (data.getTotalWeight() > flight.getMaxFlightWeight()) {
			data.setExceededWeight(true);
		}
		return data;
		
	}

	@Override
	public void generateSummaryReportForAllFlights() throws FileNotFoundException, IOException {
		Map<String, List<Booking>> bookingsByFlight = bookingSvc.groupBookingByFlightCode();
		ReportData data;
		List<ReportData> reportDataList= new ArrayList<ReportData>();
		for (String b : bookingsByFlight.keySet() ) {
			try {
			data = this.generateSummaryReportPerFlight(b, bookingsByFlight.get(b));
			reportDataList.add(data);
			}catch (Exception ex){
				
			}
		}
		this.writToExcelFile(reportDataList);
	}
	
	private void writeFlightSummaryReport(Map<String, List<Booking>> reportData) {
		
	}
	

	@Override
	public void writeToReportFile() {

		File output = new File("./resources/files/FlightSummaryReport.txt"); 
		String newLine = System.getProperty("line.separator");

		try (FileWriter fr = new FileWriter(output); BufferedWriter br = new BufferedWriter(fr)){
			br.write(
					String.format("%-10s","Flight#") 
					+ String.format("%-30s","Passengers Count")						
					+ String.format("%-5s","Total Weight")
					+ String.format("%-15s","Total Volume") 
					+ String.format("%-15s","Extra Fess Collected")
					+ String.format("%-20s","Exceeded Total Passengers")					
					+ String.format("%-20s","Exceeded Total Weight") 
					+ String.format("%-10s","Exceeded Total Volume")
					+ newLine);
			
			/*
			 * for (RBCompetitor comp : comps) { br.write(
			 * String.format("%-10s",comp.getNumber()) + String.format("%-30s",
			 * comp.getName().getFullName()) + String.format("%-5s", comp.getAge()) +
			 * String.format("%-15s",comp.getLevel().toUpperCase()) +
			 * String.format("%-15s",comp.printScores()) +
			 * String.format("%-20s",comp.getScoresAverage()) +
			 * String.format("%-10s",comp.getOverallScore()) + newLine);
			 * 
			 * }
			 */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void writToExcelFile(List<ReportData> data) throws FileNotFoundException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Flight Summary");
         
        Object[][] bookData = {
                {"Head First Java", "Kathy Serria", 79},
                {"Effective Java", "Joshua Bloch", 36},
                {"Clean Code", "Robert martin", 42},
                {"Thinking in Java", "Bruce Eckel", 35},
        };
        
        int rowCount = 0;
        int columnCount = 0;
        Row row = sheet.createRow(++rowCount);
        row.createCell(++columnCount).setCellValue("Flight#");
        row.createCell(++columnCount).setCellValue("Passengers Count");
        row.createCell(++columnCount).setCellValue("Total Weight");
        row.createCell(++columnCount).setCellValue("Total Volume");
        row.createCell(++columnCount).setCellValue("Extra Fees Collected");
        row.createCell(++columnCount).setCellValue("Exceeded Total Passengers");
        row.createCell(++columnCount).setCellValue("Exceeded Total Weight");
        row.createCell(++columnCount).setCellValue("Exceeded Total Volume");
        
        //Set the column width to auto
        for(int colNum = 0; colNum<row.getLastCellNum();colNum++)   
            sheet.autoSizeColumn(colNum);
                 
        for (ReportData line : data) {
            row = sheet.createRow(++rowCount);
            columnCount = 0;
            row.createCell(++columnCount).setCellValue(line.getFlightCode());
            row.createCell(++columnCount).setCellValue(line.getTotalPsgrCnt());
            row.createCell(++columnCount).setCellValue(line.getTotalWeight());
            row.createCell(++columnCount).setCellValue(line.getTotalVolume());
            row.createCell(++columnCount).setCellValue(line.getXtraPaidFees());
            row.createCell(++columnCount).setCellValue(line.isExceededPsngrCnt());
            row.createCell(++columnCount).setCellValue(line.isExceededWeight());
            row.createCell(++columnCount).setCellValue(line.isExceededVolume());
            }
             
        try (FileOutputStream outputStream = new FileOutputStream("./resources/files/FlightSummaryReport.xlsx")) {
            workbook.write(outputStream);
        }
    }
}
