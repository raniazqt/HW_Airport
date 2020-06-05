package com.hw.airport.logger;

	import java.io.IOException;
	import java.util.logging.Level;
	
	/* 
	 * Logger.getLogger(String name): This method is used to create or find a logger by the name passed as a parameter.

		void info(String msg): 
		1) 	This instance method is used to log an INFO message, if the logger is currently enabled for the INFO message 
		else the logged message is gets ignored.
		
		2) 	void warning(String msg): This instance method is used to log a WARNING message, 
		if the logger is currently enabled for the WARNING message else the logged message is gets ignored.
		
		3)	void config(String msg): This instance method is used to log a CONFIG message, 
		if the logger is currently enabled for the CONFIG message else the logged message is gets ignored.
		
		4)	void log(Level level, String msg, Object param1): This method is used to log a message with a given level, 
		and with an Object as a parameter. You can use this method when you want to store an object in the log as 
		done in the above example where we have logged an exception object at SEVERE level.
		
		INFO level is the default level set in the Logger. Any message logged with the level lower 
		than the INFO gets ignored. The message logged at the WARNING level gets ignored and does not get 
		published in the console.
	 * 
	 */

	public class Logger {

		private static final Logger LOGGER = Logger.getLogger(Logger.class.getName());
		public static void main(String args[]) throws SecurityException, IOException {

			LOGGER.info("Logger Name: "+LOGGER.getName());
			
			LOGGER.warning("Can cause ArrayIndexOutOfBoundsException");
			
			//An array of size 3
			int []a = {1,2,3};
			int index = 4;
			LOGGER.config("index is set to "+index);
			
			try{
				System.out.println(a[index]);
			}catch(ArrayIndexOutOfBoundsException ex){
				LOGGER.log(Level.SEVERE, "Exception occur", ex);
				/* Finally?
				 * close ?
				 */
			}

		}
		private void log(Level severe, String string, ArrayIndexOutOfBoundsException ex) {
			
		}
		private void config(String string) {
			
		}
		private void warning(String string) {
			
		}
		private void info(String string) {
			
		}
		private String getName() {
			return null;
		}
		private static Logger getLogger(String name) {
			return null;
		}

	}

	