import java.awt.*;

/**
 * Saab95 class
 */
public class Saab95 extends Cars {

    private boolean turboOn;

    /**
     * A Saab 95 object is a subtype of Cars - has 2 doors, is the color Red, 125 in engine power,
     *  turbo is off by default, and engine is off by default.
     *
     *  @param x_pos The position on the x-axis
     *  @param y_pos The position on the y-axis
     */
    public Saab95(int x_pos, int y_pos){
        super(2,new Engine(125),Color.red,"Saab95", x_pos, y_pos);
        turboOn = false;
        stopEngine();
    }

    /**
     * A Saab 95 object is a subtype of Cars - has 2 doors, is the color Red, 125 in engine power,
     * turbo is off by default, and engine is off by default. Without parameters the object assumes
     * a position at (0,0).
     */
    public Saab95() {
        super(2, new Engine(125), Color.red,"Saab95", 0, 0);
        turboOn = false;
        stopEngine();
    }

    /**
     * Sets the turbo on. Affects speed.
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Sets the turbo off. Affects speed.
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /** Altered method for Saab95 for use in methods incrementSpeed
     * and decrementSpeed. Value changes depending on the state of <i>turboOn</i>.
     * @return New speedFactor.
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
