public class CarMain {
    public static void main(String[] args) {
        CarController cc = new CarController();
        Scania scania = new Scania(0, 100);
        Saab95 saab = new Saab95(0, 200);
        cc.cars.add(new Volvo240(0,0));
        cc.cars.add(scania);
        cc.scaniaCars.add(scania);
        cc.cars.add(saab);
        cc.saabCars.add(saab);
        CarView carView = new CarView("CarView 2.0",cc);
    }
}
