package controller;

import model.*;
import model.factory.VehiclesFactory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:


    // The frame that represents this instance View of the MVC pattern
    //controller.CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicles> cars = new ArrayList<>();
    ArrayList<Scania> scaniaCars = new ArrayList<>();
    ArrayList<Saab95> saabCars = new ArrayList<>();
    VehiclesFactory vehiclesFactory = new VehiclesFactory();
    ArrayList<Point> carPoints = new ArrayList<>();
    //methods:



    //Reverse the direction of the car
    public void reverseDirection(Vehicles car){
        car.turnLeft();
        car.turnLeft();
    }

    public void addCars(Vehicles vehicle) {
        cars.add(vehicle);
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicles car : cars) {
            if (car.getState() == Movable.State.INACTIVE);
            else
                car.gas(gas);
        }
    }

    // Calls the brake method for each car once
    void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicles car : cars){
            car.brake(brake);
        }
    }

    // Calls the startEngine method for each car once
    void startAllEngines() {
        for (Vehicles car : cars) {
            car.startEngine();
        }
    }

    // Calls the stopEngine method for each car once
    void stopAllEngines() {
        for (Vehicles car : cars) {
            car.stopEngine();
        }
    }

    // Calls setTurboOn only for Saabs in cars.
    void turboOn(){
        for(Saab95 car : saabCars){
            car.setTurboOn();
        }
    }

    // Calls setTurboOff only for Saabs in cars.
    void turboOff(){
        for(Saab95 car : saabCars){
             car.setTurboOff();
        }
    }

    // Calls increaseAngle only for model.Scania vehicles.
    void increaseAngle(int amount){
        double increaseAmount = ((double) amount) / 100;
        for(Scania car : scaniaCars){
            car.raisePlatform(increaseAmount);
        }
    }

    //Calls decreaseAngle only for model.Scania vehicles.
    void decreaseAngle(int amount){
        double decreaseAmount = ((double) amount) / 100;
        for(Scania car : scaniaCars){
            car.lowerPlatform(decreaseAmount);
        }
    }

    //Creates a popup asking what car the user wants to create. The response returns an int that is passed to
    //model.factory.VehiclesFactory if there are less than 10 cars currently.
    public void createCar() {
        if (cars.size() != 10) {

            String[] options = new String[]{"model.Volvo240", "model.Saab95", "model.Scania", "Random"};
            int response = JOptionPane.showOptionDialog(null, "What car do you want to add?", "Add a Car",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);

            Random random = new Random();

            if (response == 3) {
                response = random.nextInt(3);
            }

            int size = cars.size();
            int yPos = 60 * size;

            if ((cars.size() < 10) && (response != -1)) {
                Vehicles car = vehiclesFactory.createVehicle(response, 0, yPos);
                cars.add(car);
                carPoints.add(new Point());
            }
        }
    }

    //When called removes a car if there is more than 0 cars currently
    public void removeCar() {
        if (cars.size() > 0) {
            cars.remove(cars.get(cars.size() - 1));
            carPoints.remove(carPoints.get(carPoints.size() - 1));
        }
    }
}
