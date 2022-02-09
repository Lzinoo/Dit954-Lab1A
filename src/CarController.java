import javax.swing.*;
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
    ArrayList<Cars> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Scania());
        cc.cars.add(new Saab95());

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
            for (Cars car : cars) {
                wallDetection(car);
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    //Detects if the car hits or goes past the wall
    void wallDetection(Cars car){
        double currentX,currentY;
        currentX = car.getX();
        currentY = car.getY();
        int bottomBorder = frame.drawPanel.getHeight();// todo: minus height of car
        int rightBorder  = frame.getWidth(); // todo: minus width of car
        if(currentX<0 || currentX>rightBorder)
            reverseDirection(car);
        else if (currentY<0 || currentY>bottomBorder)
            reverseDirection(car);

        car.move();
    }

    //Reverse the direction of the car
    void reverseDirection(Cars car){
        switch(car.getDir()){
            case NORTH -> car.setDir(Cars.direction.SOUTH);
            case EAST -> car.setDir(Cars.direction.WEST);
            case WEST -> car.setDir(Cars.direction.EAST);
            case SOUTH -> car.setDir(Cars.direction.NORTH);
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Cars car : cars) {
            car.gas(gas);
        }
    }

    // Calls the brake method for each car once
    void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Cars car : cars){
            car.brake(brake);
        }
    }
}
