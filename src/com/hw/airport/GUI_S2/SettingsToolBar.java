package com.hw.airport.GUI_S2;

import com.hw.airport.config.GUISettings;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SettingsToolBar extends JToolBar {
    public SettingsToolBar(GUISettings guiSettings) {
        setLayout(guiSettings.getToolBarsLayout());
        setPreferredSize(new Dimension(40,40));

        List<JLabel> labelsToAdd = guiSettings.getSettingsToolBarLabels();

        for (JLabel label: labelsToAdd) {
            add(label, guiSettings.getToolBarsLayout());
        }
    }
}
