package com.hw.airport.GUI_S2;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.hw.airport.config.AppContainer;
import com.hw.airport.config.CheckInDeskPanelSettings;
import com.hw.airport.model.Desk;
import com.hw.airport.service.GUISvc;

public class CheckInDeskPanel extends JPanel implements GUIElement<JPanel>
{
	private List<DeskPanel> deskPanels = new ArrayList<>();
	private CheckInDeskPanelSettings guiSettings;

	private GUISvc guiDataSvc = AppContainer.getGuiSvc();

	private DefaultListModel<Desk> model = new DefaultListModel<Desk>();


	//  private GUISvc guiSvc = AppContainer.getGuiSvc();


	public CheckInDeskPanel(CheckInDeskPanelSettings guiSettings, int deskCnt)
	{
		this.guiSettings = guiSettings;
		this.setLayout(guiSettings.Layout);
		this.setFont(guiSettings.LabelFont);
		this.setBackground(guiSettings.BackGroundColor);
		this.setBorder(guiSettings.BorderType);

		for (int i=0; i <deskCnt; i++) {
			this.deskPanels.add(new DeskPanel(guiSettings, null));
		}
	}

	@Override
	public JPanel getSelf()
	{
		return this;
	}

	@Override
	public void draw(){
	//	this.setPreferredSize(new Dimension(200, 200));
		//this.add(new JLabel("Check-in Desk Panel", SwingConstants.CENTER));
		//	this.setBackground(new Color(255));
		//this.setOpaque(true);
	//	this.setBackground(Color.white);
	//	this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		for(DeskPanel deskPanel: deskPanels){
			deskPanel.add(new JLabel("Desk # 1", SwingConstants.CENTER));
			deskPanel.draw();
			//add(deskPanel);
		}
		/*
		 * if (deskPanels.size() >0) { 
		 */
		//	this.ad(deskPanels);
		/*JScrollPane scrollPane = new JScrollPane(deskPanels); 
		scrollPane.setBorder(guiSettings.BorderType);
		scrollPane.setBackground(guiSettings.LabelColor); 
		this.add(scrollPane); 
		 */

	}

	@Override
	public void update(Object targetObj)
	{
		if (null != targetObj) {
			DeskPanel crntDeskPanel;
			Desk desk = (Desk)targetObj;

			crntDeskPanel = findDeskPanel(desk);
			if (null == crntDeskPanel) {
				crntDeskPanel= new DeskPanel(guiSettings, desk); 
				deskPanels.add(crntDeskPanel);
			}
			crntDeskPanel.update();
			//	crntDeskPanel.draw();
			//	model.addAll(guiDataSvc.getOpenedDeskList());
			draw();
		}
		/*
		 * List<Desk> openDeskList = guiDataSvc.getOpenedDeskList(); // deskPanels = new
		 * ArrayList<>();
		 * 
		 * for (Desk desk : openDeskList) { crntDeskPanel = findDeskPanel(desk); if
		 * (null == crntDeskPanel) { crntDeskPanel= new DeskPanel(guiSettings, desk);
		 * deskPanels.add(crntDeskPanel); } crntDeskPanel.update(); } this.draw();
		 */   
	}

	private DeskPanel findDeskPanel(Desk desk) {
		if (null != desk) {
			for (DeskPanel panel : deskPanels) {
				if (null != panel.getDesk()) {
					if (panel.getDesk().getId() == desk.getId()) {
						return panel;
					}
				}
			}
		}
		return null;
	}


	@Override
	public void refreshGUI(Object args) {

	}


}
