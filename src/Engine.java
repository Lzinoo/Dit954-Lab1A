public class Engine {
    private double enginePower;

    /** An engine object - attached to Vehicles
     * that may contain an engine.
     * @param enginePower The power of the engine.
     */
    public Engine (double enginePower){
        this.enginePower = enginePower;
    }
    public double getEnginePower() {
        return enginePower;
    }
}
