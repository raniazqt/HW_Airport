package com.hw.airport.GUI_S2;

import com.hw.airport.config.AppContainer;
import com.hw.airport.config.CheckInDeskPanelSettings;
import com.hw.airport.model.Desk;
import com.hw.airport.service.GUISvc;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CheckInDeskPanel extends JPanel implements GUIElement
{
	private List<DeskPanel> deskPanels;
	private CheckInDeskPanelSettings guiSettings;
	private GUISvc guiDataSvc;
	private int currentTableIndex;

	public CheckInDeskPanel(CheckInDeskPanelSettings guiSettings)
	{
		this.guiSettings = guiSettings;
		deskPanels = new ArrayList<>();
		guiDataSvc = AppContainer.getGuiSvc();
		currentTableIndex = 1;
	}

	@Override
	public JPanel getSelf()
	{
		return this;
	}

	@Override
	public void draw()
	{
	}

	@Override
	public void init(Object targetObj)
	{
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.setFont(guiSettings.LabelFont);
		this.setBackground(guiSettings.BackGroundColor);
		this.setBorder(guiSettings.BorderType);
	}

	private DeskPanel findDeskPanel(Desk desk) {
		if (null != desk) {
			for (DeskPanel panel : deskPanels) {
				if (null != panel.getDesk() && panel.getDesk().getId() != null) {
					if (panel.getDesk().getId().equals(desk.getId())) {
						return panel;
					}
				}
			}
		}
		return null;
	}


	@Override
	public  void refresh(Object args)
	{
		if(!(args instanceof Desk))
			return;

		Desk updatedDesk = (Desk) args;
		DeskPanel crntDeskPanel = findDeskPanel(updatedDesk);
		if (null == crntDeskPanel) {
			crntDeskPanel= new DeskPanel(guiSettings, updatedDesk);
			crntDeskPanel.init(updatedDesk);
			crntDeskPanel.draw();
			deskPanels.add(crntDeskPanel);

			JScrollPane crntDeskScrollPane = crntDeskPanel.getSelf();
			crntDeskScrollPane.setBorder(BorderFactory.createTitledBorder("DESK #" + currentTableIndex));
			add(crntDeskScrollPane);
			currentTableIndex++;
		}
		else {
			crntDeskPanel.refresh(updatedDesk);
		}
	}
}
