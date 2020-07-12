package com.hw.airport.GUI_S2;

import com.hw.airport.config.CheckInDeskPanelSettings;
import com.hw.airport.model.Desk;
import com.hw.airport.service.GUISvc;

import javax.swing.*;

public class DeskPanel extends JPanel
{
    private CheckInDeskPanelSettings guiSettings;

    private JLabel currentPsngrLabel;
    private JLabel currentDeskStatusLabel;
    private JLabel currentDeskIdLabel;

    private Desk deskModel;

    public DeskPanel(CheckInDeskPanelSettings guiSettings)
    {
        this.guiSettings = guiSettings;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setFont(guiSettings.LabelFont);
        this.setBackground(guiSettings.BackGroundColor);
        this.setBorder(guiSettings.BorderType);
        this.setSize(guiSettings.DeskFrameSize);
    }

    public JPanel getSelf()
    {
        return this;
    }

    public void draw()
    {
        currentDeskIdLabel = new JLabel("Check In Desk: "+ deskModel.getId());
        currentDeskIdLabel.setFont(guiSettings.LabelFont);
        currentDeskIdLabel.setForeground(guiSettings.LabelColor);

        currentPsngrLabel = new JLabel("Current Passenger: "+ deskModel.getPassenger().getFullName());
        currentPsngrLabel.setFont(guiSettings.LabelFont);
        currentPsngrLabel.setForeground(guiSettings.LabelColor);

        currentDeskStatusLabel = new JLabel("Desk Status: "+ deskModel.getStatus());
        currentDeskStatusLabel.setFont(guiSettings.LabelFont);
        currentDeskStatusLabel.setForeground(guiSettings.LabelColor);

        add(currentDeskIdLabel);
        add(currentPsngrLabel);
        add(currentDeskStatusLabel);
    }

    public void update(Desk desk)
    {
        this.deskModel = desk;
    }
}
