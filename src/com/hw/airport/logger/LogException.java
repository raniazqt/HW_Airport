package com.hw.airport.logger;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

	/* We will use a DateFormat and parse a String pattern to create a new Date. 
	 * To log the ParseException that occurs;
	
	
	1)	Create a new SimpleDateFormat with a specific String pattern.
	2) 	Invoke the setLenient(boolean lenient) API method of the DateFormat, setting the lenient to false. 
	3) 	The inputs of the DateFormat parser must match this object’s format, or else a ParseException will be thrown.
	4) 	Invoke the log(Level level, String msg, Throwable thrown) API method to log a message, with the associated Throwable information. 
	*/
  
public class LogException {
     
    private static Logger logger = Logger.getLogger(LogException.class.getName());
  
    public static void main(String[] args) {
 
  DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
 
  df.setLenient(false);
  
 
  try {
 
 
// Set wrong date
 
 
Date date = df.parse("11/08/1984");
  
 
 
System.out.println("Date = " + date);
 
  } catch (ParseException e) {
 
 
 
 
    // Create log message 
 
 
if (logger.isLoggable(Level.SEVERE)) {
 
 
    logger.log(Level.SEVERE, "Error parsing date", e);
 
 
}
 
  }
    }
}
