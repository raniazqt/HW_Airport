package com.hw.airport.observer;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedObservable implements Observable {
    private final List<Observer> observers;
    private boolean changed;

    public SynchronizedObservable() {
        observers = new ArrayList<>();
        changed = false;
    }

    @Override
    public synchronized List<Observer> getObservers() {
        return observers;
    }

    @Override
    public synchronized int countObservers() {
        return observers.size();
    }

    @Override
    public synchronized void registerObserver(Observer o) {
        if(!observers.contains(o))
            observers.add(o);
    }

    @Override
    public synchronized void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Object args) {
        Object[] observableLocal;
        synchronized (this)
        {
            if (!changed)
                return;

            observableLocal = observers.toArray();
            clearChanged();
        }

        for(Object o : observableLocal) {
            ((Observer)o).onNotify(args);
        }
    }

    public void notifyObservers()
    {
        Object[] observableLocal;
        synchronized (this)
        {
            if (!changed)
                return;

            observableLocal = observers.toArray();
            clearChanged();
        }

        for(Object o : observableLocal) {
            ((Observer)o).onNotify(null);
        }
    }

    @Override
    public synchronized void clearObservers() {
        observers.clear();
    }

    public synchronized void setChanged() {
        changed = true;
    }

    public synchronized void clearChanged() {
        changed = false;
    }

    public synchronized boolean hasChanged() {
        return changed;
    }

}
