package com.hw.airport.GUI_S2;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.config.AppContainer;
import com.hw.airport.config.SimulationToolBarSettings;
import com.hw.airport.config.UserConfigFrameSettings;
import com.hw.airport.main.ApplicationManager;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserConfigFrame extends JFrame implements ListSelectionListener, GUIElement{
	private SimulationToolBarSettings configPanelSettings;

	public UserConfigFrame(UserConfigFrameSettings frameSettings) {
		setTitle(frameSettings.getMainScreenTitle());
		setSize(frameSettings.getMainScreenWidth(), frameSettings.getMainScreenHeight());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		configPanelSettings = frameSettings.componentSettings;
	}

	public JFrame getSelf() {
		return this;
	}

	@Override
	public void draw() {
		setLayout(configPanelSettings.Layout);
		setFont(configPanelSettings.LabelFont);
		setBackground(configPanelSettings.BackGroundColor);
		setForeground(configPanelSettings.LabelColor);
	}

	@Override
	public void init(Object targetObj) {
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
						setVisible(false);
						AppContainer.getGui().setAirportGuiSettings("resources/gui/monitor/"+ themeListVal.getSelectedValue()+".xml");
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
				setVisible(false);
				AppContainer.getGui().setAirportGuiSettings("resources/gui/monitor/"+ themeListVal.getSelectedValue()+".xml");
				ApplicationManager appManager = new ApplicationManager();
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
	public void refresh(Object arg) {

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
	}
}
