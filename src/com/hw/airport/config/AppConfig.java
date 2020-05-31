package com.hw.airport.config;

public class AppConfig {

    private GUISettings guiSettings;

    private AppConfig()
    {
        //TODO: temp until we use files for all settings.
        guiSettings = new GUISettings(800, 600, "Airport Status Screen");
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
