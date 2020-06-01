package com.hw.airport.GUI_S1;
import com.hw.airport.GUI_S2.MasterFrame;

public class AirportGUIImpl implements AirportGUI {

	@Override
	public void displayAirportStatusScreen() {
		new MasterFrame().setVisible(true);

	}

}
