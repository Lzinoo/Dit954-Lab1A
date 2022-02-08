import java.util.ArrayList;

/** Workshop class
 * @param <T> The type of Cars allowed in the workshop. Superclass <i>Cars</i> for all cars.
 */
public class Workshop <T extends Cars> {

    private int max; // Max stored cars
    T type;
    private ArrayList<T> storeCars = new ArrayList<T>();

    /** A Workshop object. Allows storage of Cars - or a specific subtype of Cars.
     * @param max Max number of cars allowed in storage.
     */
    public Workshop(int max) {
        this.max = max;
    }


    /** Adds a car to the workshop if there is enough room.
     * @param Car the car to be added.
     */
    public void loadCar (T Car) {
        if (storeCars.size() != max) {
            storeCars.add(Car);
        }
    }

    /** Returns/takes out a specified car from the workshop.
     * @param car The car to be searched for.
     * @return The found car. Null if not found.
     */
    public T takeOutCar (T car) {

        T t = null;

        for (T c : storeCars) {
            if (c.equals(car)) {

                t = car;
                storeCars.remove(car);
                break;
            }
        }
        return t;
    }

}