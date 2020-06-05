package com.hw.airport.logger;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

	/*
	A Handler is one of the components of the logging framework. 
	It is responsible for printing the log message at a target destination. 
	The destination can be a console or a file. 
	The Handler is used to take a log message in the form of a LogRecord object and export it to the target destination.
	A Logger can be associated with one or more handlers that eventually forward the logged message to all the handlers. 
	A Handler is an abstract class in the java.util.logging package which is a base class for all types of handlers in Java. 
	There are 4 types of built-in handlers in Java.
	
	1) 	ConsoleHandler: A ConsoleHandler records all the log messages to System.err. 
	By default, a Logger is associated with this handler.
	2)	FileHandler: A FileHandler is used to record all the log messages to a specific file or to a rotating set of files.
	3)	StreamHandler: A StreamHandler publishes all the log messages to an OutputStream.
	4)	SocketHandler: The SocketHandler publish the LogRecords to a network stream connection.
	5)	MemoryHandler: It is used to keep the LogRecords into a memory buffer. If the buffer gets full, 
	the new LogRecords starts overwriting the old LogRecords.
	*/
 
public class Handler {
 
    private static final Logger LOGGER = Logger.getLogger(Logger.class.getName());
    public static void main(String[] args) {
 
        Handler consoleHandler = null;
        Handler fileHandler  = null;
        try{
            //Creating consoleHandler and fileHandler
            consoleHandler = new ConsoleHandler();
            fileHandler  = new FileHandler("./airportLog.log");
             
            //Assigning handlers to LOGGER object
            LOGGER.addHandler(consoleHandler);
            LOGGER.addHandler(fileHandler);
             
            //Setting levels to handlers and LOGGER
            consoleHandler.setLevel(Level.ALL);
            fileHandler.setLevel(Level.ALL);
            LOGGER.setLevel(Level.ALL);
             
            LOGGER.config("Configuration done.");
             
            //Console handler removed
            LOGGER.removeHandler(consoleHandler);
             
            LOGGER.log(Level.FINE, "Finer logged");
        }catch(IOException exception){
            LOGGER.log(Level.SEVERE, "Error occur in FileHandler.", exception);
        }
         
        LOGGER.finer("Finest example on LOGGER handler completed.");
         
    }
 
}
