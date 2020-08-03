package com.hw.airport.threading;

import com.hw.airport.model.SimulationTimer;

import java.util.TimerTask;

public class TimerUpdateTask extends TimerTask
{
    private SimulationTimer timerObject;
    public TimerUpdateTask(SimulationTimer timerObj)
    {
        timerObject = timerObj;
    }
    @Override
    public void run() {
       try {
           if(timerObject.isRunning())
           {
               timerObject.tick();
           }
           else {
               cancel();
               System.out.println("CANCELING TIMER TASK....");
           }
       }
       catch (Exception e) {
           e.printStackTrace();
       }
    }
}
