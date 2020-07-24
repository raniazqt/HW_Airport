package com.hw.airport.GUI_S2;
import java.util.Observer;

import com.hw.airport.model.Desk;
import com.hw.airport.service.GUISvc;

public interface GUIElement<T>{
    T getSelf();

    void draw();
    void update(Object targetObj);

	void refreshGUI(Object arg);
}
