package model;

import application.Observer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ticker implements Observable{

    private ArrayList<Observer> subscribers;

    private ArrayList<Vehicles> vehicles;

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Vehicles car : vehicles) {
                switch(car.getState()){
                    case ACTIVE: {
                        int carIndex = vehicles.indexOf(car);
                        car.wallDetection(60, 100,
                                560, 800);
                        car.move();
                    }
                    case INACTIVE: {}
                }
            }
            notifyObservers();
        }
    });

    /**
     * A ticker contains a Timer object that updates the a list of vehicles 20 times a second
     * and notifies a list of observers that an update has happened
     *
     * @param vehicles A list of vehicles that will be moved and be checked for wallDetection
     * @param observers A list of observers that will be notified when the timer is called.
     */
    public Ticker(ArrayList<Vehicles> vehicles, ArrayList<Observer> observers) {
        this.vehicles = vehicles;
        this.subscribers = observers;
        timer.start();
    }

    //Updates the list of vehicles
    public void updateVehicles (ArrayList<Vehicles> vehicles) {
        this.vehicles = vehicles;
    }

    //adds a new listener to the timer
    public void addListener (ActionListener al) {
        timer.addActionListener(al);
    }

    //starts the timer
    public void start() {
        timer.start();
    }

    //stops the timer
    public void stop() {
        timer.stop();
    }


    //Sends an event that notifies all observers
    @Override
    public void notifyObservers() {
        for (Observer observer : subscribers)
            observer.update();
    }

    //Adds a new observer
    @Override
    public void addObserver(Observer observer) {
        subscribers.add(observer);
    }

    //Removes an observer
    @Override
    public void removeObserver(Observer observer) {
        subscribers.remove(observer);
    }
}
