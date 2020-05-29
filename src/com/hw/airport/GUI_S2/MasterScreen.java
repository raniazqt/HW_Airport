package com.hw.airport.GUI_S2;

import com.hw.airport.config.AppConfig;
import com.hw.airport.config.GUISettings;

import javax.swing.*;

public class MasterScreen extends JFrame {

    public MasterScreen() {
        GUISettings settings = AppConfig.getInstance().getGuiSettings();
        InitMainFrame(settings);
    }

    private void InitMainFrame(GUISettings guiSettings) {
        setTitle (guiSettings.getMainScreenTitle());
        setSize (guiSettings.getMainScreenWidth(), guiSettings.getMainScreenHeight());
        setDefaultCloseOperation (EXIT_ON_CLOSE);
    }
}
