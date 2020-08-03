package com.hw.airport.GUI;

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

    public SimToolBar(SimulationToolBarSettings guiSettings)
    {
        this.simToolBarSettings = guiSettings;
        this.simulationSettings = new ArrayList<>();
        this.setLayout(guiSettings.Layout);
        this.setFont(guiSettings.LabelFont);
        this.setBackground(guiSettings.BackGroundColor);
        this.setBorder(guiSettings.BorderType);
        this.setFloatable(false);
    }

    @Override
    public JToolBar getSelf()
    {
        return this;
    }

    @Override
    public void draw()
    {
        for(JLabel settingsLabel : simulationSettings)
        {
            add(settingsLabel);
        }
    }

    @Override
    public void init(Object targetObj)
    {
        refreshSimSettings();
        createSettingsLabels();
    }

    private void createSettingsLabels() {
        Map<String, Integer> simSettings = guiDataSvc.retrieveSimulatorSettings();
        for(Map.Entry<String,Integer> entry : simSettings.entrySet()){
            String dataValue = entry.getKey().concat(entry.getValue().toString());
            JLabel settingsLabel = new JLabel(dataValue);
            settingsLabel.setFont(simToolBarSettings.LabelFont);
            settingsLabel.setForeground(simToolBarSettings.LabelColor);
            simulationSettings.add(settingsLabel);
        }
    }

    private void refreshSimSettings() {
        removeAll();
        repaint();
        revalidate();
    }


    @Override
	public void refresh(Object targetObj) {

	}
}
