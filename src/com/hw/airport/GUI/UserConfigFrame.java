package com.hw.airport.GUI;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.config.AppContainer;
import com.hw.airport.config.SimulationToolBarSettings;
import com.hw.airport.config.UserConfigFrameSettings;
import com.hw.airport.model.ActiveFlight;
import com.hw.airport.model.AppData;
import com.hw.airport.model.SimulationTimer;
import com.hw.airport.threading.TimerManager;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserConfigFrame extends JFrame implements ListSelectionListener, GUIElement {

	private static final long serialVersionUID = 1L;
	private SimulationToolBarSettings configPanelSettings;

	public UserConfigFrame(UserConfigFrameSettings frameSettings) {
		setTitle(frameSettings.getTitle());
		setSize(frameSettings.getWidth(), frameSettings.getHeight());
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
		JLabel runningRateLabel = new JLabel("Simulator running rate (ms):", JLabel.CENTER);
		add(runningRateLabel);

		JTextField runningRateFld = new JTextField();
		runningRateFld.setToolTipText("This controls overall sim speed (Greater than 50)");
		add(runningRateFld);
		
		JLabel simRateLabel = new JLabel("Check-in Rate/step (ms):", JLabel.CENTER);
		add(simRateLabel);

		
		JTextField simRateVal = new JTextField();
		simRateVal.setToolTipText("This controls how fast the check-in desk processing passengers (Greater than 500ms)");
		add(simRateVal);

		JLabel quePopulationRateLabel = new JLabel("Queue Population Rate (ms):", JLabel.CENTER);
		add(quePopulationRateLabel);

		JTextField quePopulationRateVal = new JTextField();
		quePopulationRateVal.setToolTipText("This controls the queue fill rate (Greater than 600ms)");
		add(quePopulationRateVal);

		JLabel maxOpenDeskLabel = new JLabel("Max Open Desks:", JLabel.CENTER);
		add(maxOpenDeskLabel);

		JTextField maxOpenDeskVal = new JTextField();
		maxOpenDeskVal.setToolTipText("This sets the number of open desks (1-10)");
		add(maxOpenDeskVal);

		JLabel passToDeskLabel = new JLabel("Passenger to desk ratio:", JLabel.CENTER);
		add(passToDeskLabel);

		JTextField passengerToDeskVal = new JTextField();
		passengerToDeskVal.setToolTipText("This sets the number of open desks per passenger (>1)");
		add(passengerToDeskVal);
		
		JLabel flightListLabel = new JLabel("List of available flights:", JLabel.CENTER);
		add(flightListLabel);

		List<String> flightList = AppContainer.getBookingSvc().getAllFlightsCodeWithBooking();
		

Set<String> set = new HashSet<String>(flightList);
		
		String[] stringArray = set.toArray(new String[0]);
		

				
		JList<String> flightListVal = new JList<String>(stringArray);
		JScrollPane scrollableList = new JScrollPane(flightListVal);
		flightListVal.setToolTipText("Flights actively boarding");
		
		
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
				String runningRateVal = runningRateFld.getText();

				if (openDeskVal.matches(".*\\d.*") & simExRateVal.matches(".*\\d.*") & passToDeskVal.matches(".*\\d.*")
						& queuPopval.matches(".*\\d.*") & runningRateVal.matches(".*\\d.*")) {

					boolean popuInputStat = (Integer.parseInt(queuPopval) >= 600);
					boolean passToDeskStat = (Integer.parseInt(passToDeskVal) > 0);
					boolean rateInputStat = (Integer.parseInt(simExRateVal) >= 500);
					boolean passInputStat = (Integer.parseInt(passToDeskVal) > 0);
					boolean runningRateInputStat = (Integer.parseInt(runningRateVal) >= 50);

					if (popuInputStat & passToDeskStat & rateInputStat & passInputStat & runningRateInputStat) {
						AirportSimulator.getInstnce().setMaxOpndCheckinDesk(Integer.parseInt(openDeskVal));
						AirportSimulator.getInstnce().setSimExcRate(Integer.parseInt(simExRateVal));
						AirportSimulator.getInstnce().setQueuePopulatingRate(Integer.parseInt(queuPopval));
						AirportSimulator.getInstnce().setPassToDeskRatio(Integer.parseInt(passToDeskVal));
				//		AppContainer.getGui().setAirportGuiSettings("resources/gui/monitor/"+ themeListVal.getSelectedValue()+".xml");
						List<String> activeFlightList = flightListVal.getSelectedValuesList();
						for (String code : activeFlightList) {
							AppData.getActiveFlights().add(new ActiveFlight(code, 10));
						}
						AirportSimulator.getInstnce().setSimRunningRate(Integer.parseInt(runningRateVal));
						AppContainer.getGui().setAirportGuiSettings("resources/gui/monitor/Dark.xml");
						setVisible(false);
						startApp();

					} else {

						JOptionPane.showMessageDialog(getSelf(), "Sim rate has to be greater than 50\nPopulation rate should be greater than 600\ncheck-in processing time has to be greater than 500\nMax open desks greater than 1\nDesk rate greater than 1");
					}
				} else {

					JOptionPane.showMessageDialog(getSelf(), "Parameters cannot be left blank and must be numbers.");
				}
			}

		});

		applyDefaultBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AirportSimulator.getInstnce().setMaxOpndCheckinDesk(2);
				AirportSimulator.getInstnce().setSimExcRate(500);
				AirportSimulator.getInstnce().setQueuePopulatingRate(1000);
				AirportSimulator.getInstnce().setSimRunningRate(100);
				AppData.getActiveFlights().add(new ActiveFlight("AF999", 10));
				AppData.getActiveFlights().add(new ActiveFlight("AA123", 10));
				
				AppContainer.getGui().setAirportGuiSettings("resources/gui/monitor/Dark.xml");
				
				setVisible(false);
				startApp();
			}
		});

		add(applySettingsBtn);
		add(applyDefaultBtn);
	}
	
	private void startApp() {
		TimerManager timerManager = new TimerManager();
		SimulationTimer appTimer = timerManager.setupTimer();
		//register observers which need to be notified every time the timer task is executed 
		//DeskManager need to be notified when attempting to add passenger the queue
		appTimer.registerObserver(AppContainer.getDeskManager());
		//TimerManager needs to be notified when the simulation time has ended to stop the queue populating task
		AppContainer.getDeskManager().registerObserver(timerManager);
		appTimer.registerObserver(AppContainer.getGui());
		SwingUtilities.invokeLater(() -> AppContainer.getGui().displayAirportMonitorScreen());
	}

	@Override
	public void refresh(Object arg) {

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
	}
}
