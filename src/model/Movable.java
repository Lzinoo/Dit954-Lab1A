package model;

/**
 * Different methods that describe to move the cars
 */
public interface Movable {
    /**
     * Method called to move the car.
     */
    void move();

    /**
     * Method called to rotate the car left.
     */
    void turnLeft();

    /**
     * Method called to rotate the car right.
     */
    void turnRight();

    /**
     * The state of a movable.
     */
    enum State{
        ACTIVE, INACTIVE
    }
}
