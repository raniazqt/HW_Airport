package com.hw.airport.logger;

	package com.hw.airport.logger;
	import java.util.logging.Logger;
	import java.util.logging.FileHandler;
	import java.io.IOException;
	  
	/* Setting size threshold of a log file does the following:

		1) Create a Logger instance for a class, with the getLogger(String name) API method.
		2) Create a FileHandler with a specific file size. It can be configured to write to one or more files, 
		to a specific size. When the size is reached another file will be created. The handler can also be set to 
		append the files.
		3) Add the Handler to receive the logging messages of the logger, with the addHandler(Handler handler) API method.
		4) Use the info(String msg), warning(String msg), severe(String msg) API methods to log messages.
	*/
	
	public class LogFileThreshold {
	     
	    // The log file size is set to 1KB.
	    public static final int FILE_SIZE = 1024;
	  
	    public static void main(String[] args) {
	 
	  Logger logger = Logger.getLogger(LogFileThreshold.class.getName());
	  
	 
	  try {
	 
	 
	// Create a FileHandler with 1KB file size and a single log file.
	 
	 
	FileHandler handler = new FileHandler("airportHandler.log", FILE_SIZE, 1, true);
	 
	 
	logger.addHandler(handler);
	 
	  } catch (IOException e) {
	 
	 
	logger.warning("Failed to initialize logger handler.");
	 
	  }
	  
	 
	  logger.info("Test info");
	 
	  logger.warning("Test warning");
	 
	  logger.severe("Test severe");
	    }
	}