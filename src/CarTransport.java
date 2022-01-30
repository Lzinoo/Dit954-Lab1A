import java.awt.*;

public class CarTransport extends Cars {

    private double

    public CarTransport(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }

    @Override
    public double speedFactor() {
        return getCurrentSpeed();
    }
}
