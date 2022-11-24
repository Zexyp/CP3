package me.zexyp.bank.observing;

import java.util.List;

public interface Subject {
    List<Observer> observers = null;
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Object inNameOf, Object args);
}
