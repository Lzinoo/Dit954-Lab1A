import java.awt.*;

/**
 * Volvo240 class
 */
public class Volvo240 extends Cars {

    private final static double trimFactor = 1.25;

    /**
     *  A Volvo 240 object is a subtype of Cars - has 4 doors, is the color Black, 100 in engine power,
     *  and engine is off by default.
     *
     * @param x_pos The position on the x-axis
     * @param y_pos The position on the y-axis
     */
    public Volvo240(int x_pos, int y_pos){
        super(4, new Engine(100), Color.black, "Volvo240", x_pos, y_pos);
        stopEngine();
    }

    /**
     * A Volvo 240 object is a subtype of Cars - has 4 doors, is the color Black, 100 in engine power,
     * and engine is off by default. Without parameters assumes default position at (0,0).
     */
    public Volvo240() {
        super(4,new Engine(100), Color.black, "Volvo240", 0, 0);
        stopEngine();
    }

    /** Altered method for Volvo240 for use in methods incrementSpeed
     * and decrementSpeed. Value changes depending on value of <i>trimFactor</i>.
     * @return New speedFactor.
     */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
