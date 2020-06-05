package com.hw.airport.logger;

import java.util.logging.Logger;
import java.util.logging.ConsoleHandler;

	/* The class prevents the logger from sending log messages to its parent logger. 
	 * When a Logger is used, 
	 * it keeps track of a parent Logger, which is its nearest existing ancestor in the Logger namespace. 
	 * By default, the logger publishes to its parent’s Handler. To prevent the logger from sending log messages 
	 * to its parent Logger you should:
	
	1) 	Create a Logger instance for the named subsystem.
	2) 	Invoke its setUseParentHandlers(boolean useParentHandlers) 
	API method and parameter set to false, so that the logger will not send its output to its parent Logger.
	3) 	Invoke the addHandler(Handler handler) API method of the Logger so as to specify a Handler for this logger instance. 
	*/
  
public class NoParentLogger {
     
    public static void main(String[] args) {
         
 
  Logger logger = Logger.getLogger(NoParentLogger.class.getName());
  
 
  // Do not send any log messages the the logger parent handlers.
 
  logger.setUseParentHandlers(false);
  
 
  // Specify a ConsoleHanlder for this logger instance.
 
  logger.addHandler(new ConsoleHandler());
 
  logger.info("Logging an INFO message.");
    }
}