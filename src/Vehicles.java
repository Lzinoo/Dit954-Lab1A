// Authors: Leyl Cumar, Adam Norberg, Elias Haqiqat
// Group 14
import java.awt.*;

/**
 * A class that creates a car object
 */
public abstract class Vehicles implements Movable {

    private int nrDoors; // Number of doors on the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Engine engine; // The vehicle's engine
    private double enginePower; // The power of the engine


    private double x; // The car's position in the x-axis
    private double y; // The car's position in the y-axis
    private direction dir; // The direction the car is moving in
    private State state;

    /**
     * The base constructor for the Car class
     *
     * When initiated the car starts at (0,0) with a speed of 0 facing North
     *
     * @param nrDoors The number of doors
     * @param color The colour of the car
     * @param modelName The name of the model of the car
     */
    public Vehicles(int nrDoors, Engine engine, Color color, String modelName, int x_pos, int y_pos){
        this.nrDoors = nrDoors;
        this.engine = engine;
        this.color = color;
        this.modelName = modelName;
        this.x = x_pos;
        this.y = y_pos;
        this.enginePower = engine.getEnginePower();

        currentSpeed = 0;
        dir = direction.NORTH;
        state = State.ACTIVE;
    }

    /**
     * A representation of direction for the car.
     * Can have the values of NORTH (up), SOUTH (down),
     * WEST (left) or EAST (right).
     */
    public enum direction {
        NORTH, SOUTH, WEST, EAST
    }

    /** Method to change the state of the vehicle object.
     * @param state The new state of the vehicle object.
     */
    public void changeState(State state){this.state = state;}

    /** Get the state of the Vehicle object.
     * @return The current state of the Vehicle object.
     */
    public State getState(){return state;}

    /**
     * Returns the current number of doors on the car.
     *
     * @return The current number of doors on the car.
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Returns the current enginePower of the car.
     *
     * @return The current enginePower of the car.
     */
    public double getEnginePower() {
        return enginePower;
    }


    /**
     * Returns the currentSpeed of the car.
     *
     * @return The currentSpeed of the car.
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Sets a new currentSpeed for the car.
     *
     * @param currentSpeed The new currentSpeed for the car.
     */
    private void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    /**
     * Returns the current color of the car.
     *
     * @return The current color of the car.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets a new given color for the car.
     *
     * @param clr The new color of the car.
     */
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * Returns the current X-axis value of the car.
     *
     * @return The current X-axis value.
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the current Y-axis value of the car.
     *
     * @return The current Y-axis value.
     */
    public double getY() {
        return y;
    }

    /**
     * Sets a new X-axis value for the car.
     *
     * @param x The new X-axis value.
     */
    protected void setX(double x) {
        this.x = x;
    }

    /**
     * Sets a new Y-axis value for the car.
     *
     * @param y The new Y-axis value.
     */
    protected void setY(double y) {
        this.y = y;
    }

    /**
     * Returns the current direction of the car.
     *
     * @return Current direction of the car.
     */
    public direction getDir() {
        return dir;
    }

    /**
     * Sets a new direction for the car.
     *
     * @param dir The new direction of the car.
     */
    protected void setDir(direction dir) {
        this.dir = dir;
    }

    /**
     * A method to set currentSpeed to 0.1
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * A method to set currentSpeed to 0.
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * A method to increase the currentSpeed of the car.
     *
     * @param amount How much the speed should be increased.
     */
    private void incrementSpeed(double amount) {
        double increasedSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        if (increasedSpeed > getCurrentSpeed())
            setCurrentSpeed(increasedSpeed);
    }

    /**
     * A method to decrease the currentSpeed of the car.
     *
     * @param amount How much the speed should be decreased.
     */
    private void decrementSpeed(double amount) {
        double decreasedSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        if (decreasedSpeed < getCurrentSpeed())
            setCurrentSpeed(decreasedSpeed);
    }

    /**
     * A method used in calculating the car's currentSpeed
     */
    public double speedFactor() {
        return enginePower * 0.01;
    }

    /**
     * Method to move the car along the X or Y axis depending on the
     * current direction of the car.
     */
    @Override
    public void move() {
        switch (dir) {
            case NORTH -> setY(getY() - getCurrentSpeed());
            case SOUTH -> setY(getY() + getCurrentSpeed());
            case EAST -> setX(getX() + getCurrentSpeed());
            case WEST -> setX(getX() - getCurrentSpeed());
        }

    }

    /**
     * Method to turn the car's direction one step left.
     */
    @Override
    public void turnLeft() {
        switch (dir) {
            case NORTH -> setDir(direction.WEST);
            case SOUTH -> setDir(direction.EAST);
            case EAST -> setDir(direction.NORTH);
            case WEST -> setDir(direction.SOUTH);
        }
    }

    /**
     * Method to turn the car's direction one step right.
     */
    @Override
    public void turnRight() {
        switch (dir) {
            case NORTH -> setDir(direction.EAST);
            case SOUTH -> setDir(direction.WEST);
            case EAST -> setDir(direction.SOUTH);
            case WEST -> setDir(direction.NORTH);
        }

    }

    /**
     * Increase currentSpeed with given amount.
     *
     * @param amount The increase in speed from 0 (inclusive) to 1 (inclusive).
     */
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    /**
     * Decrease currentSpeed with given amount.
     *
     * @param amount The decrease in speed from 0 (inclusive) to 1 (inclusive).
     */
    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
    }
}
