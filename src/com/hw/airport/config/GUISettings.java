package com.hw.airport.config;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GUISettings {

    public MasterFrameSettings MasterFrameSettings;
    public SimToolBarSettings SimToolBarSettings;
    public CheckInDeskPanelSettings CheckInDeskPanelSettings;
    public PassengerPanelSettings PassengerPanelSettings;
    public ActiveFlightPanelSettings ActiveFlightPanelSettings;

    public GUISettings(MasterFrameSettings masterFrameSettings, SimToolBarSettings simToolBarSettings,
                       CheckInDeskPanelSettings checkInDeskPanelSettings, PassengerPanelSettings passengerPanelSettings,
                       ActiveFlightPanelSettings activeFlightPanelSettings) {

        this.MasterFrameSettings = masterFrameSettings;
        this.SimToolBarSettings = simToolBarSettings;
        this.CheckInDeskPanelSettings = checkInDeskPanelSettings;
        this.PassengerPanelSettings = passengerPanelSettings;
        this.ActiveFlightPanelSettings = activeFlightPanelSettings;
    }
}
