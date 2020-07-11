package com.hw.airport.GUI_S2;

public interface GUIElement<T> {
    T getSelf();

    void draw();
    void update();
}
