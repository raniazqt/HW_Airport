package com.hw.airport.GUI_S2;

import com.hw.airport.config.AppContainer;
import com.hw.airport.config.PassengerPanelSettings;
import com.hw.airport.model.Booking;
import com.hw.airport.service.GUISvc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import static java.util.Collections.unmodifiableList;

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
		this.columnNames = new String[] {"Name #, Booking #", "Weight #", "Volume #", "What#"};
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
		passengersList = guiSvc.getQueuePassengersList();
		synchronized (unmodifiableList(passengersList)) {
			Object[][] data = new Object[passengersList.size()][5];
			int i = 0;
			for(Booking booking : passengersList){
				data[i][0] = booking.getFullName();
				data[i][1] = booking.getRefCode();
				data[i][2] = booking.getFlightCode();
				data[i][3] = booking.getTotalBaggageWeight();
				data[i][4] = booking.getTotalBaggageVolume();
				i++;
			}
			model.setDataVector(data, columnNames);
		}

		passengerJTable.setModel(model);
	}

	@Override
	public void refresh(Object targetObj) {
		fetchUpdatedPassengerData();
	}
}

