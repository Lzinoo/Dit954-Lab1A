import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    private Scania testScania;

    @BeforeEach
    void init() {
        testScania = new Scania();
    }

    /**
     * Checks if the gas() method increases speed when the platform is above 0 degrees
     */
    @Test
    void canScaniaDrivePlatformUp() {
        testScania.raisePlatform(1);
        testScania.gas(1);
        assert (testScania.getCurrentSpeed() == 0);
    }

    /**
     * Checks if the angle of the platform can increase when the currentSpeed is above 0
     */
    @Test
    void canPlatformAngleIncreaseWhenDriving() {
        testScania.gas(1);
        testScania.raisePlatform(1);
        assert (testScania.getPlatformAngle() == 0);
    }
}