package com.hw.airport.GUI_S2;

import com.hw.airport.config.GUISettings;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SimToolBar extends JToolBar {
    public SimToolBar(GUISettings guiSettings) {

        setPreferredSize(new Dimension(39,39));
        setLayout(guiSettings.getToolBarsLayout());
        List<JButton> labelsToAdd = guiSettings.getSimToolBarButtons();

        for (JButton button: labelsToAdd) {
            add(button);
        }
    }
}
