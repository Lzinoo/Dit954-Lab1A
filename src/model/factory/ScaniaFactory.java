package model.factory;

import model.Scania;
import model.Vehicles;

/**
 * A model.factory.ScaniaFactory is a subclass to model.factory.VehicleFactory, designed to return
 * (create) model.Scania objects.
 */
public class ScaniaFactory extends VehicleFactory{
    public Vehicles createVehicle(){
        return new Scania(0,0);
    }
    public Vehicles createVehicle(int x, int y){
        return new Scania(x,y);
    }
}
