public class CarMain {
    public static void main(String[] args) {
        CarController cc = configure();
        CarView carView = new CarView("CarView 2.0", cc);
    }

    static CarController configure() {
        CarController cc = new CarController();
        return cc;

    }
}