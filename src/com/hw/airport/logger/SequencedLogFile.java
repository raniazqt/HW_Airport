package com.hw.airport.logger;
	 
	import java.util.logging.Logger;
	import java.util.logging.FileHandler;
	import java.util.logging.SimpleFormatter;
	import java.io.IOException;
	  
	/* Create a new instance of a Logger.
	1)  Create an instance of FileHandler with a specific number of logging files sequences, 
	a specific size for each file and append set to true. In the example 5 files will be created, 
	with size of each one set to 1024 bytes, with a specific pattern for file name and append set to true.
	2) 	Set a Formatter to format LogRecords for this Handler, with the
	setFormatter(Formatter newFormatter) API method of the Handler.
	3) 	Add the Handler to the Logger, with addHandler(Handler handler) API method of the Logger.
	4)	Configure the logger so as no to send its output to it’s parent Logger, 
	with setUseParentHandlers(boolean useParentHandlers), 
	and parameters set to false.
	5)	Log messages, using the API methods of Logger, such as info(String msg), 
	warning(String msg). The logs will be forwarded to the File Handler, that will write the log messages to the files.
	 */
	
	
	public class SequencedLogFile {
	     
	    public static final int FILE_SIZE = 1024;
	  
	    public static void main(String[] args) {
	 
	  Logger logger = Logger.getLogger(SequencedLogFile.class.getName());
	  
	 
	  try {
	 
	 
	// Create an instance of FileHandler with 5 logging files sequences.
	 
	 
	FileHandler handler = new FileHandler("airportLog.log", FILE_SIZE, 5, true);
	 
	 
	handler.setFormatter(new SimpleFormatter());
	 
	 
	logger.addHandler(handler);
	 
	 
	logger.setUseParentHandlers(false);
	 
	  } catch (IOException e) {
	 
	 
	logger.warning("Failed to initialize logger handler.");
	 
	  }
	  
	 
	  logger.info("Logging info message.");
	 
	  logger.warning("Logging warn message.");
	    }
	}
