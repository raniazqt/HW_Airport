package com.hw.airport.GUI_S2;

import com.hw.airport.config.CheckInDeskPanelSettings;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Desk;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DeskPanel implements GUIElement
{
	private CheckInDeskPanelSettings guiSettings;

	private JTable deskTable;
	private DefaultTableModel model;
	private Desk desk;

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
		scrollPane.setBorder(guiSettings.BorderType);
		scrollPane.setBackground(guiSettings.LabelColor);

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
		deskTable.setBorder(guiSettings.BorderType);
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

	private void getDataModel(Object arg)
	{
		Desk updatedDesk = (Desk) arg;
		if (null != updatedDesk)
		{
			String[][] data = new String[2][2];
			data[0][0] = "Status";
			data[0][1] = updatedDesk.getStatus().getValue();
			data[1][0] = "Passenger";
			Booking passenger = updatedDesk.getPassenger();
			if(passenger != null)
			{
				data[1][1] = passenger.getFullName();
			}

			model.setDataVector(data, new String[] {"Hello","Hello"});
		}

		deskTable.setModel(model);
	}
}
