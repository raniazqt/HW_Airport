package com.hw.airport.config;

import javax.swing.border.Border;
import java.awt.*;

public class UserConfigFrameSettings extends AirportMonitorFrameSettings {
    public SimulationToolBarSettings componentSettings;

    public UserConfigFrameSettings(int mainScrWidth, int mainScrHeight, int exitOp, String mainScrTitle, LayoutManager layoutManager,
                                   Color backGroundColor, Color labelColor, Font labelFont, Border borderType) {
        super(mainScrWidth, mainScrHeight, exitOp, mainScrTitle);
        componentSettings = new SimulationToolBarSettings(layoutManager, backGroundColor, labelColor, labelFont, borderType);
    }
}
