import java.util.ArrayList;
/**
 * Workshop class.
 */
public class Workshop<T>{

    private int maxLoad; // Max number of cars.
    private int currentLoad; // Current number of cars.
    private ArrayList<Cars> storedCars;

    public Workshop(int maxLoad, Class<T> type){
        this.maxLoad = maxLoad;
        if(type!=null){} // Set storedCars to specified class.
        else{} // Else allow all Cars.
    }

    public int getMaxLoad() {
        return maxLoad;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    public void addCar(Cars car){
        if(currentLoad<maxLoad) // TODO: "&& carType allowed"
            storedCars.add(car);
    }

    public Cars getCar(){
        return null;
    }
}