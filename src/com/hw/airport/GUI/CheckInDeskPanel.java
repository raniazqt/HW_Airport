package com.hw.airport.GUI;

import com.hw.airport.config.CheckInDeskPanelSettings;
import com.hw.airport.enums.DESK_STATUS;
import com.hw.airport.model.Desk;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

public class CheckInDeskPanel extends JPanel implements GUIElement
{
	private List<DeskPanel> deskPanels;
	private CheckInDeskPanelSettings guiSettings;
	private int currentDeskIndex;

	public CheckInDeskPanel(CheckInDeskPanelSettings guiSettings)
	{
		this.guiSettings = guiSettings;
		deskPanels = new ArrayList<>();
		currentDeskIndex = 1;
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
		this.setPreferredSize(new Dimension(1440,100));
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
		clearClosedPanels();

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
			TitledBorder borderToCreate = BorderFactory.createTitledBorder("DESK #" + currentDeskIndex);
			borderToCreate.setTitleColor(guiSettings.LabelColor);
			borderToCreate.setTitleFont(guiSettings.LabelFont);
			crntDeskScrollPane.setBorder(borderToCreate);

			add(crntDeskScrollPane);
			currentDeskIndex++;
		}
		else {
			crntDeskPanel.refresh(updatedDesk);
		}
	}

	private void clearClosedPanels() {
		DeskPanel closedPanel = findClosedDeskPanel();
		if(closedPanel != null)
		{
			removeAll();
			deskPanels.remove(closedPanel);
			for(DeskPanel panel : deskPanels)
			{
				add(panel.getSelf());
			}
		}
	}

	private DeskPanel findClosedDeskPanel()
	{
		for(DeskPanel panel : deskPanels) {
			if(panel.getDesk().getStatus() == DESK_STATUS.CLOSED)
				return panel;
		}
		return null;
	}
}
