package com.hw.airport.GUI_S2;

import com.hw.airport.config.GUISettings;

import javax.swing.*;
import java.awt.*;

public class MasterFrame extends JFrame {

    private GUISettings guiSettings;
    private ActiveFlightPanel flightsPanel;
    private CheckInDeskPanel checkInDeskPanel;
    private PassengerPanel passengerPanel;
    private SimToolBar simToolBar;

    public MasterFrame(GUISettings guiSettings) {
        this.guiSettings = guiSettings;

        initMasterFrame();
        initSubPanels();
        addSubPanels();
    }

    private void initMasterFrame() {
        setTitle (guiSettings.MasterFrameSettings.getMainScreenTitle());
        setSize (guiSettings.MasterFrameSettings.getMainScreenWidth(), guiSettings.MasterFrameSettings.getMainScreenHeight());
        setDefaultCloseOperation (EXIT_ON_CLOSE);
    }

    private void initSubPanels() {
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
