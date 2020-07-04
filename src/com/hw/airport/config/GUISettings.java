package com.hw.airport.config;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GUISettings {

    private int mainScreenWidth;
    private int mainScreenHeight;
    private String mainScreenTitle;

    //Sim tool bar.
    private List<JButton> simToolBarButtons;
    private List<JLabel> settingsToolBarLabels;
    private FlowLayout toolBarsLayout;

    public GUISettings(int mainScrWidth, int mainScrHeight, String mainScrTitle,
                       List<JButton> simToolBarButtons, List<JLabel> settingsToolBarLabels, FlowLayout toolBarsLayout) {

        this.mainScreenWidth = mainScrWidth;
        this.mainScreenHeight = mainScrHeight;
        this.mainScreenTitle = mainScrTitle;
        this.simToolBarButtons = simToolBarButtons;
        this.settingsToolBarLabels = settingsToolBarLabels;
        this.toolBarsLayout = toolBarsLayout;
    }

    public String getMainScreenTitle() { return this.mainScreenTitle;}

    public int getMainScreenWidth() { return mainScreenWidth; }

    public int getMainScreenHeight() { return mainScreenHeight; }

    public List<JButton> getSimToolBarButtons() { return simToolBarButtons; }

    public List<JLabel> getSettingsToolBarLabels() { return settingsToolBarLabels; }

    public FlowLayout getToolBarsLayout() { return toolBarsLayout; }
}
