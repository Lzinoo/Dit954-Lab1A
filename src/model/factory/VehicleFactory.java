package model.factory;

import model.Vehicles;

/**
 * An abstract class with concrete subclasses designed to return (create)
 * model.Vehicles objects.
 */
public abstract class VehicleFactory {
    /** Creates a model.Vehicles object of one of its subclasses.
     * @return New object of model.Vehicles.
     */
    public abstract Vehicles createVehicle();

    /** Creates a model.Vehicles object of one of its subclasses.
     * @param x The start value of X for the Vehicle.
     * @param y The start value of Y for the Vehicle.
     * @return New object of model.Vehicles.
     */
    public abstract Vehicles createVehicle(int x, int y);
}
