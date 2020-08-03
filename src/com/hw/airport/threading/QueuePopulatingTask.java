package com.hw.airport.threading;

import com.hw.airport.config.AppContainer;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking;
import com.hw.airport.observer.Observer;
import com.hw.airport.service.QueueSvc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.TimerTask;

public class QueuePopulatingTask extends TimerTask implements Observer{
	Logger LOG = LogManager.getLogger(QueuePopulatingTask.class);

	QueueSvc queueSvc = AppContainer.getQueueSvc();
	@Override
	public void run() {
		try {
			Booking passenger = queueSvc.addPassengerToQueue();
			int queueSize = queueSvc.getCountOfPassangerInQueue();
			String fullName = null;
			if (null != passenger) {
				fullName  = passenger.getFullName();
				LOG.debug("passenger {} was added to the queue. Queue size is {} ", fullName, queueSize );
			}
			
		} catch (HWAirportException e) {
			e.printStackTrace();
		}
	}
	
	//observe when the simulator time has ended to stop the task of adding passengers the queue
	@Override
	public void onNotify(Object args) {
		
		
		
	}
}
