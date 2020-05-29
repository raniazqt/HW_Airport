package com.hw.airport.config;

public class GUISettings {

    private int mainScreenWidth;
    private int mainScreenHeight;
    private String mainScreenTitle;

    public GUISettings(int mainScrWidth, int mainScrHeight, String mainScrTitle) {
        this.mainScreenWidth = mainScrWidth;
        this.mainScreenHeight = mainScrHeight;
        this.mainScreenTitle = mainScrTitle;
    }

    public String getMainScreenTitle() { return this.mainScreenTitle;}

    public int getMainScreenWidth() { return mainScreenWidth; }

    public int getMainScreenHeight() { return mainScreenHeight; }
}
