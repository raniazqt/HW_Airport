package com.hw.airport.config;

public class FrameSettings
{
    private int mainScreenWidth;
    private int mainScreenHeight;
    private int exitOperation;

    private String mainScreenTitle;

    public FrameSettings(int mainScrWidth, int mainScrHeight, int exitOp, String mainScrTitle) {
        this.mainScreenWidth = mainScrWidth;
        this.mainScreenHeight = mainScrHeight;
        this.mainScreenTitle = mainScrTitle;
        this.exitOperation = exitOp;
    }

    public String getMainScreenTitle() { return this.mainScreenTitle;}

    public int getMainScreenWidth() { return mainScreenWidth; }

    public int getMainScreenHeight() { return mainScreenHeight; }

    public int getExitOperation() { return exitOperation; }
}
