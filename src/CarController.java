import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicles> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240(0,0));
        cc.cars.add(new Scania(0, 100));
        cc.cars.add(new Saab95(0, 200));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicles car : cars) {
                wallDetection(car);
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(cars.indexOf(car),x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    //Detects if the car hits or goes past the wall
    private void wallDetection(Vehicles car){
        int imageHeight = frame.drawPanel.carImage[0].getHeight();
        int imageWidth = frame.drawPanel.carImage[0].getWidth();
        int bottomBorder = frame.drawPanel.getHeight();
        int rightBorder  = frame.getWidth();

        double currentX,currentY;
        currentX = car.getX();
        currentY = car.getY();

        if(currentX<0 || currentX + imageWidth >rightBorder)
            reverseDirection(car);
        else if (currentY<0 || currentY + imageHeight >bottomBorder)
            reverseDirection(car);

        car.move();
    }

    //Reverse the direction of the car
    private void reverseDirection(Vehicles car){
        switch(car.getDir()){
            case NORTH -> car.setDir(Vehicles.direction.SOUTH);
            case EAST -> car.setDir(Vehicles.direction.WEST);
            case WEST -> car.setDir(Vehicles.direction.EAST);
            case SOUTH -> car.setDir(Vehicles.direction.NORTH);
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicles car : cars) {
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
        for(Vehicles car : cars){
            if(car instanceof Saab95)
                ((Saab95) car).setTurboOn();
        }
    }

    // Calls setTurboOff only for Saabs in cars.
    void turboOff(){
        for(Vehicles car : cars){
            if(car instanceof Saab95)
                ((Saab95) car).setTurboOff();
        }
    }

    // Calls increaseAngle only for Scania in cars.
    void increaseAngle(int amount){
        double increaseAmount = ((double) amount) / 100;
        for(Vehicles car : cars){
            if(car instanceof Scania)
                ((Scania) car).increaseAngle(increaseAmount);
        }
    }

    //Calls decreaseAngle only for Scania in cars.
    void decreaseAngle(int amount){
        double decreaseAmount = ((double) amount) / 100;
        for(Vehicles car : cars){
            if(car instanceof Scania)
             ((Scania) car).decreaseAngle(decreaseAmount);
        }
    }
}
