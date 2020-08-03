package com.hw.airport.config;

public class AirportGuiSettings {
    public AirportMonitorFrameSettings AirPortMonitorFrameSettings;
    public SimulationToolBarSettings SimulationToolBarSettings;
    public CheckInDeskPanelSettings CheckInDeskPanelSettings;
    public PassengerPanelSettings PassengerPanelSettings;
    public ActiveFlightPanelSettings ActiveFlightPanelSettings;

    public AirportGuiSettings(AirportMonitorFrameSettings airportMonitorFrameSettings, SimulationToolBarSettings simToolBarSettings,
                              CheckInDeskPanelSettings checkInDeskPanelSettings, PassengerPanelSettings passengerPanelSettings,
                              ActiveFlightPanelSettings activeFlightPanelSettings) {
        this.AirPortMonitorFrameSettings = airportMonitorFrameSettings;
        this.SimulationToolBarSettings = simToolBarSettings;
        this.CheckInDeskPanelSettings = checkInDeskPanelSettings;
        this.PassengerPanelSettings = passengerPanelSettings;
        this.ActiveFlightPanelSettings = activeFlightPanelSettings;
    }
}
