import java.awt.*;

/**
 * Saab95 class
 */
public class Saab95 extends Cars {

    private boolean turboOn;
    
    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }
    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    /** Altered method for Saab95 for use in methods incrementSpeed
     * and decrementSpeed. Value changes depending on the state of <i>turboOn</i>.
     * @return New speedFactor.
     */
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}