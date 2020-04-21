package com.hw.airport.GUI_S2;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MasterScreen extends JFrame {

    private JPanel masterContentPanel;
    private JLabel masterScreenTitle;

    public MasterScreen() {
        masterContentPanel = new JPanel();
        masterScreenTitle = new JLabel("Master Screen");
        setDefaultCloseOperation (EXIT_ON_CLOSE);

        setTitle ("Airport Status Screen");
        setSize (300, 200);

        add(masterScreenTitle);

        pack();
    }
}
