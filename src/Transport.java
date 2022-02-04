
import java.awt.*;
import java.util.Deque;

/**
 * Transport class
 */
public class Transport extends Cars {

    private boolean platformIsDown;
    private Deque<Cars> loadedCars;
    private int carCapacity;

    /**
     * A Transport object is a subtype of cars that has 2 doors, an enginePower of 90.
     * The platform is up by default. The Transport object can load and transport other
     * objects of type cars except for type Transport.
     *
     */
    public Transport (int maxCapacity) {
        super(2, 90, Color.white, "Transporter");
        platformIsDown = false;
        stopEngine();
        carCapacity = maxCapacity;
    }

    /**
     * A method that sets the platform to the down position. Only works if the Transport
     * has a speed of 0.
     */
    public void lowerPlatform() {
        if (getCurrentSpeed() == 0)
            platformIsDown = true;
        else
            platformIsDown = false;
    }

    /**
     * Raises the platform, sets platformIsDown to false.
     */
    public void raisePlatform() {
        platformIsDown = false;
    }

    /**
     * First checks that the platform is down and so that the car that is being loaded on is not
     * an object of the subclass Transport.
     * Then based on the direction of the Transport checks that the car is behind and not too far on either side
     * of the transport to allow it to be loaded on.
     * @param carInput Any vehicle of class Cars, except Transport, that will be loaded on to the Transport vehicle
     */
    public void mountCar(Cars carInput) {
        if (platformIsDown && carInput.getClass() != Transport.class && loadedCars.size() < carCapacity) {
            switch (this.getDir()) {
                case NORTH:
                    if (this.getY() - carInput.getY() <= 10
                            && Math.abs(this.getX() - carInput.getX()) <= 5) {
                        loadedCars.add(carInput);
                        updatePosition();
                    }
                case SOUTH:
                    if (carInput.getY() - this.getY() <= 10
                            && Math.abs(this.getX() - carInput.getX()) <= 5) {
                        loadedCars.add(carInput);
                        updatePosition();
                    }
                case EAST:
                    if (this.getX() - carInput.getX() <= 10
                            && Math.abs(this.getY() - carInput.getY()) <= 5) {
                        loadedCars.add(carInput);
                        updatePosition();
                    }
                case WEST:
                    if (carInput.getX() - this.getX() <= 10
                            && Math.abs(this.getY() - carInput.getY()) <= 5) {
                        loadedCars.add(carInput);
                        updatePosition();
                    }
            }
        }
    }

    /**
     * Removes the last added car from the Transport and returns that as a new car.
     * If the platform is not down will return null instead. Maybe change this to throw an error and use
     * catch instead.
     * @return returns the car on the top of the stack, meaning the car that was last mounted to the transport.
     */
    public Cars dismountCar() {
        Cars unloadedCar;
        if (platformIsDown) {
            unloadedCar = loadedCars.pop();
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

    public int getNumberOfMountedCars() {
        return loadedCars.size();
    }

    /**
     * Updates the positions of the loaded cars to the match the Transport
     */
    public void updatePosition() {
        for (Cars car : loadedCars) {
            car.setX(this.getX());
            car.setY(this.getY());
            car.setDir(this.getDir());
        }
    }
}