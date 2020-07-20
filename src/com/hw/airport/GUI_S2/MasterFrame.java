package com.hw.airport.GUI_S2;

import com.hw.airport.config.GUISettings;
import com.hw.airport.service.GUISvc;

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
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
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
        add(simToolBar.getSelf());
        add(checkInDeskPanel.getSelf());
        add(flightsPanel.getSelf());
        add(passengerPanel.getSelf());
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
        flightsPanel.draw();
        passengerPanel.draw();
    }

    @Override
    public void update(GUISvc guiDataSvc)
    {
        simToolBar.update(guiDataSvc);
        checkInDeskPanel.update(guiDataSvc);
        flightsPanel.update(guiDataSvc);
        passengerPanel.update(guiDataSvc);
    }
}
