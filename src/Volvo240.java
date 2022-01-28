import java.awt.*;

/**
 * Volvo240 class
 */
public class Volvo240 extends Cars {

    private final static double trimFactor = 1.25;

    /**
     * A Volvo 240 object is a subtype of Cars - has 4 doors, is the color Black, 100 in engine power,
     *  and engine is off by default.
     */
    public Volvo240(){
        super(4, 100, Color.black, "Volvo240");
        stopEngine();
    }

    /** Altered method for Volvo240 for use in methods incrementSpeed
     * and decrementSpeed. Value changes depending on value of <i>trimFactor</i>.
     * @return New speedFactor.
     */
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
