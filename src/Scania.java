import java.awt.*;

public class Scania extends Cars {

    private double flatbedAngle;

    public Scania (int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }

    public double getflatbedAngle() {
        return flatbedAngle;
    }

    public void setflatbedAngle(double flatbedAngle) {

        if (flatbedAngle >= 0 && flatbedAngle <= 70) {
            this.flatbedAngle = flatbedAngle;
        }
    }

    @Override
    public double speedFactor() {
        return getCurrentSpeed();
    }

    public void raise (double amount) {
        if (getCurrentSpeed() == 0) {
            setflatbedAngle(getflatbedAngle() + amount);
        }
    }

    public void lower (double amount) {
        if (getCurrentSpeed() == 0) {
        setflatbedAngle(getflatbedAngle() - amount);
        }
    }

}
