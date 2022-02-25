import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransportTest {

    private Transport testTransport;
    private Saab95 testSaab;

    @BeforeEach
    void init() {
        testTransport = new Transport(10);
        testSaab = new Saab95();
    }

    @Test
    public void platformUpCheck() {
        testTransport.raisePlatform();
        testTransport.mountCar(testSaab);
        assert (testTransport.dismountCar() == null);
    }

    @Test
    public void canCarBeLoaded() {
        testTransport.lowerPlatform();
        testTransport.mountCar(testSaab);
        //testTransport.mountCar(new Transport(5));
        assert (testTransport.getNumberOfMountedCars() == 1);
    }

    @Test
    public void canCarBeDismounted() {
        testTransport.lowerPlatform();
        testTransport.mountCar(testSaab);
        assert (testTransport.dismountCar() == testSaab);
    }

}