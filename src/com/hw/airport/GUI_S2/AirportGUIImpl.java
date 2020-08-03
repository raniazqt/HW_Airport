package com.hw.airport.GUI_S2;
import com.hw.airport.config.AirportGuiSettings;
import com.hw.airport.config.UserConfigFrameSettings;
import com.hw.airport.observer.SynchronizedObservable;
import com.hw.airport.util.XmlHandler;

import java.io.IOException;

public class AirportGUIImpl extends SynchronizedObservable implements AirportGUI
{
	private GUIElement masterFrame;
	private GUIElement configFrame;
	private AirportGuiSettings airPortGuiSettings;
	private UserConfigFrameSettings configFrameSettings;

	public AirportGUIImpl()
	{
		masterFrame = null;
		configFrame = null;
		setUserConfigFrameSettings();
	}

	@Override
	public void displayConfigScreen() {
		configFrame = new UserConfigFrame(configFrameSettings);
		configFrame.init(null);
		configFrame.draw();
		configFrame.getSelf().setVisible(true);
	}

	@Override
	public void displayAirportMonitorScreen() {
		masterFrame = new AirportMonitorFrame(airPortGuiSettings);
		masterFrame.init(null);
		masterFrame.draw();
		masterFrame.getSelf().setVisible(true);
	}

	@Override
	public void setAirportGuiSettings(String fileName) {
		try {
			airPortGuiSettings = XmlHandler.getInstance().loadFromXml(fileName);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public AirportGuiSettings getAirportGuiSettings() {
		return airPortGuiSettings;
	}

	@Override
	public void onNotify(Object args) {
		this.masterFrame.refresh(args);
	}

	protected void setUserConfigFrameSettings() {
		try {
			configFrameSettings = XmlHandler.getInstance().loadFromXml("resources/gui/user/UserConfigurationScreen.xml");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

