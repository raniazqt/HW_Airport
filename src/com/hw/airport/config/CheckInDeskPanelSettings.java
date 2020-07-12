package com.hw.airport.config;

import javax.swing.border.Border;
import java.awt.*;

public class CheckInDeskPanelSettings
{
    public LayoutManager Layout;
    public Color BackGroundColor;
    public Color LabelColor;
    public Font LabelFont;
    public Border BorderType;
    public Dimension DeskFrameSize;

    public CheckInDeskPanelSettings(LayoutManager layout, Color backGroundColor,
                                    Color labelColor, Font labelFont, Border borderType, Dimension deskFrameSize)
    {
        this.Layout = layout;
        this.BackGroundColor = backGroundColor;
        this.LabelColor = labelColor;
        this.LabelFont = labelFont;
        this.BorderType = borderType;
        this.DeskFrameSize = deskFrameSize;
    }

}
