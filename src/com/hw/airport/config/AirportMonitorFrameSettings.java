package com.hw.airport.config;

public class AirportMonitorFrameSettings
{
    private int mainScreenWidth;
    private int mainScreenHeight;
    private int exitOperation;

    private String mainScreenTitle;

    public AirportMonitorFrameSettings(int mainScrWidth, int mainScrHeight, int exitOp, String mainScrTitle) {
        this.mainScreenWidth = mainScrWidth;
        this.mainScreenHeight = mainScrHeight;
        this.mainScreenTitle = mainScrTitle;
        this.exitOperation = exitOp;
    }

    public String getTitle() { return this.mainScreenTitle;}

    public int getWidth() { return mainScreenWidth; }

    public int getHeight() { return mainScreenHeight; }

    public int getExitOperation() { return exitOperation; }
}
