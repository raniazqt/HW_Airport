package com.hw.airport.GUI_S2;

import com.hw.airport.config.CheckInDeskPanelSettings;
import com.hw.airport.enums.DESK_STATUS;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Desk;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.concurrent.ExecutionException;

public class DeskPanel implements GUIElement
{
	private CheckInDeskPanelSettings guiSettings;

	private JTable deskTable;
	private DefaultTableModel model;
	private Desk desk;
	private int deskIndex;

	public DeskPanel(CheckInDeskPanelSettings guiSettings, Desk desk)
	{
		this.desk = desk;
		this.guiSettings = guiSettings;
		this.deskTable = new JTable();
		this.model = new DefaultTableModel();
	}

	public JScrollPane getSelf()
	{
		JScrollPane scrollPane = new JScrollPane(deskTable);
		scrollPane.setBackground(guiSettings.LabelColor);
		scrollPane.setBorder(guiSettings.BorderType);

		return scrollPane;
	}

	public Desk getDesk()
	{
		return desk;
	}
	public void setDesk(Desk desk)
	{
		this.desk = desk;
	}

	public void draw()
	{
		deskTable.setLayout(guiSettings.Layout);
		deskTable.setFont(guiSettings.LabelFont);
		deskTable.setBackground(guiSettings.BackGroundColor);
		deskTable.setForeground(guiSettings.LabelColor);
	}

	@Override
	public void init(Object targetObj)
	{
		getDataModel(targetObj);
	}

	@Override
	public void refresh(Object arg)
	{
		getDataModel(arg);
		
	}

	private void getDataModel(Object arg){
		SwingWorker<String[][], Void> worker = new SwingWorker<String[][], Void>() {
			@Override
			protected String[][] doInBackground() throws Exception {
				// Simulate doing something useful.
				Desk updatedDesk = (Desk) arg;
				String[][] data = new String[2][2];
				if (null != updatedDesk){
					desk = updatedDesk;
					if (updatedDesk.getStatus().equals(DESK_STATUS.CLOSED)) {
						data = new String[1][2];
						data[0][0] = "Status";
						data[0][1] = "DESK CLOSED";

					}else {
						data = new String[2][2];
						data[0][0] = "Status";
						data[0][1] = updatedDesk.getStatus().getValue();
						data[1][0] = "Passenger";
						Booking passenger = updatedDesk.getPassenger();
						if(passenger != null){
							data[1][1] = passenger.getFullName();
						}
					}
				}
				// Here we can return some object of whatever type
				// we specified for the first template parameter.
				// (in this case we're auto-boxing 'true').

				return data;
			}
			
			protected void done() {
				try {
					String[][] data = get();
					model.setDataVector(data, new String[] {"",""});
					deskTable.setModel(model);
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		};
		worker.execute();

	}

	public int getDeskIndex() {
		return deskIndex;
	}

	public void setDeskIndex(int deskIndex) {
		this.deskIndex = deskIndex;
	}
}
