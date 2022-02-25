/**
 * A VolvoFactory is a subclass to VehicleFactory, designed to return
 * (create) Volvo240 objects.
 */
public class VolvoFactory extends VehicleFactory{
    public Vehicles createVehicle(){
        return new Volvo240(0,0);
    }
    public Vehicles createVehicle(int x, int y){
        return new Volvo240(x, y);
    }
}
