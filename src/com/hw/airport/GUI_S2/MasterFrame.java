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
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;

        add(settingsToolBar, c);

        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(simToolBar, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        add(passengerPanel, c);
        //add(checkInDeskPanel);
        //add(flightsPanel);
    }

}
