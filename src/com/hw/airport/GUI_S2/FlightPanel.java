package com.hw.airport.GUI_S2;

import com.hw.airport.config.ActiveFlightPanelSettings;
import com.hw.airport.model.ActiveFlight;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FlightPanel implements GUIElement
{
	private ActiveFlightPanelSettings guiSettings;
	private DefaultTableModel model;
	private JTable flightTable;
	private String activeFlightCode;

	public FlightPanel(ActiveFlightPanelSettings guiSettings)
	{
		this.guiSettings = guiSettings;
		model = new DefaultTableModel();
		flightTable = new JTable();
		activeFlightCode = "";
	}

	@Override
	public JScrollPane getSelf()
	{
		JScrollPane scrollPane = new JScrollPane(flightTable);
		scrollPane.setBorder(guiSettings.BorderType);
		scrollPane.setBackground(guiSettings.LabelColor);

		return scrollPane;
	}

	@Override
	public void draw()
	{
		flightTable.setLayout(guiSettings.Layout);
		flightTable.setFont(guiSettings.LabelFont);
		flightTable.setBackground(guiSettings.BackGroundColor);
		flightTable.setBorder(guiSettings.BorderType);
	}

	@Override
	public void init(Object targetObj)
	{
		updateDataModels(targetObj);
	}

	@Override
	public void refresh(Object arg)
	{
		updateDataModels(arg);
	}


	private void updateDataModels(Object args)
	{
		if (args != null && args instanceof ActiveFlight) {

			ActiveFlight updatedFlight = (ActiveFlight) args;

			String[][] data = new String[6][2];
			data[0][0] = "Flight CD";
			data[0][1] = updatedFlight.getFlightCd();
			data[1][0] = "Timer";
			data[1][1] = String.valueOf(updatedFlight.getTimer());
			data[2][0] = "Passengers On Board:";
			data[2][1] = String.valueOf(updatedFlight.getBoardedPsngrCnt());
			data[3][0] = "Total Volume On Flight:";
			data[3][1] = String.valueOf(updatedFlight.getTotalVolume());
			data[4][0] = "Total Weight:";
			data[4][1] = String.valueOf(updatedFlight.getTotalWeight());
			data[5][0] = "Extra Charges Collected:";
			data[5][1] = String.valueOf(updatedFlight.getXtraChargeCollected());

			model.setDataVector(data, new String[] {"", ""});
			flightTable.setModel(model);
		}
	}
	public String getActiveFlightCode() {
		return activeFlightCode;
	}
	public void setActiveFlightCode(String activeFlightCode) { 
		this.activeFlightCode = activeFlightCode;
	}

}
