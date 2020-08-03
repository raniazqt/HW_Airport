package com.hw.airport.model;

import com.hw.airport.observer.SynchronizedObservable;

public class SimulationTimer extends SynchronizedObservable
{
    private double startTime;
    private double currentTime;
    private double endTime;
    private double timeRate;
    private boolean isRunning;

    public SimulationTimer() {}

    public void start(double simulationDuration, double simRate)
    {
        startTime = 0.0;
        currentTime = 0.0;
        endTime = startTime + simulationDuration;
        timeRate = simRate;
        isRunning = true;

        System.out.println("START CALLED !");
    }

    public void tick()
    {
        System.out.println("TICK CALLED !");
        while(isRunning)
        {
            currentTime += timeRate;
            System.out.println("CURRENT TIME: " + currentTime);
            if(currentTime >= endTime)
            {
                notifyObservers("TIME ELAPSED");
                System.out.println("TIME ELAPSED: " + currentTime + " END TIME: " + endTime);
                stop();
            }
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
