package com.hw.airport.GUI_S2;

import com.hw.airport.config.ActiveFlightPanelSettings;
import com.hw.airport.config.CheckInDeskPanelSettings;
import com.hw.airport.model.ActiveFlight;

import javax.swing.*;

public class FlightPanel extends JPanel
{
    private ActiveFlightPanelSettings guiSettings;

    private JLabel flightCdLabel;
    private JLabel boardedCntlabel;
    private JLabel totalVolumeLabel;
    private JLabel totalWeightLabel;
    private JLabel totalChargeCollectedLabel;

    private ActiveFlight flightModel;

    public FlightPanel(ActiveFlightPanelSettings guiSettings)
    {
        this.guiSettings = guiSettings;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setFont(guiSettings.LabelFont);
        this.setBackground(guiSettings.BackGroundColor);
        this.setBorder(guiSettings.BorderType);
        this.setSize(guiSettings.ActiveFlightFrameSize);
    }

    public void draw()
    {
        flightCdLabel = new JLabel("CD: "+flightModel.getFlightCd());
        flightCdLabel.setFont(guiSettings.LabelFont);
        flightCdLabel.setForeground(guiSettings.LabelColor);

        boardedCntlabel = new JLabel("Total Boarded: " + flightModel.getBoardedPsngrCnt());
        boardedCntlabel.setFont(guiSettings.LabelFont);
        boardedCntlabel.setForeground(guiSettings.LabelColor);

        totalVolumeLabel = new JLabel("Total Volume: " + flightModel.getTotalVolume());
        totalVolumeLabel.setFont(guiSettings.LabelFont);
        totalVolumeLabel.setForeground(guiSettings.LabelColor);

        totalWeightLabel = new JLabel("Total Weight: " + flightModel.getTotalWeight());
        totalWeightLabel.setFont(guiSettings.LabelFont);
        totalWeightLabel.setForeground(guiSettings.LabelColor);

        totalChargeCollectedLabel = new JLabel("Total Charge: " + flightModel.getXtraChargeCollected());
        totalChargeCollectedLabel.setFont(guiSettings.LabelFont);
        totalChargeCollectedLabel.setForeground(guiSettings.LabelColor);

        add(flightCdLabel);
        add(boardedCntlabel);
        add(totalVolumeLabel);
        add(totalWeightLabel);
        add(totalChargeCollectedLabel);
    }

    public void update(ActiveFlight flightModel)
    {
        this.flightModel = flightModel;
    }
}
