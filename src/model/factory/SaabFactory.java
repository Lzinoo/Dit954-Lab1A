package model.factory;

import model.Saab95;
import model.Vehicles;

/**
 * A model.factory.SaabFactory is a subclass to model.factory.VehicleFactory, designed to return
 * (create) model.Saab95 objects.
 */
public class SaabFactory extends VehicleFactory{
    public Vehicles createVehicle(){
        return new Saab95(0,0);
    }
    public Vehicles createVehicle(int x, int y){
        return new Saab95(x,y);
    }
}
