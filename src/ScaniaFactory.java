/**
 * A ScaniaFactory is a subclass to VehicleFactory, designed to return
 * (create) Scania objects.
 */
public class ScaniaFactory extends VehicleFactory{
    public Vehicles createVehicle(){
        return new Scania(0,0);
    }
    public Vehicles createVehicle(int x, int y){
        return new Scania(x,y);
    }
}
