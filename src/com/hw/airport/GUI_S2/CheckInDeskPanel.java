package com.hw.airport.GUI_S2;

import com.hw.airport.config.CheckInDeskPanelSettings;
import com.hw.airport.model.Desk;
import com.hw.airport.service.GUISvc;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CheckInDeskPanel extends JPanel implements GUIElement<JPanel>
{
    private List<DeskPanel> deskPanels;
    private CheckInDeskPanelSettings guiSettings;
    private int currentDeskCount;

    public CheckInDeskPanel(CheckInDeskPanelSettings guiSettings)
    {
        this.guiSettings = guiSettings;
        this.setLayout(guiSettings.Layout);
        this.setFont(guiSettings.LabelFont);
        this.setBackground(guiSettings.BackGroundColor);
        this.setBorder(guiSettings.BorderType);
    }

    @Override
    public JPanel getSelf()
    {
        return this;
    }

    @Override
    public void draw()
    {
        for(int i = 0; i < currentDeskCount; i++)
        {
            deskPanels.get(i).draw();
            add(deskPanels.get(i));
        }
    }

    @Override
    public void update(GUISvc guiDataSvc)
    {
        List<Desk> openDeskList = guiDataSvc.getOpenedDeskList();
        currentDeskCount = openDeskList.size();
        deskPanels = new ArrayList<>(currentDeskCount);

        for(int i = 0; i <currentDeskCount; i++)
        {
            DeskPanel deskPanel = new DeskPanel(guiSettings);
            deskPanel.update(openDeskList.get(i));
            deskPanels.add(deskPanel);
        }
    }
}
