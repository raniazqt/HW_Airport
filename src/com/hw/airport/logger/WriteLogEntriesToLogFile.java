package com.hw.airport.logger;

import java.util.logging.FileHandler;
import java.util.logging.Logger;

	/* Write Log entries to a log file:
	
	1) Create a new FileHandler to write to a specific file.
	2) Create a new Logger instance with getLogger(String name) API method of Logger.
	3) Add the handler to the Logger, with addHandler(Handler handler) API method of Logger.
	4) Invoke log methods of Logger to log messages in different levels, such as warning(String msg), 
	info(String msg) and config(String msg) API methods. 
	5) All logs will be written to the specified file by the FileHandler.
	*/
 
public class WriteLogEntriesToLogFile {
     
    public static void main(String[] args) throws Exception {
         
        boolean append = true;
        FileHandler handler = new FileHandler("airportDefault.log", append);
 
        Logger logger = Logger.getLogger("com.hw.airport.logger");
        logger.addHandler(handler);
         
        logger.severe("severe message");
 
  logger.warning("warning message");
 
  logger.info("info message");
 
  logger.config("config message");
 
  logger.fine("fine message");
 
  logger.finer("finer message");
 
  logger.finest("finest message");
         
    }
 
}