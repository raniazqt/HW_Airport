package com.hw.airport.GUI;

import com.hw.airport.config.AirportGuiSettings;
import com.hw.airport.config.EndOfSimulationFrameSettings;
import com.hw.airport.service.ReportSvc;

import javax.swing.*;

public class EndOfSimulationFrame extends JFrame implements GUIElement {

    private EndOfSimulationFrameSettings frameSettings;
    private ReportSvc reportSvc;

    public EndOfSimulationFrame(AirportGuiSettings guiSettings)
    {
        frameSettings = guiSettings.EndOfSimulationFrameSettings;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(frameSettings.getTitle());
        setSize(frameSettings.getWidth(), frameSettings.getHeight());
        System.out.println("WIDTH: " + frameSettings.getWidth() + " HEIGHT: " + frameSettings.getHeight());
    }

    @Override
    public JFrame getSelf() {
        return this;
    }

    @Override
    public void draw() {
        setLayout(frameSettings.componentSettings.Layout);
        setFont(frameSettings.componentSettings.LabelFont);
        setBackground(frameSettings.componentSettings.BackGroundColor);
        setForeground(frameSettings.componentSettings.LabelColor);

        JButton genRprtBtn = new JButton("Generate Report");
        genRprtBtn.addActionListener(actionEvent -> {
            reportSvc.getFlightReport();
            reportSvc.getFailPassengerReport();
            reportSvc.getSuccPassengerReport();
        });

        JLabel spaceLabel = new JLabel();
        add(spaceLabel);
        add(genRprtBtn);
    }

    @Override
    public void init(Object targetObj) {
        if(targetObj instanceof ReportSvc)
        {
            reportSvc = (ReportSvc) targetObj;
        }
    }

    @Override
    public void refresh(Object arg) {

    }
}
