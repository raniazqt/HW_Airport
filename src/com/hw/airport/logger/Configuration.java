package com.hw.airport.logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

	/*
	We provide configuration properties to a Logger using a configuration file. 
	This helps you to remove the configuration from the code and provides an easy way to re-configure 
	whenever it is required without changing the code again and again. 
	This flexibility is provided by the LogManager class.
	*/
 
public class Configuration {
 
    private static final LogManager logManager = LogManager.getLogManager();
    private static final Logger LOGGER = Logger.getLogger("confLogger");
    static{
        try {
            logManager.readConfiguration(new FileInputStream("./airportLog.properties"));
        } catch (IOException exception) {
            LOGGER.log(Level.SEVERE, "Error in loading configuration",exception);
        }
    }
    public static void main(String[] args) {
        LOGGER.fine("Fine message logged");
    }
}
