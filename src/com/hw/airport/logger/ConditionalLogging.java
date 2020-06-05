package com.hw.airport.logger;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Date;

	/*
	 * TWe use Conditional logging. 
	 * We check the Level for which the Logger is enabled before we log a message to that level. 
	 * We have implemented a Class that uses a logger. The Class consists of a simple method that uses the logger 
	 * to log messages after checking the logging level. 
	
	1) 	Create a Class and create a new logger instance for the Class.
	2) 	Create a new instance of the class and invoke its method. 
	3)	The method has a simple functionality.
	4) 	In the beginning and at the end of the method check if the logger level is set to INFO. 
	5) 	If so, use the info(String msg) API method to log a message.
	*/
  
public class ConditionalLogging {
     
    private Logger logger = Logger.getLogger(ConditionalLogging.class.getName());
  
    public static void main(String[] args) {
         
 
  ConditionalLogging example = new ConditionalLogging();
 
  example.Method();
    }
  
  
    public void Method() {
 
 
  // Check if the logging level before enter into the log
 
  if (logger.isLoggable(Level.INFO)) {
 
 
logger.info("Entering executeMethod() at : " + new Date());
 
  }
  
 
  // Method functionality
 
  for (int i = 0; i < 5; i++) {
 
 
for (int j = 0; j < 5; j++) {
 
 
    System.out.print(i + j + " ");
 
 
}
 
 
System.out.println("");
 
  }
  
 
  if (logger.isLoggable(Level.INFO)) {
 
 
logger.info("Exiting executeMethod() at  : " + new Date());
 
  }
    }
}