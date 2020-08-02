package com.hw.airport.config;

import javax.swing.border.Border;
import java.awt.*;

public class PassengerPanelSettings 
{
    public LayoutManager Layout;
    public Color BackGroundColor;
    public Color LabelColor;
    public Font LabelFont;
    public Border BorderType;

    public PassengerPanelSettings(LayoutManager layout, Color backGroundColor,
                                  Color labelColor, Font labelFont, Border borderType)
    {
        this.Layout = layout;
        this.BackGroundColor = backGroundColor;
        this.LabelColor = labelColor;
        this.LabelFont = labelFont;
        this.BorderType = borderType;
    }
}
