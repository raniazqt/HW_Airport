package com.hw.airport.observer;

import java.util.List;

public interface Observable {
    List<Observer> getObservers();
    int countObservers();

    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyAll(Object args);
    void clearObservers();
}
