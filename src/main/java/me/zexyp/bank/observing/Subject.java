package me.zexyp.bank.observing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface Subject {
    List<Observer> observers = new LinkedList<>();
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
}
