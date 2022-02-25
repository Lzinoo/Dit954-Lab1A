/**
 * A TransportFactory is a subclass to VehicleFactory, designed to return
 * (create) Transport objects.
 */
public class TransportFactory extends VehicleFactory{
    public Vehicles createVehicle(){
        return new Transport(3,0,0);
    }
    public Vehicles createVehicle(int x, int y) {
        return new Transport(3, x, y);
    }
    /*
    public Vehicles createVehicle(int max, int x, int y){
        return new Transport(max,x,y);
    }*/
}
