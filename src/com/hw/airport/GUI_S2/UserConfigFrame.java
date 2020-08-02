package com.hw.airport.GUI_S2;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.config.AppContainer;
import com.hw.airport.config.FrameSettings;
import com.hw.airport.config.GUIComponentSettings;
import com.hw.airport.main.ApplicationManager;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserConfigFrame extends JFrame implements ListSelectionListener{
	private GUIComponentSettings configPanelSettings;

	public UserConfigFrame(FrameSettings guiSettings, GUIComponentSettings panelSettings) {
		setTitle(guiSettings.getMainScreenTitle());
		setSize(guiSettings.getMainScreenWidth(), guiSettings.getMainScreenHeight());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		configPanelSettings = panelSettings;
	}

	public JFrame getSelf() {
		return this;
	}

	public void init() {

		setLayout(configPanelSettings.Layout);
		setFont(configPanelSettings.LabelFont);
		setBackground(configPanelSettings.BackGroundColor);
		setForeground(configPanelSettings.LabelColor);

		JLabel simRateLabel = new JLabel("Simulation Rate:", JLabel.CENTER);
		add(simRateLabel);

		JTextField simRateVal = new JTextField();
		simRateVal.setToolTipText("This controls overall sim speed (1-9)");
		add(simRateVal);

		JLabel quePopulationRateLabel = new JLabel("Queue Population Rate:", JLabel.CENTER);
		add(quePopulationRateLabel);

		JTextField quePopulationRateVal = new JTextField();
		quePopulationRateVal.setToolTipText("This controls the queue fill rate (Minimum 3000)");
		add(quePopulationRateVal);

		JLabel maxOpenDeskLabel = new JLabel("Max Open Desks:", JLabel.CENTER);
		add(maxOpenDeskLabel);

		JTextField maxOpenDeskVal = new JTextField();
		maxOpenDeskVal.setToolTipText("This sets the number of open desks (1-9)");
		add(maxOpenDeskVal);

		JLabel passToDeskLabel = new JLabel("Passenger to desk ratio:", JLabel.CENTER);
		add(passToDeskLabel);

		JTextField passengerToDeskVal = new JTextField();
		passengerToDeskVal.setToolTipText("This sets the number of open desks per passenger (???)");
		add(passengerToDeskVal);
		
		JLabel uiThemeLabel = new JLabel("UI Theme:", JLabel.CENTER);
		add(uiThemeLabel);

		String theme[] = { "Dark", "Medium", "Light"};
		
		JList<String> themeListVal = new JList<String>(theme);
		JScrollPane scrollableUIList = new JScrollPane(themeListVal);
		themeListVal.setSelectedIndex(0);
		themeListVal.setToolTipText("Sets UI theme");
		
		add(scrollableUIList);				

		JLabel flightListLabel = new JLabel("List of available flights:", JLabel.CENTER);
		add(flightListLabel);

		List<String> flightList = AppContainer.getBookingSvc().getAllFlightsCodeWithBooking();
		
		String[] stringArray = flightList.toArray(new String[0]);

		String week[] = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
				
		JList<String> flightListVal = new JList<String>(week);
		JScrollPane scrollableList = new JScrollPane(flightListVal);
		flightListVal.setToolTipText("Leave blank for all flights");
		
		add(scrollableList);		

		JButton applySettingsBtn = new JButton("Start");
		JButton applyDefaultBtn = new JButton("Default");

		applySettingsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				String openDeskVal = maxOpenDeskVal.getText();
				String simExRateVal = simRateVal.getText();
				String queuPopval = quePopulationRateVal.getText();
				String passToDeskVal = passengerToDeskVal.getText();

				if (openDeskVal.matches(".*\\d.*") & simExRateVal.matches(".*\\d.*") & passToDeskVal.matches(".*\\d.*")
						& queuPopval.matches(".*\\d.*")) {

					boolean popuInputStat = (Integer.parseInt(queuPopval) > 3000);
					boolean passToDeskStat = (Integer.parseInt(passToDeskVal) > 0);

					if (popuInputStat & passToDeskStat) {
						AirportSimulator.getInstnce().setMaxOpndCheckinDesk(Integer.parseInt(openDeskVal));
						AirportSimulator.getInstnce().setSimExcRate(Integer.parseInt(simExRateVal));
						AirportSimulator.getInstnce().setQueuePopulatingRate(Integer.parseInt(queuPopval));
						AirportSimulator.getInstnce().setPassToDeskRatio(Integer.parseInt(passToDeskVal));
						System.out.println(flightListVal.getSelectedValue());
						System.out.println(themeListVal.getSelectedValue());
						//DO SOMETHING HERE
						AppContainer.getGui().displayAirportMonitorScreen();

						// AppContainer.getGui().displayAirportMonitorScreen();
						ApplicationManager appManager = new ApplicationManager();
						// gui.displayConfigScreen();
						try {
							appManager.start();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			}

		});

		applyDefaultBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AirportSimulator.getInstnce().setMaxOpndCheckinDesk(2);
				AirportSimulator.getInstnce().setSimExcRate(2);
				AirportSimulator.getInstnce().setQueuePopulatingRate(2000);
				System.out.println(flightListVal.getSelectedValue());
				System.out.println(themeListVal.getSelectedValue());

				// AppContainer.getGui().displayAirportMonitorScreen();
				ApplicationManager appManager = new ApplicationManager();
				// gui.displayConfigScreen();
				try {
					appManager.start();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		add(applySettingsBtn);
		add(applyDefaultBtn);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
