package com.hw.airport.GUI_S2;

import com.hw.airport.config.*;

import javax.swing.*;

public class MasterFrame extends JFrame {

    public MasterFrame() {
        GUISettings settings = AppConfig.getInstance().getGuiSettings();
        InitPanels(settings);
        AddPanels();
    }

    private void InitPanels(GUISettings settings) {
        InitMainFrame(settings.getMasterFrameSettings());
        InitPassengerPanel(settings.getPsngrPnlSettings());
        InitCheckInDeskPanel(settings.getCheckInDskPnlSettings());
        InitActiveFlightsPanel(settings.getActivFlghtPnlSettings());
        InitSimulationToolBar(settings.getSimToolBrSettings());
    }

    private void InitMainFrame(MasterFrameSettings frameSettings) {
        setTitle (frameSettings.getMainScreenTitle());
        setSize (frameSettings.getMainScreenWidth(), frameSettings.getMainScreenHeight());
        setDefaultCloseOperation (frameSettings.getExitOperation());
    }

    private void InitPassengerPanel(PassengerPanelSettings panelSettings) {

    }

    private void InitCheckInDeskPanel(CheckInDeskPanelSettings panelSettings) {

    }

    private void InitActiveFlightsPanel(ActiveFlightPanelSettings panelSettings) {

    }

    private void InitSimulationToolBar(SimToolBarSettings toolBarSettings) {

    }

    private void AddPanels() {

    }
}
