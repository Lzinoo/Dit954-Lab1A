public class SaabFactory extends VehicleFactory{
    public Vehicles createVehicle(){
        return new Saab95(0,0);
    }
    public Vehicles createVehicle(int x, int y){
        return new Saab95(x,y);
    }
}
