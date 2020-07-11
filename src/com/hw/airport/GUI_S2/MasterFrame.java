package com.hw.airport.GUI_S2;

import com.hw.airport.config.GUISettings;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MasterFrame extends JFrame implements GUIElement<JFrame>
{
    private GUISettings guiSettings;
    private GUIElement<JPanel> flightsPanel;
    private GUIElement<JPanel> checkInDeskPanel;
    private GUIElement<JPanel> passengerPanel;
    private GUIElement<JToolBar> simToolBar;

    public MasterFrame(GUISettings guiSettings)
    {
        this.guiSettings = guiSettings;

        initMasterFrame();
        initSubPanels();
        addSubPanels();
    }

    private void initMasterFrame()
    {
        setTitle (guiSettings.MasterFrameSettings.getMainScreenTitle());
        setSize (guiSettings.MasterFrameSettings.getMainScreenWidth(),
                guiSettings.MasterFrameSettings.getMainScreenHeight());
        setDefaultCloseOperation (EXIT_ON_CLOSE);
    }

    private void initSubPanels()
    {
        simToolBar = new SimToolBar(guiSettings.SimToolBarSettings);
        flightsPanel = new ActiveFlightPanel(guiSettings.ActiveFlightPanelSettings);
        checkInDeskPanel = new CheckInDeskPanel(guiSettings.CheckInDeskPanelSettings);
        passengerPanel = new PassengerPanel(guiSettings.PassengerPanelSettings);
    }

    private void addSubPanels()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        add(simToolBar.getSelf(), c);
    }

    @Override
    public JFrame getSelf()
    {
        return this;
    }

    @Override
    public void draw()
    {
        simToolBar.draw();
        checkInDeskPanel.draw();
        passengerPanel.draw();
        flightsPanel.draw();
    }

    @Override
    public void update()
    {
        simToolBar.update();
        checkInDeskPanel.update();
        passengerPanel.update();
        flightsPanel.update();
    }
}
