package model.factory;

import model.Vehicles;
import model.Volvo240;

/**
 * A model.factory.VolvoFactory is a subclass to model.factory.VehicleFactory, designed to return
 * (create) model.Volvo240 objects.
 */
public class VolvoFactory extends VehicleFactory{
    public Vehicles createVehicle(){
        return new Volvo240(0,0);
    }
    public Vehicles createVehicle(int x, int y){
        return new Volvo240(x, y);
    }
}
