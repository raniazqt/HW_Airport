package com.hw.airport.config;

import javax.swing.border.Border;
import java.awt.*;

public class SimulationToolBarSettings
{
    public LayoutManager Layout;
    public Color BackGroundColor;
    public Color LabelColor;
    public Font LabelFont;
    public Border BorderType;

    public SimulationToolBarSettings(LayoutManager layoutManager,
                                     Color backGroundColor, Color labelColor, Font labelFont, Border borderType)
    {
        this.Layout = layoutManager;
        this.BackGroundColor = backGroundColor;
        this.LabelColor = labelColor;
        this.LabelFont = labelFont;
        this.BorderType = borderType;
    }
}