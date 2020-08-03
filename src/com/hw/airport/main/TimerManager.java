package com.hw.airport.main;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.model.SimulationTimer;
import com.hw.airport.observer.Observer;
import com.hw.airport.threading.QueuePopulatingTask;
import com.hw.airport.threading.TimerUpdateTask;

public class TimerManager implements Observer{
	TimerTask queuePopulatingTask;
	SimulationTimer appTimer;
	TimerUpdateTask simTimerTask;
	Timer timer;

	public TimerManager() {
		//create a timer task to populate queue
		this.queuePopulatingTask = new QueuePopulatingTask();
		//create simulator timer task
		this.appTimer = new SimulationTimer();
		//create simulator timer task
		simTimerTask = new TimerUpdateTask(appTimer);
		timer = new Timer();
	}

	public SimulationTimer setupTimer() {
		long rate = (long) AirportSimulator.getQueuePopulatingRate();
		long appRate = rate / 6;
		double timerRate = 1;

		//Configure simulator timer task
		appTimer.start(180000, timerRate);

		//Create a timer to run the timer tasks
		Timer timer = new Timer();

		final ScheduledExecutorService executor = Executors
				.newScheduledThreadPool(2);
		//schedule timer tasks to run as daemon thread
		executor.scheduleAtFixedRate(queuePopulatingTask, 0, appRate,TimeUnit.MILLISECONDS);

		executor.scheduleWithFixedDelay(simTimerTask, 0,10,TimeUnit.MINUTES);


		return appTimer;	
	}

	@Override
	public void onNotify(Object args) {
		//the notification is coming from the simulator timer to notify that time has elapsed. End simulation!
		if (args instanceof String && "TIME ELAPSED".equalsIgnoreCase((String)args)) {
			queuePopulatingTask.cancel();			
			simTimerTask.cancel();
			appTimer.stop();
			timer.cancel();
		}
	}
}
