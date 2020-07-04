package com.hw.airport.GUI_S2;

import com.hw.airport.config.GUISettings;

import javax.swing.*;
import java.awt.*;

public class PassengerPanel extends JPanel {
    public PassengerPanel(GUISettings guiSettings) {
        JScrollPane scrollPane = new JScrollPane(guiSettings.getPsngrQueueDisplay());

        scrollPane.setMinimumSize(new Dimension(200, 100));
        add(new JScrollPane(guiSettings.getPsngrQueueDisplay()));

        setPreferredSize(new Dimension(500, 500));
    }
}
