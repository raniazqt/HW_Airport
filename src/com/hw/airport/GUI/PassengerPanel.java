package com.hw.airport.GUI;

import com.hw.airport.config.AppContainer;
import com.hw.airport.config.PassengerPanelSettings;
import com.hw.airport.model.Booking;
import com.hw.airport.service.GUISvc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PassengerPanel extends JPanel implements GUIElement
{
	private PassengerPanelSettings guiSettings;
	private JTable passengerJTable;
	private List<Booking> passengersList;
	private GUISvc guiSvc;
	private String[] columnNames;
	private DefaultTableModel model;

	public PassengerPanel(PassengerPanelSettings guiSettings)
	{
		this.guiSvc = AppContainer.getGuiSvc();
		this.passengerJTable = new JTable();
		this.model = new DefaultTableModel();
		this.guiSettings = guiSettings;
		this.columnNames = new String[] {"Name", "Booking Code", "Flight #", "Baggage Diminsions (cm)", "Weight (kg)"};
	}

	@Override
	public JScrollPane getSelf()
	{
		JScrollPane scrollPane = new JScrollPane(passengerJTable);
		scrollPane.setBackground(guiSettings.BackGroundColor);
		scrollPane.setBorder(guiSettings.BorderType);
		scrollPane.setForeground(guiSettings.LabelColor);

		return scrollPane;
	}

	@Override
	public void draw()
	{
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(guiSettings.BackGroundColor);
		this.setFont(guiSettings.LabelFont);
		this.setForeground(guiSettings.LabelColor);
		this.setBorder(guiSettings.BorderType);

		passengerJTable.setBorder(guiSettings.BorderType);
		passengerJTable.setBackground(guiSettings.BackGroundColor);
		passengerJTable.setFont(guiSettings.LabelFont);
		passengerJTable.setForeground(guiSettings.LabelColor);
		passengerJTable.getTableHeader().setFont(guiSettings.LabelFont);
		passengerJTable.getTableHeader().setBackground(guiSettings.BackGroundColor);
		passengerJTable.getTableHeader().setForeground(guiSettings.LabelColor);
	}

	@Override
	public void init(Object targetObj)
	{
		fetchUpdatedPassengerData();
	}

	private void fetchUpdatedPassengerData() {
		SwingWorker<String[][], Void> worker = new SwingWorker<>() {
			@Override
			protected String[][] doInBackground() {
				passengersList = guiSvc.getQueuePassengersList();
				String[][] data = new String[passengersList.size()][5];
				int i = 0;
				synchronized (passengersList) {
					for (Booking booking : passengersList) {
						data[i][0] = booking.getFullName();
						data[i][1] = booking.getRefCode().toUpperCase();
						data[i][2] = booking.getFlightCode().toUpperCase();

						String dim = booking.getBaggageWidth() + " X "
								+ booking.getBaggageHeight() + " X"
								+ booking.getBaggageLength();

						data[i][3] = dim;
						data[i][4] = Double.toString(booking.getTotalBaggageWeight());
						i++;
					}
				}

				return data;
			}

			protected void done() {
				try {
					String[][] data = get();
					model.setDataVector(data, columnNames);
					passengerJTable.setModel(model);
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		};
		worker.execute();
	}

	@Override
	public void refresh(Object targetObj) {
		fetchUpdatedPassengerData();
	}
}

