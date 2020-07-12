package com.hw.airport.GUI_S2;

import com.hw.airport.config.SimToolBarSettings;
import com.hw.airport.service.GUISvc;
import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SimToolBar extends JToolBar implements GUIElement<JToolBar>
{
    //TODO: draw method called once.
    //TODO: update method fetches data directly from GUISvc + updates values in GUI elements.
    //TODO: draw out each panel, then after drawing test updates, then refactor the common code
    //TODO: for the front end.

    private SimToolBarSettings simToolBarSettings;
    private List<JLabel> simulationSettings;
    private boolean isInit;

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
    public void update(GUISvc guiDataSvc)
    {
        if(isInit)
            return;

        List<Pair<String, Double>> simSettings = guiDataSvc.retrieveSimulatorSettings();
        for(int i = 0; i < simSettings.size(); i++)
        {
            String dataValue = simSettings.get(i).toString();
            JLabel settingsLabel = new JLabel(dataValue);
            settingsLabel.setFont(simToolBarSettings.LabelFont);
            settingsLabel.setForeground(simToolBarSettings.LabelColor);
            add(settingsLabel);
            simulationSettings.add(settingsLabel);
        }
    }
}
