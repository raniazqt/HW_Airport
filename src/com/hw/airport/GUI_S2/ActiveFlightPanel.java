package com.hw.airport.GUI_S2;

import com.hw.airport.config.ActiveFlightPanelSettings;
import com.hw.airport.model.ActiveFlight;
import com.hw.airport.model.Desk;
import com.hw.airport.service.GUISvc;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ActiveFlightPanel extends JPanel implements GUIElement<JPanel>
{
    private final ActiveFlightPanelSettings guiSettings;
    private List<FlightPanel> flightPanels;
    private int currentFlightCount;

    public ActiveFlightPanel(ActiveFlightPanelSettings guiSettings)
    {
        this.guiSettings = guiSettings;
        this.setLayout(guiSettings.Layout);
        this.setFont(guiSettings.LabelFont);
        this.setBackground(guiSettings.BackGroundColor);
        this.setBorder(guiSettings.BorderType);
    }

    @Override
    public JPanel getSelf()
    {
        return this;
    }

    @Override
    public void draw()
    {
        for(int i = 0; i < currentFlightCount; i++)
        {
            flightPanels.get(i).draw();
            add(flightPanels.get(i));
        }
    }

    @Override
    public void update(GUISvc guiDataSvc)
    {
        List<ActiveFlight> openFlightList = guiDataSvc.getActiveFlightsInformation();
        currentFlightCount = openFlightList.size();
        flightPanels = new ArrayList<>(currentFlightCount);

        for(int i = 0; i <currentFlightCount; i++)
        {
            FlightPanel flightPanel = new FlightPanel(guiSettings);
            flightPanel.update(openFlightList.get(i));
            flightPanels.add(flightPanel);
        }
    }
}
