package com.hw.airport.logger;
	 
	import java.util.logging.FileHandler;
	import java.util.logging.Level;
	import java.util.logging.Logger;
	
	/* The method creates a FileHandler to write logs to a specific file.
	It creates a new Logger instance and adds the handler to the logger, with addHandler(Handler handler) API method.
	It also adds a logging Level to the logger with setLevel(Level newLevel) API method.
	*/
	 
	public class LogMethodCall {
	     
	    public static void main(String[] args) throws Exception {
	        LogMethodCall call = new LogMethodCall();
	        call.method("arg1", new String("arg2"));
	    }
	     
	    public boolean method(String arg1, Object arg2) throws Exception {
	 
	   
	        boolean append = false;
	        FileHandler handler = new FileHandler("default.log", append);
	 
	        Logger logger = Logger.getLogger("com.hw.airport.logger");
	        logger.setLevel(Level.FINEST);
	        logger.addHandler(handler);
	         
	 
	  logger.entering(this.getClass().getName(), "method", new Object[]{arg1, arg2});
	 
	 
	  boolean result = true;
	 
	  logger.exiting(this.getClass().getName(), "method", new Boolean(result));
	 
	   
	 
	  return result;
	 
	   
	     }
	 
	}
