import java.awt.*;

/**
 * A class that represents Cars. Is a subclass of Vehicles.
 */
public class Cars extends Vehicles{
    private int nrDoors;
    private double enginePower;
    private Color color;
    private String modelName;

    /** A car object, a personal vehicle.
     * @param nrDoors The number of doors
     * @param enginePower The power of the engine
     * @param color The colour of the car
     * @param modelName The name of the model of the car
     */
    public Cars(int nrDoors, double enginePower, Color color, String modelName, int x, int y){
        super(nrDoors,enginePower,color,modelName,x,y);
    }
}
