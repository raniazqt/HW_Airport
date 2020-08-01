package com.hw.airport.observer;

public abstract class AbstractObserver implements Observer {
    @Override
    public abstract void onNotify(Object args);
}
