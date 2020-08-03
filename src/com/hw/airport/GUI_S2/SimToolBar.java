package com.hw.airport.GUI_S2;

import com.hw.airport.config.AppContainer;
import com.hw.airport.config.SimulationToolBarSettings;
import com.hw.airport.service.GUISvc;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimToolBar extends JToolBar implements GUIElement
{
    private SimulationToolBarSettings simToolBarSettings;
    private List<JLabel> simulationSettings;
    private GUISvc guiDataSvc = AppContainer.getGuiSvc();
    private boolean init;

    public SimToolBar(SimulationToolBarSettings guiSettings)
    {
        this.simToolBarSettings = guiSettings;
        this.simulationSettings = new ArrayList<>();
        this.setLayout(guiSettings.Layout);
        this.setFont(guiSettings.LabelFont);
        this.setBackground(guiSettings.BackGroundColor);
        this.setBorder(guiSettings.BorderType);
        this.setFloatable(false);
        init = false;
    }

    @Override
    public JToolBar getSelf()
    {
        return this;
    }

    //TODO: Refactor later either draw or update for the tool bar.
    @Override
    public void draw()
    {
    }

    @Override
    public void init(Object targetObj)
    {
        removeAll();
        repaint();
        revalidate();

        Map<String, Integer> simSettings = guiDataSvc.retrieveSimulatorSettings();
        for(Map.Entry<String,Integer> entry : simSettings.entrySet()){
            String dataValue = entry.getKey().concat(entry.getValue().toString());
            JLabel settingsLabel = new JLabel(dataValue);
            settingsLabel.setFont(simToolBarSettings.LabelFont);
            settingsLabel.setForeground(simToolBarSettings.LabelColor);
            add(settingsLabel);
            simulationSettings.add(settingsLabel);
        }
    }

	

	@Override
	public void refresh(Object targetObj) {

	}
}
