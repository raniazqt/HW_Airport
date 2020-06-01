package com.hw.airport.config;

import javax.swing.*;

public class MasterFrameSettings {
    private int mainScreenWidth;
    private int mainScreenHeight;
    private int exitOperation;

    private String mainScreenTitle;

    public MasterFrameSettings(int mainScrWidth, int mainScrHeight, int exitOp, String mainScrTitle) {
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
