public class VolvoFactory extends VehicleFactory{
    public Vehicles createVehicle(){
        return new Volvo240(0,0);
    }
    public Vehicles createVehicle(int x, int y){
        return new Volvo240(x, y);
    }
}
