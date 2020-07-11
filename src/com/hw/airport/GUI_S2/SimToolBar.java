package com.hw.airport.GUI_S2;

import com.hw.airport.config.SimToolBarSettings;

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

    public SimToolBar(SimToolBarSettings guiSettings)
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
        for(int i = 0; i < 4; i++)
        {
            JLabel settingsLabel = new JLabel("Test_"+i);
            settingsLabel.setFont(simToolBarSettings.LabelFont);
            settingsLabel.setForeground(simToolBarSettings.LabelColor);
            add(settingsLabel);
            simulationSettings.add(settingsLabel);
        }
    }

    @Override
    public void update()
    {
    }
}
