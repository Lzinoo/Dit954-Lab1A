import java.awt.*;

/**
 * A class that represents Cars. Is a subclass of Vehicles.
 */
public class Cars extends Vehicles{
    private int nrDoors;
    private Color color;
    private String modelName;
    private Engine engine;

    /** A car object, a personal vehicle.
     * @param nrDoors The number of doors
     * @param engine The engine of the car.
     * @param color The colour of the car
     * @param modelName The name of the model of the car
     */
    public Cars(int nrDoors, Engine engine, Color color, String modelName, int x, int y){
        super(nrDoors,color,modelName,x,y);
        this.engine = engine;
    }

    @Override
    public double enginePower() {
        return 0;
    }

    public double getEnginePower(){return enginePower();}
}
