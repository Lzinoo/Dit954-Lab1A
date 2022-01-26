import java.awt.*;

/**
 * A class that creates a car object
 */
public class Cars implements Movable {

    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name


    private double x; // The car's position in the x-axis
    private double y; // The car's position in the y-axis
    private direction dir; // The direction the car is moving in

    public enum direction {
        NORTH, SOUTH, WEST, EAST
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public direction getDir() {
        return dir;
    }

    public void setDir(direction dir) {
        this.dir = dir;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }


    @Override
    public void move() {
    switch (dir) {
        case NORTH -> setY(getY() - getCurrentSpeed());
        case SOUTH -> setY(getY() + getCurrentSpeed());
        case EAST -> setX(getX() + getCurrentSpeed());
        case WEST -> setX(getX() - getCurrentSpeed());
    }

    }

    @Override
    public void turnLeft() {
        switch (dir) {
            case NORTH -> setDir(direction.WEST);
            case SOUTH -> setDir(direction.EAST);
            case EAST -> setDir(direction.NORTH);
            case WEST -> setDir(direction.SOUTH);
        }
    }

    @Override
    public void turnRight() {
        switch (dir) {
            case NORTH -> setDir(direction.EAST);
            case SOUTH -> setDir(direction.WEST);
            case EAST -> setDir(direction.SOUTH);
            case WEST -> setDir(direction.NORTH);
        }

    }

}
