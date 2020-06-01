package com.hw.airport.config;

import javax.swing.*;

public class AppConfig {

    private GUISettings guiSettings;

    private AppConfig()
    {
        //TODO: temp until we use files for all settings.
        guiSettings = new GUISettings(new MasterFrameSettings(800, 600,
                WindowConstants.EXIT_ON_CLOSE, "Airport Status Screen"),
                null, null, null, null);
    }

    private static AppConfig appConfig;
    public static AppConfig getInstance() {
        if(appConfig == null) {
            appConfig = new AppConfig();
        }

        return appConfig;
    }

    public void setGuiSettings(GUISettings newGuiSettings) { guiSettings = newGuiSettings; }

    public GUISettings getGuiSettings() { return guiSettings; }
}
