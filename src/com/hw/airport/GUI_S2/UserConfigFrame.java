package com.hw.airport.GUI_S2;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.config.AppContainer;
import com.hw.airport.config.FrameSettings;
import com.hw.airport.config.GUIComponentSettings;
import com.hw.airport.main.ApplicationManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserConfigFrame extends JFrame {
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

		JLabel simRateLabel = new JLabel("Simulation Rate:");
		add(simRateLabel);

		JTextField simRateVal = new JTextField();
		add(simRateVal);

		JLabel quePopulationRateLabel = new JLabel("Queue Population Rate:");
		add(quePopulationRateLabel);

		JTextField quePopulationRateVal = new JTextField();
		add(quePopulationRateVal);

		JLabel maxOpenDeskLabel = new JLabel("Max Open Desks:");
		add(maxOpenDeskLabel);

		JTextField maxOpenDeskVal = new JTextField();
		add(maxOpenDeskVal);

		JButton applySettingsBtn = new JButton("Start");
		JButton applyDefaultBtn = new JButton("Default");

		applySettingsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				String openDeskVal = maxOpenDeskVal.getText();
				String simExRateVal = simRateVal.getText();
				String queuPopval = quePopulationRateVal.getText();

				if (openDeskVal.matches("[1-9]+") & simExRateVal.matches("[1-9]+") & queuPopval.matches(".*\\d.*")) {

					boolean deskInputStat = openDeskVal.isBlank();
					boolean simInputStat = simExRateVal.isBlank();
					boolean popuInputStat = queuPopval.isBlank() || (Integer.parseInt(queuPopval) > 1000);

					if (!(deskInputStat & simInputStat & popuInputStat)) {
						AirportSimulator.getInstnce().setMaxOpndCheckinDesk(Integer.parseInt(openDeskVal));
						AirportSimulator.getInstnce().setSimExcRate(Long.parseLong(simExRateVal));
						AirportSimulator.getInstnce().setQueuePopulatingRate(Long.parseLong(queuPopval));
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

					} else {// msg for in valid values
					}
				}
			}

		});

		applyDefaultBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AirportSimulator.getInstnce().setMaxOpndCheckinDesk(2);
				AirportSimulator.getInstnce().setSimExcRate(1);
				AirportSimulator.getInstnce().setQueuePopulatingRate(1000);

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
}
