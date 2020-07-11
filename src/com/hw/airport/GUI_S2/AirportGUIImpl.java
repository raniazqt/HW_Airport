package com.hw.airport.GUI_S2;
import com.hw.airport.config.*;
import com.hw.airport.service.GUISvc;

import javax.swing.*;
import java.awt.*;

public class AirportGUIImpl implements AirportGUI {

	private GUISvc guiSvc;
	private GUIElement<JFrame> masterFrame;

	public AirportGUIImpl()
	{
		guiSvc = AppContainer.getGuiSvc();
		masterFrame = new MasterFrame(getGuiSettings());

		masterFrame.draw();
	}

	@Override
	public void display()
	{
		masterFrame.getSelf().setVisible(true);
	}

	public void hide()
	{
		masterFrame.getSelf().setVisible(false);
	}

	private GUISettings getGuiSettings()
	{
		MasterFrameSettings masterFrameSettings = new MasterFrameSettings(800,600,
				WindowConstants.EXIT_ON_CLOSE, "Airport Status Screen");

		SimToolBarSettings simToolBarSettings = new SimToolBarSettings(new FlowLayout(), new Color(0x090909), new Color(0x31E92D),
				new Font("Dialog", Font.ITALIC, 12), BorderFactory.createBevelBorder(2));

		CheckInDeskPanelSettings checkInDeskPanelSettings = new CheckInDeskPanelSettings();
		PassengerPanelSettings passengerPanelSettings = new PassengerPanelSettings();
		ActiveFlightPanelSettings activeFlightPanelSettings = new ActiveFlightPanelSettings();

		return new GUISettings(masterFrameSettings, simToolBarSettings,
				checkInDeskPanelSettings, passengerPanelSettings, activeFlightPanelSettings);
	}
}
