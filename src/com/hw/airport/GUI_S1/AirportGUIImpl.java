package com.hw.airport.GUI_S1;
import com.hw.airport.GUI_S2.MasterFrame;
import com.hw.airport.config.*;

import javax.swing.*;

public class AirportGUIImpl implements AirportGUI {

	private GUISettings guiSettings;

	@Override
	public void displayAirportStatusScreen() {

		new MasterFrame(getGuiSettings()).setVisible(true);
	}

	private GUISettings getGuiSettings()
	{
		MasterFrameSettings masterFrameSettings = new MasterFrameSettings(800,600,
				WindowConstants.EXIT_ON_CLOSE, "Airport Status Screen");

		SimToolBarSettings simToolBarSettings = new SimToolBarSettings();
		CheckInDeskPanelSettings checkInDeskPanelSettings = new CheckInDeskPanelSettings();
		PassengerPanelSettings passengerPanelSettings = new PassengerPanelSettings();
		ActiveFlightPanelSettings activeFlightPanelSettings = new ActiveFlightPanelSettings();

		return new GUISettings(masterFrameSettings, simToolBarSettings,
				checkInDeskPanelSettings, passengerPanelSettings, activeFlightPanelSettings);
	}

}
