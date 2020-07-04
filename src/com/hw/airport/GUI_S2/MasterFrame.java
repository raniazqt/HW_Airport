package com.hw.airport.GUI_S2;

import com.hw.airport.config.AppConfig;
import com.hw.airport.config.GUISettings;

import javax.swing.*;
import java.awt.*;

public class MasterFrame extends JFrame {

    private GUISettings guiSettings;
    private ActiveFlightPanel flightsPanel;
    private CheckInDeskPanel checkInDeskPanel;
    private PassengerPanel passengerPanel;
    private SimToolBar simToolBar;
    private SettingsToolBar settingsToolBar;

    public MasterFrame() {
        guiSettings = AppConfig.getInstance().getGuiSettings();
        initMasterFrame();
        initSubPanels();
        addSubPanels();
    }

    private void initMasterFrame() {
        setTitle (guiSettings.getMainScreenTitle());
        setSize (guiSettings.getMainScreenWidth(), guiSettings.getMainScreenHeight());
        setDefaultCloseOperation (EXIT_ON_CLOSE);
    }

    private void initSubPanels() {
        settingsToolBar = new SettingsToolBar(guiSettings);
        simToolBar = new SimToolBar(guiSettings);
        flightsPanel = new ActiveFlightPanel(guiSettings);
        checkInDeskPanel = new CheckInDeskPanel(guiSettings);
        passengerPanel = new PassengerPanel(guiSettings);
    }

    private void addSubPanels() {
        add(settingsToolBar, BorderLayout.NORTH);
        add(simToolBar, BorderLayout.NORTH);
        //add(passengerPanel);
        //add(checkInDeskPanel);
        //add(flightsPanel);
    }

}
