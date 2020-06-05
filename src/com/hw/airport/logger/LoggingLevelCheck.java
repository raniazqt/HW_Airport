package com.hw.airport.logger;

import java.util.logging.Logger;
import java.util.logging.Level;

public class LoggingLevelCheck {
	
	/* This class checks if a message is loggable. Our Logger uses a logging.Level set to WARNING 
	 * and then log messages in different levels, in order to check if they are loggable. 
	1) 	Create an instance of Logger, with the getLogger(String name) API method, 
	using as parameter the name of Class that uses the Logger.
	2) 	Set the logging level to Level.WARNING, with the setLevel(Level newLevel) 
	API method of the Logger. In this case logging at WARNING and all higher levels is enabled.
	3) Use the isLoggable(Level level) API method of the Logger for different levels, 
	such as INFO, WARNING, SEVERE, and use the corresponding methods of the logger, info(String msg), 
	warning(String msg), severe(String msg) to log a message in different levels. Since the level is set to WARNING
	*/
	     
	    public static void main(String[] args) {
	 
	   
	  // Create an instance of Logger and set the logging level to Level.WARNING.
	 
	  Logger log = Logger.getLogger(LoggingLevelCheck.class.getName());
	 
	  log.setLevel(Level.WARNING);
	  
	 
	  // Log INFO level message
	 
	  if (log.isLoggable(Level.INFO)) {
	 
	 
	log.info("Airport Check In Application INFO Message");
	 
	  }
	  
	 
	  // Log WARNING level message when Level.WARNING is loggable.
	 
	  if (log.isLoggable(Level.WARNING)) {
	 
	 
	log.warning("Airport Check In Application WARNING Information");
	 
	  }
	  
	 
	  // Log SEVERE level message when Level.SEVERE is loggable.
	 
	  if (log.isLoggable(Level.SEVERE)) {
	 
	 
	log.severe("Airport Check In Info SEVERE Information");
	      
	 
	  }
	    }
	}
