package com.hw.airport.threading;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.model.SimulationTimer;
import com.hw.airport.observer.Observer;
import com.hw.airport.observer.SynchronizedObservable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerManager extends SynchronizedObservable implements Observer{

	Logger LOG = LogManager.getLogger(TimerManager.class);
	
	TimerTask queuePopulatingTask;
	SimulationTimer appTimer;
	TimerUpdateTask simTimerTask;
	ScheduledExecutorService executor;

	public TimerManager() {
		LOG.debug("Initialize timer to manage the queue populating rate and simualtor running rate");
		//create a timer task to populate queue
		this.queuePopulatingTask = new QueuePopulatingTask();
		//create simulator timer task
		this.appTimer = new SimulationTimer();
		//create simulator timer task
		simTimerTask = new TimerUpdateTask(appTimer);
		executor = Executors.newScheduledThreadPool(2);
	}

	public SimulationTimer setupTimer() {
		double timerRate = 1;
		long queuePopulatingRate = AirportSimulator.getQueuePopulatingRate();
		int simRunningRate = AirportSimulator.getSimRunningRate();

		//Configure simulator timer task
		appTimer.start(simRunningRate, timerRate);

		//schedule timer tasks to run as daemon thread
		executor.scheduleAtFixedRate(queuePopulatingTask, 0, queuePopulatingRate, TimeUnit.MILLISECONDS);
		executor.scheduleWithFixedDelay(simTimerTask, 0,queuePopulatingRate, TimeUnit.MILLISECONDS);
		
		LOG.debug("Simulator Timer has started");
		LOG.debug("Populating queue task has started");

		return appTimer;	
	}

	@Override
	public void onNotify(Object args) {
		//the notification is coming from the simulator timer to notify that time has elapsed. End simulation!
		if (args instanceof String && "DESKS_CLOSED".equalsIgnoreCase((String)args)) {
			System.out.println("SIMULATION DONE..");
			LOG.debug("Simulator time has ended. End simulation");
			appTimer.stop(); 
			queuePopulatingTask.cancel(); 
			simTimerTask.cancel();
			executor.shutdown();
			setChanged();
			notifyObservers("SIMULATION_FINISHED");
		}
	}
}
