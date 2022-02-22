public class CarMain {
    public static void main(String[] args) {
        CarController cc = new CarController();
        cc.cars.add(new Volvo240(0,0));
        cc.cars.add(new Scania(0, 100));
        cc.cars.add(new Saab95(0, 200));
        CarView carView = new CarView("CarView 2.0",cc);
    }
}
