import java.util.logging


/* GLOBAL LOGGING PROPERTIES
# Default file output is in user's home directory.
java.util.logging.FileHandler.pattern = %h/java%u.log
java.util.logging.FileHandler.limit = 50000
java.util.logging.FileHandler.count = 1
java.util.logging.FileHandler.formatter = java.util.logging.XmlFormatter
*/

// Exceptions Handling Logger 

Logger logger = Logger.getLogger(BookingLastNameMismatchException.class.getName());
Logger logger = Logger.getLogger(HWAirportException.class.getName());
Logger logger = Logger.getLogger(MissingBookingException.class.getName());
Logger logger = Logger.getLogger(MissingFlightException.class.getName());
Logger logger = Logger.getLogger(NegativeBaggageVolumeException.class.getName());
Logger logger = Logger.getLogger(NegativeBaggageWeightException.class.getName());
Logger logger = Logger.getLogger(NullBookingException.class.getName());

// Model Logger
Logger logger = Logger.getLogger(AppData.class.getName());
Logger logger = Logger.getLogger(Booking.class.getName());
Logger logger = Logger.getLogger(BookingCharge.class.getName());
Logger logger = Logger.getLogger(Flight.class.getName());
Logger logger = Logger.getLogger(FlightExtrasAndCharges.class.getName());

// Logger Test
public class AwesomeTest {
    @Rule
    public LoggerContextRule init = new LoggerContextRule("MyTestConfig.xml");
 
    @Test
    public void testSomeAwesomeFeature() {
        final LoggerContext ctx = init.getLoggerContext();
        final Logger logger = init.getLogger("org.apache.logging.log4j.my.awesome.test.logger");
        final Configuration cfg = init.getConfiguration();
        final ListAppender app = init.getListAppender("List");
        logger.warn("Test of the logger class");
        final List<LogEvent> events = app.getEvents();
        // etc.
    }
}