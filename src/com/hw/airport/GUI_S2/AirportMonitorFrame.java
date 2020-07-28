package com.hw.airport.GUI_S2;

import com.hw.airport.config.GUISettings;
import com.hw.airport.model.ActiveFlight;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Desk;

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
		setDefaultCloseOperation (EXIT_ON_CLOSE);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
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
		add(flightsPanel.getSelf());
		add(checkInDeskPanel.getSelf());
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
		flightsPanel.draw();
		checkInDeskPanel.draw();
		passengerPanel.draw();
	}

	@Override
	public void init(Object args)
	{
		simToolBar.init(args);
		flightsPanel.init(args);
		checkInDeskPanel.init(args);
		passengerPanel.init(args);
	}

	@Override
	public void refresh(Object args)
	{
		refreshFrame();
		refreshSubPanels(args);
	}

	private void refreshSubPanels(Object args) {
		if (args instanceof Desk) {
			checkInDeskPanel.refresh(args);
		}
		else if (args instanceof Booking) {
			passengerPanel.refresh(null);
		}else if (args instanceof ActiveFlight) {
			flightsPanel.refresh(args);
		}
	}

	private void refreshFrame() {
		revalidate();
		repaint();
	}
}
