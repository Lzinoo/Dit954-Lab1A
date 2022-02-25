package model.factory;

import model.Transport;
import model.Vehicles;

/**
 * A model.factory.TransportFactory is a subclass to model.factory.VehicleFactory, designed to return
 * (create) model.Transport objects.
 */
public class TransportFactory extends VehicleFactory{
    public Vehicles createVehicle(){
        return new Transport(3,0,0);
    }
    public Vehicles createVehicle(int x, int y) {
        return new Transport(3, x, y);
    }
    /*
    public model.Vehicles createVehicle(int max, int x, int y){
        return new model.Transport(max,x,y);
    }*/
}
