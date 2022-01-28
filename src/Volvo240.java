import java.awt.*;

/**
 * Volvo240 class
 */
public class Volvo240 extends Cars {

    private final static double trimFactor = 1.25;
    
    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    /** Altered method for Volvo240 for use in methods incrementSpeed
     * and decrementSpeed. Value changes depending on value of <i>trimFactor</i>.
     * @return New speedFactor.
     */
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}
