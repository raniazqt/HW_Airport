package com.hw.airport.GUI_S1;
import com.hw.airport.GUI_S2.MasterScreen;

public class AirportGUIImpl implements AirportGUI {

	@Override
	public void displayAirportStatusScreen() {
		new MasterScreen().setVisible(true);

	}

}
