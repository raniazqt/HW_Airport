package com.hw.airport.GUI_S2;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

import com.hw.airport.config.AppContainer;
import com.hw.airport.config.PassengerPanelSettings;
import com.hw.airport.model.Booking;
import com.hw.airport.service.GUISvc;

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
	public JPanel getSelf()
	{
		return this;
	}

	@Override
	public void draw()
	{
		JScrollPane scrollPane = new JScrollPane(passengerJTable);
		scrollPane.setBorder(guiSettings.BorderType);
		scrollPane.setBackground(guiSettings.LabelColor);

		this.add(scrollPane);
	}

	@Override
	public void init(Object targetObj)
	{
		fetchUpdatedPassengerData();

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.passengerJTable.setBorder(guiSettings.BorderType);
		this.passengerJTable.setBackground(guiSettings.BackGroundColor);
		this.passengerJTable.setFont(guiSettings.LabelFont);
		this.passengerJTable.setForeground(guiSettings.LabelColor);
	}

	private void fetchUpdatedPassengerData() {
		SwingWorker<String[][], Void> worker = new SwingWorker<String[][], Void>() {
			@Override
			protected  String[][] doInBackground() throws Exception {
				passengersList = guiSvc.getQueuePassengersList();
				String[][] data = new String[passengersList.size()][5];
				int i = 0;
				synchronized(passengersList) {
					for(Booking booking : passengersList){
						data[i][0] = booking.getFullName();
						data[i][1] = booking.getRefCode().toUpperCase();
						data[i][2] = booking.getFlightCode().toUpperCase();
						
						String dim = Double.toString(booking.getBaggageWidth()) + " X " 
								+ Double.toString(booking.getBaggageHeight()) + " X" 
								+ Double.toString(booking.getBaggageLength());
						
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

