package com.hw.airport.GUI_S2;

import com.hw.airport.config.GUISettings;

import javax.swing.*;

public class AirportMonitorFrame extends JFrame implements GUIElement
{
	private GUISettings guiSettings;
	private GUIElement flightsPanel;
	private GUIElement checkInDeskPanel;
	private GUIElement passengerPanel;
	private GUIElement simToolBar;

	public AirportMonitorFrame(GUISettings guiSettings)
	{
		this.guiSettings = guiSettings;

		initMasterFrame();
		initSubPanels();
		addSubPanels();
	}

	private void initMasterFrame()
	{
		setTitle (guiSettings.FrameSettings.getMainScreenTitle());
		setSize (guiSettings.FrameSettings.getMainScreenWidth(),
				guiSettings.FrameSettings.getMainScreenHeight());
		setDefaultCloseOperation (EXIT_ON_CLOSE);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
	}

	private void initSubPanels()
	{
		simToolBar = new SimToolBar(guiSettings.GUIComponentSettings);
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
	public void init(Object args)
	{
		simToolBar.init(args);
		checkInDeskPanel.init(args);
		flightsPanel.init(args);
		passengerPanel.init(args);
	}

	@Override
	public void refresh(Object args)
	{
		checkInDeskPanel.refresh(args);
		flightsPanel.refresh(args);
		passengerPanel.refresh(args);
	}
}
