package com.hw.airport.logger;

import java.io.IOException;
import java.util.logging.Formatter;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

	/*
	A Formatter is used to format a LogRecord. Each handler is associated with a formatter. 
	Java provides the Formatter as a parent class of two in-built formatter’s i.e. SimpleFormatter and XMLFormatter
	
	This prints the LogRecord in a simple human readable format. Please note that before setting the 
	SimpleFormatter to the handler, we have logged a message which is published in an XML format, 
	this is because the XMLFormatter is the default formatter for the FileHandler. Also note that the LogRecord is 
	also published in the console because the ConsoleHandler is by default associated with the Logger.
	
	SimpleFormatter(): This constructor is used to create a SimpleFormatter object.
	
	void setFormatter(Formatter newFormatter): This method is from the Handler class and used 
	to set the formatter to the handler.
	*/
 
public class Formatter {
 
    private static final Logger LOGGER = Logger.getLogger(Logger.class.getName());
    public static void main(String[] args) {
 
        Handler fileHandler = null;
        Formatter simpleFormatter = null;
        try{
             
            // Creating FileHandler
            fileHandler = new FileHandler("./airportLog.formatter.log");
             
            // Creating SimpleFormatter
            simpleFormatter = new SimpleFormatter();
             
            // Assigning handler to logger
            LOGGER.addHandler(fileHandler);
             
            // Logging message of Level info (this should be publish in the default format i.e. XMLFormat)
            LOGGER.info("Finest message: Logger with DEFAULT FORMATTER");
             
            // Setting formatter to the handler
            fileHandler.setFormatter(simpleFormatter);
             
            // Setting Level to ALL
            fileHandler.setLevel(Level.ALL);
            LOGGER.setLevel(Level.ALL);
             
            // Logging message of Level finest (this should be publish in the simple format)
            LOGGER.finest("Finest message: Logger with SIMPLE FORMATTER");
        }catch(IOException exception){
            LOGGER.log(Level.SEVERE, "Error occur in FileHandler.", exception);
        }
    }
 
}