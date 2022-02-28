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
    // The timer is started with an listener (see below) that executes the statements
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

    public Ticker(ArrayList<Vehicles> vehicles, ArrayList<Observer> observers) {
        this.vehicles = vehicles;
        this.subscribers = observers;
        timer.start();
    }

    public void updateVehicles (ArrayList<Vehicles> vehicles) {
        this.vehicles = vehicles;
    }

    public void addListener (ActionListener al) {
        timer.addActionListener(al);
    }

    public void start() {
        timer.start();
    }


    @Override
    public void notifyObservers() {
        for (Observer observer : subscribers)
            observer.update();
    }

    @Override
    public void addObserver(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        subscribers.remove(observer);
    }
}
