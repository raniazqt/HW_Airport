package com.hw.airport.GUI_S2;

import com.hw.airport.config.ActiveFlightPanelSettings;
import com.hw.airport.model.ActiveFlight;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ActiveFlightPanel extends JPanel implements GUIElement
{
	private static final long serialVersionUID = 1L;
	private final ActiveFlightPanelSettings guiSettings;
    private List<FlightPanel> flightPanels;

    public ActiveFlightPanel(ActiveFlightPanelSettings guiSettings)
    {
        this.guiSettings = guiSettings;
    }

    @Override
    public JPanel getSelf()
    {
        return this;
    }

    @Override
    public void draw()
    {
        this.setLayout(guiSettings.Layout);
        this.setFont(guiSettings.LabelFont);
        this.setBackground(guiSettings.BackGroundColor);
        this.setBorder(guiSettings.BorderType);
    }

    private FlightPanel findFlightPanel(ActiveFlight activeFlight) {
        if (null != activeFlight) {
            for (FlightPanel panel : flightPanels) {
                if (null != panel.getActiveFlightCode()) {
                    if (panel.getActiveFlightCode().equals(activeFlight.getFlightCd())) {
                        return panel;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void init(Object targetObj)
    {
        flightPanels = new ArrayList<>();
    }

	@Override
	public void refresh(Object targetObj) {
        if(!(targetObj instanceof ActiveFlight))
            return;

		ActiveFlight activeFlightToUpdate = (ActiveFlight) targetObj;
        FlightPanel panelToUpdate = findFlightPanel(activeFlightToUpdate);
		if(panelToUpdate != null) {
		    panelToUpdate.refresh(activeFlightToUpdate);
        }
		else {
		    FlightPanel flightPanelToAdd = new FlightPanel(guiSettings);
		    flightPanelToAdd.init(activeFlightToUpdate);
		    flightPanelToAdd.draw();
		    flightPanels.add(flightPanelToAdd);
            add(flightPanelToAdd.getSelf());

		}
		
	}
}
