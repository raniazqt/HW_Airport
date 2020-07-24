package com.hw.airport.GUI_S2;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.hw.airport.config.AppContainer;
import com.hw.airport.config.CheckInDeskPanelSettings;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Desk;
import com.hw.airport.service.GUISvc;

public class DeskPanel extends JPanel
{
	private CheckInDeskPanelSettings guiSettings;


	private JTable deskTable = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	GUISvc guiSvc = AppContainer.getGuiSvc();
	Desk desk;

	public Desk getDesk() {
		return desk;
	}

	public void setDesk(Desk desk) {
		this.desk = desk;
	}

	public DeskPanel(CheckInDeskPanelSettings guiSettings, Desk desk)
	{
		this.guiSettings = guiSettings;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setFont(guiSettings.LabelFont);
		this.setBackground(guiSettings.BackGroundColor);
		this.setBorder(guiSettings.BorderType);
		this.setSize(guiSettings.DeskFrameSize);
		this.desk = desk;
	}

	public JPanel getSelf()
	{
		return this;
	}


	public void draw(){
	//	this.getDataModel(desk);
		this.setPreferredSize(new Dimension(300, 200));
		// this.add(deskTable);
		add(new JLabel("Desk # 1", SwingConstants.CENTER));
		JScrollPane scrollPane=new JScrollPane(deskTable);
		scrollPane.setPreferredSize(new Dimension(300, 200));
		scrollPane.setBorder(guiSettings.BorderType);
		//scrollPane.setBackground(guiSettings.LabelColor); 

		this.add(scrollPane);

	}

	public void update(){
		getDataModel(desk);
	}

	private void getDataModel(Desk desk) {
		String[][] data = new String[3][2];
		if (null != desk) {
			Desk crntDesk = guiSvc.getDeskById(desk.getId());
			if (null != crntDesk) {
				data[0][0] = "Check In Desk";
				data[0][1] = crntDesk.getId().toString();
				data[1][0] = "Status";
				data[1][1] = crntDesk.getStatus().getValue();
				data[2][0] = "Passenger";
				Booking passenger = crntDesk.getPassenger();

				if (null != passenger) {
					data[2][1] = passenger.getFullName();
				}
			}
			//TODO: Handle the case when desk is not found
		}
		model.setDataVector(data,new String[] {"Hello","Hello"});
		deskTable.setModel(model);
		//	deskTable.setBackground(new Color(100));
		this.deskTable.setBorder(guiSettings.BorderType);
		this.deskTable.setBackground(guiSettings.BackGroundColor);
		this.deskTable.setFont(guiSettings.LabelFont);
		this.deskTable.setForeground(guiSettings.LabelColor);
	}
}
