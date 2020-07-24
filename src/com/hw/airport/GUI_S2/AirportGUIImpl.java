package com.hw.airport.GUI_S2;
import com.hw.airport.config.*;
import com.hw.airport.service.GUISvc;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class AirportGUIImpl implements AirportGUI
{
	private GUISvc guiSvc;
	private GUIElement<JFrame> masterFrame;

	public AirportGUIImpl()
	{
		guiSvc = AppContainer.getGuiSvc();
		masterFrame = new MasterFrame(getGuiSettings());

		masterFrame.update(null);
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

	public GUISettings getGuiSettings()
	{
		MasterFrameSettings masterFrameSettings = new MasterFrameSettings(800,600,
				WindowConstants.EXIT_ON_CLOSE, "Airport Status Screen");

		SimToolBarSettings simToolBarSettings = new SimToolBarSettings(new FlowLayout(), new Color(0x090909), new Color(0x31E92D),
				new Font("Dialog", Font.ITALIC, 12), BorderFactory.createBevelBorder(2));

		CheckInDeskPanelSettings checkInDeskPanelSettings = new CheckInDeskPanelSettings(new FlowLayout(), new Color(0x090909), new Color(0xE9BA00),
				new Font("Dialog", Font.PLAIN, 12), BorderFactory.createBevelBorder(3), new Dimension(180, 100));

		ActiveFlightPanelSettings activeFlightPanelSettings = new ActiveFlightPanelSettings(new FlowLayout(), new Color(0x090909), new Color(0x11DBE9),
				new Font("Dialog", Font.BOLD, 12), BorderFactory.createBevelBorder(1), new Dimension(300, 200));

		PassengerPanelSettings passengerPanelSettings = new PassengerPanelSettings(new FlowLayout(), new Color(0x090909), new Color(0xE92ECE),
				new Font("Dialog", Font.ITALIC, 12), BorderFactory.createBevelBorder(1));


		return new GUISettings(masterFrameSettings, simToolBarSettings,
				checkInDeskPanelSettings, passengerPanelSettings, activeFlightPanelSettings);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.masterFrame.refreshGUI(arg);
	}
}

