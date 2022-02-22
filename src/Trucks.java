import java.awt.*;

/**
 * A class that represents Trucks. Is a subclass of Vehicles.
 */
public class Trucks extends Vehicles implements Platform{
    private int nrDoors;
    private double enginePower;
    private Color color;
    private String modelName;
    private Engine engine;

    /** A truck object, has some sort of carriage (e.g. trailer).
     * @param nrDoors The number of doors
     * @param enginePower The power of the engine
     * @param color The colour of the car
     * @param modelName The name of the model of the car
     */
    public Trucks(int nrDoors, Engine engine, Color color, String modelName, int x, int y){
        super(nrDoors,color,modelName, x, y);
        this.engine = engine;
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

    @Override
    public double enginePower() {
        return 0;
    }
}
