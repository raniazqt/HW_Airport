package com.hw.airport.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hw.airport.observer.SynchronizedObservable;

public class SimulationTimer extends SynchronizedObservable{
	
    private double startTime;
    private double currentTime;
    private double endTime;
    private double timeRate;
    private boolean isRunning;

    Logger LOG = LogManager.getLogger(SimulationTimer.class);
    public SimulationTimer() {}

    public void start(double simulationDuration, double simRate)
    {
        startTime = 0.0;
        currentTime = 0.0;
        endTime = startTime + simulationDuration;
        timeRate = simRate;
        isRunning = true;

        LOG.debug("Simulation timer start called!");
    }

    public void tick()
    {
        LOG.debug("Simulation timer started ticking!");
            currentTime += timeRate;
            LOG.debug("Current Simulation time: {}", currentTime);
            if(currentTime >= endTime)
            {
            	setChanged();
                notifyObservers("TIME ELAPSED");
                LOG.debug("Simulation time has ended. Current time {} , End time {} " , currentTime , endTime);                
            }
        }

    public void pause(boolean value)
    {
        isRunning = value;
    }

    public void stop()
    {
        isRunning = false;
        currentTime = 0;
        endTime = 0;
        startTime = 0;
        timeRate = 0;
    }

    public double getCurrentTime()
    {
        return currentTime;
    }

    public double getStartTime()
    {
        return startTime;
    }

    public double getEndTime()
    {
        return endTime;
    }

    public boolean isRunning()
    {
        return isRunning;
    }

    public double getTimeRate()
    {
        return timeRate;
    }
}
