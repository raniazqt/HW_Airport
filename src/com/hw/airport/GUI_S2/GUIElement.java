package com.hw.airport.GUI_S2;
import com.hw.airport.service.GUISvc;

public interface GUIElement<T> {
    T getSelf();

    void draw();
    void update(GUISvc guiDataSvc);
}
