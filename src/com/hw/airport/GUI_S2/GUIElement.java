package com.hw.airport.GUI_S2;

import java.awt.*;

public interface GUIElement
{
    Component getSelf();

    void draw();
    void init(Object targetObj);
	void refresh(Object arg);
}
