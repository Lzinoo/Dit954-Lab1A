import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    private Cars testVolvo;
    private Cars testSaab;

    // Create two Cars objects, one Volvo240 and one Saab95.
    @BeforeEach
    void SetUp(){
        testVolvo = new Volvo240();
        testSaab = new Saab95();
    }

    // After Gas method is called, new currentSpeed should be greater than before.
    @Test
    public void volvoSpeedIncreaseTest() {
        testVolvo.setCurrentSpeed(50);
        double initialSpeed = testVolvo.getCurrentSpeed();
        testVolvo.gas(1);
        assert (testVolvo.getCurrentSpeed() > initialSpeed);
    }

    // After Gas method is called, new currentSpeed should be greater than before.
    @Test
    public void saabSpeedIncreaseTest() {
        testSaab.setCurrentSpeed(50);
        double initialSpeed = testSaab.getCurrentSpeed();
        testSaab.gas(1);
        assert (testSaab.getCurrentSpeed() > initialSpeed);
    }

    // After Brake method is called, new currentSpeed should be smaller than before.
    @Test
    public void volvoSpeedDecreaseTest() {
        testVolvo.setCurrentSpeed(50);
        double initialSpeed = testVolvo.getCurrentSpeed();
        testVolvo.brake(1);
        assert (testVolvo.getCurrentSpeed() < initialSpeed);
    }

    // After Brake method is called, new currentSpeed should be smaller than before.
    @Test
    public void saabSpeedDecreaseTest() {
        testSaab.setCurrentSpeed(50);
        double initialSpeed = testSaab.getCurrentSpeed();
        testSaab.brake(1);
        assert (testSaab.getCurrentSpeed() < initialSpeed);
    }

    // Checks so that move() changes the car's Y coordinate,
    // while X and Direction stays the same.
    @Test
    public void doesCarMove() {
        testSaab.setX(0);
        testSaab.setY(0);
        testSaab.setDir(Cars.direction.NORTH);
        testSaab.setCurrentSpeed(50);
        testSaab.move();
        assert(testSaab.getX() == 0 && testSaab.getY() != 0 && testSaab.getDir() == Cars.direction.NORTH);
    }
}