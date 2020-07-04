package com.hw.airport.GUI_S2;

import com.hw.airport.config.GUISettings;

import javax.swing.*;
import java.util.List;

public class SimToolBar extends JToolBar {
    public SimToolBar(GUISettings guiSettings) {
        setLayout(guiSettings.getToolBarsLayout());
        List<JButton> labelsToAdd = guiSettings.getSimToolBarButtons();

        for (JButton button: labelsToAdd) {
            add(button);
        }
    }
}
