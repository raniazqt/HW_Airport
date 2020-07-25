package com.hw.airport.config;

public class GUISettings {

    public FrameSettings FrameSettings;
    public GUIComponentSettings GUIComponentSettings;
    public CheckInDeskPanelSettings CheckInDeskPanelSettings;
    public PassengerPanelSettings PassengerPanelSettings;
    public ActiveFlightPanelSettings ActiveFlightPanelSettings;

    public GUISettings(FrameSettings masterFrameSettings, GUIComponentSettings simToolBarSettings,
                       CheckInDeskPanelSettings checkInDeskPanelSettings, PassengerPanelSettings passengerPanelSettings,
                       ActiveFlightPanelSettings activeFlightPanelSettings) {

        this.FrameSettings = masterFrameSettings;
        this.GUIComponentSettings = simToolBarSettings;
        this.CheckInDeskPanelSettings = checkInDeskPanelSettings;
        this.PassengerPanelSettings = passengerPanelSettings;
        this.ActiveFlightPanelSettings = activeFlightPanelSettings;
    }
}
