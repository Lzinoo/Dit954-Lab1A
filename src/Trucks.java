import java.awt.*;

/**
 * A class that represents Trucks. Is a subclass of Vehicles.
 */
public abstract class Trucks extends Vehicles implements Platform{
    private int nrDoors;
    private double enginePower;
    private Color color;
    private String modelName;

    /** A truck object, has some sort of carriage (e.g. trailer).
     * @param nrDoors The number of doors
     * @param engine The engine of the truck
     * @param color The colour of the truck
     * @param modelName The name of the model of the truck
     */
    public Trucks(int nrDoors, Engine engine, Color color, String modelName, int x, int y){
        super(nrDoors,engine,color,modelName, x, y);
    }

    /** Get the angle of the platform for the Truck object.
     * @return the angle of the platform.
     */
    @Override
    public double getPlatformAngle() {
        return 0;
    }

    /**
     * Raises (if possible) the platform attached to the Truck object.
     */
    @Override
    public void raisePlatform() {

    }

    /**
     * Lowers (if possible) the platform attached to the Truck object.
     */
    @Override
    public void lowerPlatform() {

    }

    /**
     * A method used in calculating the truck's currentSpeed
     */
    @Override
    public double speedFactor() {
        return enginePower * 0.01;
    }
}
