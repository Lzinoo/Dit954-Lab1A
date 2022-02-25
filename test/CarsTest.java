import model.Saab95;
import model.Vehicles;
import model.Volvo240;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {
    private Volvo240 testVolvo;
    private Saab95 testSaab;

    // Create two model.Cars objects, one model.Volvo240 and one model.Saab95.
    @BeforeEach
    void SetUp(){
        testVolvo = new Volvo240();
        testSaab = new Saab95();
    }

    // After Gas method is called, new currentSpeed should be greater than before.
    @Test
    public void volvoSpeedIncreaseTest() {
        double initialSpeed = testVolvo.getCurrentSpeed();
        testVolvo.gas(1);
        assert (testVolvo.getCurrentSpeed() > initialSpeed);
    }

    // After Gas method is called, new currentSpeed should be greater than before.
    @Test
    public void saabSpeedIncreaseTest() {
        double initialSpeed = testSaab.getCurrentSpeed();
        testSaab.gas(1);
        assert (testSaab.getCurrentSpeed() > initialSpeed);
    }

    // After Brake method is called, new currentSpeed should be smaller than before.
    @Test
    public void volvoSpeedDecreaseTest() {
        testVolvo.gas(1);
        double initialSpeed = testVolvo.getCurrentSpeed();
        testVolvo.brake(1);
        assert (testVolvo.getCurrentSpeed() < initialSpeed);
    }

    // After Brake method is called, new currentSpeed should be smaller than before.
    @Test
    public void saabSpeedDecreaseTest() {
        testSaab.gas(1);
        double initialSpeed = testSaab.getCurrentSpeed();
        testSaab.brake(1);
        assert (testSaab.getCurrentSpeed() < initialSpeed);
    }

    // Checks so that move() changes the car's Y coordinate,
    // while X and Direction stays the same.
    @Test
    public void doesCarMove() {
        testSaab.gas(1);
        testSaab.move();
        assert(testSaab.getX() == 0 && testSaab.getY() != 0 && testSaab.getDir() == Vehicles.direction.NORTH);
    }

    //Checks so that turnLeft() changes the direction correctly
    @Test
    public void doesCarTurnLeft() {
        testVolvo.turnLeft();
        assert (testVolvo.getDir() == Vehicles.direction.WEST);
    }

    //Checks so that turnRight() changes the direction correctly
    @Test
    public void doesCarTurnRight() {
        testVolvo.turnRight();
        assert (testVolvo.getDir() == Vehicles.direction.EAST);
    }


}