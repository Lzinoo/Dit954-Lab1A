import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class WorkshopTest {
    private Workshop<Cars> workshopAll;
    private Workshop<Saab95> workshopSaab;
    private Saab95 saab;
    private Volvo240 volvo;
    private Transport transport;
    private Scania scania;

    @BeforeEach
    void init(){
        workshopAll = new Workshop<Cars>(3);
        workshopSaab = new Workshop<Saab95>(3);
        saab = new Saab95();
        volvo = new Volvo240();
        transport = new Transport(5);
        scania = new Scania();
    }

    @Test
    void testWorkshopSizeAndType(){
        workshopAll.loadCar(saab);
        workshopAll.loadCar(volvo);
        workshopAll.loadCar(scania);
        workshopAll.loadCar(transport); // Max capacity, can't store this
        assert(workshopAll.takeOutCar(transport)==null); // Should be null
    }

    @Test
    void testWorkshopReturn(){
        workshopSaab.loadCar(saab);
        Saab95 newSaab = workshopSaab.takeOutCar(saab);
        System.out.println(saab);
        System.out.println(newSaab);
    }
}
