package model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class tickRate {

    private ArrayList<Vehicles> vehicles = new ArrayList<>();

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Vehicles vehicle : vehicles) {
                vehicle.move();
            }
        }
    });

    public tickRate (ArrayList<Vehicles> vehicles) {
        this.vehicles = vehicles;
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

}
