package com.hw.airport.GUI_S2;
import com.hw.airport.config.*;
import com.hw.airport.service.GUISvc;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class AirportGUIImpl implements AirportGUI
{
	private GUISvc guiSvc;
	private GUIElement masterFrame;
	private UserConfigFrame configFrame;

	public AirportGUIImpl()
	{
		guiSvc = AppContainer.getGuiSvc();

		FrameSettings userConfigFrameSettings = new FrameSettings(350,260,
				WindowConstants.EXIT_ON_CLOSE, "Simulation Configuration Screen");
		GUIComponentSettings userConfigPanelSettings = new GUIComponentSettings(new GridLayout(0,2), new Color(0xFFFFFFFF, true),
				new Color(0x090909), new Font("Dialog", Font.BOLD, 12), BorderFactory.createBevelBorder(1));

		
		masterFrame = new AirportMonitorFrame(getGuiSettings());

		masterFrame.init(null);
		masterFrame.draw();
	}

	@Override
	public void displayConfigScreen(){
		
		FrameSettings userConfigFrameSettings = new FrameSettings(350,260,
				WindowConstants.EXIT_ON_CLOSE, "Simulation Configuration Screen");
		GUIComponentSettings userConfigPanelSettings = new GUIComponentSettings(new GridLayout(0,2), new Color(0xFFFFFFFF, true),
				new Color(0x090909), new Font("Dialog", Font.BOLD, 12), BorderFactory.createBevelBorder(1));

		configFrame = new UserConfigFrame(userConfigFrameSettings, userConfigPanelSettings);
		configFrame.init();
		configFrame.getSelf().setVisible(true);
	}

	@Override
	public void displayAirportMonitorScreen() {
		configFrame.setVisible(false);
		masterFrame.init(null);
		masterFrame.draw();
		masterFrame.getSelf().setVisible(true);
	}

	public GUISettings getGuiSettings()
	{
		FrameSettings masterFrameSettings = new FrameSettings(1440,1280,
				WindowConstants.EXIT_ON_CLOSE, "Airport Status Screen");

		GUIComponentSettings simToolBarSettings = new GUIComponentSettings(new FlowLayout(), new Color(0x090909), new Color(0x31E92D),
				new Font("Dialog", Font.ITALIC, 12), BorderFactory.createBevelBorder(2));

		CheckInDeskPanelSettings checkInDeskPanelSettings = new CheckInDeskPanelSettings(new FlowLayout(), new Color(0x090909), new Color(0xE9BA00),
				new Font("Dialog", Font.PLAIN, 12), BorderFactory.createBevelBorder(3));

		ActiveFlightPanelSettings activeFlightPanelSettings = new ActiveFlightPanelSettings(new FlowLayout(), new Color(0x090909), new Color(0x11DBE9),
				new Font("Dialog", Font.BOLD, 12), BorderFactory.createBevelBorder(1));

		PassengerPanelSettings passengerPanelSettings = new PassengerPanelSettings(new FlowLayout(), new Color(0x090909), new Color(0xE92ECE),
				new Font("Dialog", Font.ITALIC, 12), BorderFactory.createBevelBorder(1));


		return new GUISettings(masterFrameSettings, simToolBarSettings,
				checkInDeskPanelSettings, passengerPanelSettings, activeFlightPanelSettings);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.masterFrame.refresh(arg);
	}
}

