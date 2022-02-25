package model;

import controller.Observer;

public interface Observable {

    void notifyObservers();

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);
}
