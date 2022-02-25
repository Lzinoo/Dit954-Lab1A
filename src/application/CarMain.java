package application;

import controller.CarController;
import controller.CarView;
import model.*;
import model.factory.SaabFactory;
import model.factory.ScaniaFactory;
import model.factory.VehicleFactory;
import model.factory.VolvoFactory;


public class CarMain {
    private static VehicleFactory volvoFactory;
    private static VehicleFactory scaniaFactory;
    private static VehicleFactory saabFactory;
    public static void main(String[] args) {
        CarController cc = configure();
        CarView carView = new CarView("controller.CarView 2.0",cc);
    }

    static CarController configure(){
        CarController cc = new CarController();
        volvoFactory = new VolvoFactory();
        scaniaFactory = new ScaniaFactory();
        saabFactory = new SaabFactory();
        cc.addCars(create(volvoFactory,0,0));
        Scania scania = (Scania) create(scaniaFactory,0,100);
        Saab95 saab = (Saab95) create(saabFactory,0,200);
        cc.addCars(scania);
        /*cc.scaniaCars.add(scania);
        cc.cars.add(saab);
        cc.saabCars.add(saab);*/
        return cc;
    }


    static Vehicles create(VehicleFactory vf){
        return vf.createVehicle();
    }
    static Vehicles create(VehicleFactory vf, int x, int y){
        return vf.createVehicle(x,y);
    }
}
