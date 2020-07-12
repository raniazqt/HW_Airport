package com.hw.airport.GUI_S2;

import com.hw.airport.config.PassengerPanelSettings;
import com.hw.airport.model.Booking;
import com.hw.airport.service.GUISvc;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PassengerPanel extends JPanel implements GUIElement<JPanel>
{
    private PassengerPanelSettings guiSettings;
    private JList<String> passengerJList;
    private List<Booking> passengersModel;

    public PassengerPanel(PassengerPanelSettings guiSettings)
    {
        this.guiSettings = guiSettings;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public JPanel getSelf()
    {
        return this;
    }

    @Override
    public void draw()
    {
        String[] passengerLabels = new String[passengersModel.size()];
        for(int i = 0; i < passengerLabels.length; i++)
        {
            passengerLabels[i] = passengersModel.get(i).getFullName() + " " +
            passengersModel.get(i).getRefCode() + " " + passengersModel.get(i).getFlightCode() +" "+
            passengersModel.get(i).getTotalBaggageWeight() + " " + passengersModel.get(i).getTotalBaggageVolume() + " ";
        }

        passengerJList = new JList<>(passengerLabels);
        this.passengerJList.setBorder(guiSettings.BorderType);
        this.passengerJList.setBackground(guiSettings.BackGroundColor);
        this.passengerJList.setFont(guiSettings.LabelFont);
        this.passengerJList.setForeground(guiSettings.LabelColor);
        JScrollPane scrollPane = new JScrollPane(passengerJList);
        scrollPane.setBorder(guiSettings.BorderType);
        scrollPane.setBackground(guiSettings.LabelColor);
        add(scrollPane);
    }

    @Override
    public void update(GUISvc guiDataSvc)
    {
        passengersModel = guiDataSvc.getQueuePassengersList();
    }
}
