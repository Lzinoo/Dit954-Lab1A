package model;

import application.Observer;

public interface Observable {

    /**
     * A method used to notify an observer.
     */
    void notifyObservers();

    /**
     * A method that adds an observer to a list of observers.
     * @param observer to be added to the list.
     */
    void addObserver(Observer observer);

    /**
     * A method that removes an observer from a list of observers.
     * @param observer to be removed from the list.
     */
    void removeObserver(Observer observer);
}
