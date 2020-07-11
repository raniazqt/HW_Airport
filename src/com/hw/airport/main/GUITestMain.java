package com.hw.airport.main;

import com.hw.airport.GUI_S1.AirportGUIImpl;
import com.hw.airport.exception.HWAirportException;

public class GUITestMain
{
    public static void main(String[] args) throws HWAirportException
    {
        AirportGUIImpl gui = new AirportGUIImpl();
        gui.displayAirportStatusScreen();
    }
}
