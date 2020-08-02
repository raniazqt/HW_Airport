package com.hw.airport.main;

import com.hw.airport.GUI_S2.AirportGUI;
import com.hw.airport.config.AppContainer;

public class ApplicationStart {
	//private static Logger LOG = LogManager.getLogger(ApplicationStart.class);
	private static AirportGUI gui= AppContainer.getInstance().getGui();

	public static void main(String[] args) throws Exception {
		//LOG.debug("Collecting settings from user");
		gui.displayConfigScreen();
	}

}


