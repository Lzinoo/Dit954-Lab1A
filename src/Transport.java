
import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Transport class
 */
public class Transport extends Trucks {

    private boolean platformIsDown;
    private Deque<Cars> loadedCars;
    private int carCapacity;

    /**
     * A Transport object is a subtype of cars that has 2 doors, an enginePower of 90.
     * The platform is up by default. The Transport object can load and transport other
     * objects of type cars except for type Transport.
     *
     * @param maxCapacity The maximum capacity of the transport vehicle
     * @param x_pos The position on the x-axis
     * @param y_pos The position on the y-axis
     */
    public Transport (int maxCapacity, int x_pos, int y_pos) {
        super(2, new Engine(90), Color.white, "Transporter", x_pos, y_pos);
        platformIsDown = false;
        stopEngine();
        carCapacity = maxCapacity;
        loadedCars = new ArrayDeque<Cars>();
    }
    /**
     * A Transport object is a subtype of cars that has 2 doors, an enginePower of 90.
     * The platform is up by default. The Transport object can load and transport other
     * objects of type cars except for type Transport. Without any parameters the
     * transport is placed at position (0,0).
     */
    public Transport (int maxCapacity) {
        super(2, new Engine(90), Color.white, "Transporter", 0, 0);
        platformIsDown = false;
        stopEngine();
        carCapacity = maxCapacity;
        loadedCars = new ArrayDeque<Cars>();
    }

    /**
     * A method that sets the platform to the down position. Only works if the Transport
     * has a speed of 0.
     */
    @Override
    public void lowerPlatform() {
        if (getCurrentSpeed() == 0)
            platformIsDown = true;
        else
            platformIsDown = false;
    }

    /**
     * Raises the platform, sets platformIsDown to false.
     */
    @Override
    public void raisePlatform() {
        platformIsDown = false;
    }

    /** Transport object specific angle - is either 0 degrees or 70.
     * @return 0 if platform is down, else 70.
     */
    @Override
    public double getPlatformAngle(){
        return platformIsDown ? 0 : 70;
    }

    /**
     * First checks that the platform is down and so that the car that is being loaded on is not
     * an object of the subclass Transport.
     * Then based on the direction of the Transport checks that the car is behind and not too far on either side
     * of the transport to allow it to be loaded on.
     * @param carInput Any vehicle of class Cars, except Transport, that will be loaded on to the Transport vehicle
     */
    public void mountCar(Cars carInput) {
        if (platformIsDown && loadedCars.size() < carCapacity) {
            carInput.changeState(State.INACTIVE);
            switch (this.getDir()) {
                case NORTH:
                    if (this.getY() - carInput.getY() <= 10
                            && Math.abs(this.getX() - carInput.getX()) <= 5) {
                        loadedCars.add(carInput);
                        updatePosition();
                    }
                    break;
                case SOUTH:
                    if (carInput.getY() - this.getY() <= 10
                            && Math.abs(this.getX() - carInput.getX()) <= 5) {
                        loadedCars.add(carInput);
                        updatePosition();
                    }
                    break;
                case EAST:
                    if (this.getX() - carInput.getX() <= 10
                            && Math.abs(this.getY() - carInput.getY()) <= 5) {
                        loadedCars.add(carInput);
                        updatePosition();
                    }
                    break;
                case WEST:
                    if (carInput.getX() - this.getX() <= 10
                            && Math.abs(this.getY() - carInput.getY()) <= 5) {
                        loadedCars.add(carInput);
                        updatePosition();
                    }
                    break;
            }
        }
    }

    /**
     * Removes the last added car from the Transport and returns that as a new car.
     * If the platform is not down will return null instead. Maybe change this to throw an error and use
     * catch instead.
     * @return returns the car on the top of the stack, meaning the car that was last mounted to the transport.
     */
    public Vehicles dismountCar() {
        Vehicles unloadedCar;
        if (platformIsDown) {
            unloadedCar = loadedCars.pop();
            unloadedCar.changeState(State.ACTIVE);
            unloadedCar.setDir(this.getDir());
            switch (this.getDir()) {
                case NORTH:
                    unloadedCar.setX(this.getX());
                    unloadedCar.setY(this.getY() - 5);
                    break;
                case SOUTH:
                    unloadedCar.setX(this.getX());
                    unloadedCar.setY(this.getY() + 5);
                    break;
                case EAST:
                    unloadedCar.setX(this.getX() - 5);
                    unloadedCar.setY(this.getY());
                    break;
                case WEST:
                    unloadedCar.setX(this.getX() + 5);
                    unloadedCar.setY(this.getY());
                    break;
            }
            return unloadedCar;
        }
        else
            return null;
    }

    /**
     * Only works if the platform is up and updates the positions of the loaded cars
     */
    @Override
    public void move() {
        if (!platformIsDown) {
            super.move();
            updatePosition();
        }
    }

    /**
     * Increase currentSpeed with given amount. Does not work unless the platform is up.
     *
     * @param amount The increase in speed from 0 (inclusive) to 1 (inclusive).
     */
    @Override
    public void gas(double amount) {
        if (!platformIsDown)
            super.gas(amount);
    }

    /**
     * Gets the number of cars currently mounted on the transport
     * @return The number of cars currently in the transport
     */
    public int getNumberOfMountedCars() {
        return loadedCars.size();
    }

    /**
     * Updates the positions of the loaded cars to the match the Transport
     */
    public void updatePosition() {
        for (Vehicles car : loadedCars) {
            car.setX(this.getX());
            car.setY(this.getY());
            car.setDir(this.getDir());
        }
    }
}