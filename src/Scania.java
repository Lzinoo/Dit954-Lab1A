import java.awt.*;

/**
 * Scania class
 */
public class Scania extends Trucks {

    private double platformAngle;

    /**
     * A Scania object is a subtype of Cars - Has 2 doors, is the color White, has 90 engine power
     * , has a trailer with default angle 0, and engine is off by default.
     */
    public Scania() {
        super(2, 90, Color.white, "Scania");
        platformAngle = 0;
        stopEngine();
    }

    /**
     * Gives the current angle of the platform
     * @return returns the value of platformAngle;
     */
    public double getPlatformAngle() {
        return platformAngle;
    }

    /**
     * Checks so that the platform is not up then passes amount to the regular gas method.
     * @param amount The increase in speed from 0 (inclusive) to 1 (inclusive).
     */
    @Override
    public void gas(double amount) {
        if (platformAngle == 0) {
            super.gas(amount);
        }
    }

    /**
     * First checks if the Scania is moving and if so it will set the angle of the platform to 0
     * If the truck is not moving it will increase the angle to a maximum of 70.
     * @param amount The increase in angle from 0 (exclusive) to 1 (inclusive)
     */
    public void increaseAngle(double amount) {
        if (getCurrentSpeed() == 0) {
            if (amount > 0 && amount <= 1 && platformAngle + amount <= 70)
                platformAngle += amount;
            else
                platformAngle = 70;
        } else
            platformAngle = 0;
    }

    /**
     * Decreases the angle of the platform. Can still be called when the truck is moving,
     * even though it should never be above 0 when moving.
     * @param amount The decrease in angle from 0 (exclusive) to 1 (inclusive)
     */
    public void decreaseAngle(double amount) {
        if (amount > 0 && amount <= 1 && platformAngle - amount >= 0)
            platformAngle -= amount;
        else
            platformAngle = 0;
    }
}
