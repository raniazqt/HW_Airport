package com.hw.airport.GUI_S2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JToolBar;

import com.hw.airport.config.AppContainer;
import com.hw.airport.config.SimToolBarSettings;
import com.hw.airport.service.GUISvc;

public class SimToolBar extends JToolBar implements GUIElement<JToolBar>
{
    private SimToolBarSettings simToolBarSettings;
    private List<JLabel> simulationSettings;
    private boolean isInit;
    
    private GUISvc guiDataSvc = AppContainer.getGuiSvc();

    public SimToolBar(SimToolBarSettings guiSettings)
    {
        this.simToolBarSettings = guiSettings;
        this.simulationSettings = new ArrayList<>();
        this.setLayout(guiSettings.Layout);
        this.setFont(guiSettings.LabelFont);
        this.setBackground(guiSettings.BackGroundColor);
        this.setBorder(guiSettings.BorderType);
        this.setFloatable(false);
        this.isInit = false;
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
    public void update(Object targetObj)
    {
        if(isInit)
            return;
        JLabel settingsLabel;
        String dataValue;
        Map<String, Double> simSettings = guiDataSvc.retrieveSimulatorSettings();
        for(Map.Entry<String,Double> entry : simSettings.entrySet()){
            dataValue = entry.getKey().toString().concat(entry.getValue().toString());
            settingsLabel = new JLabel(dataValue);
            settingsLabel.setFont(simToolBarSettings.LabelFont);
            settingsLabel.setForeground(simToolBarSettings.LabelColor);
            add(settingsLabel);
            simulationSettings.add(settingsLabel);
        }
    }

	

	@Override
	public void refreshGUI(Object targetObj) {
		// TODO Auto-generated method stub
		
	}
}
