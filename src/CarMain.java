public class CarMain {
    private static VehicleFactory vf;
    private static VehicleFactory vf2;
    private static VehicleFactory vf3;
    public static void main(String[] args) {
        CarController cc = configure();
        CarView carView = new CarView("CarView 2.0",cc);
    }

    static CarController configure(){
        CarController cc = new CarController();
        vf = new VolvoFactory();
        vf2 = new ScaniaFactory();
        vf3 = new SaabFactory();
        cc.cars.add(create(vf,0,0));
        Scania scania = (Scania) create(vf2,0,100);
        Saab95 saab = (Saab95) create(vf3,0,200);
        cc.cars.add(scania);
        cc.scaniaCars.add(scania);
        cc.cars.add(saab);
        cc.saabCars.add(saab);
        return cc;
    }


    static Vehicles create(VehicleFactory vf){
        return vf.createVehicle();
    }
    static Vehicles create(VehicleFactory vf, int x, int y){
        return vf.createVehicle(x,y);
    }
}
