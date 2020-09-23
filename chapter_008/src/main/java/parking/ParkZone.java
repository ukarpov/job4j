package parking;

import java.util.ArrayList;
import java.util.function.Predicate;

public class ParkZone {
    private int capacity;
    private final int onePlaceSize;
    private final Predicate<Vehicle> rules;
    private final ArrayList<Vehicle> vehicles;

    public ParkZone(int capacity, int onePlaceSize, Predicate<Vehicle> rules) {
        this.onePlaceSize = onePlaceSize;
        this.capacity = this.onePlaceSize * capacity;
        this.rules = rules;
        this.vehicles = new ArrayList<>();
    }

    private boolean canPlaceVehicle(Vehicle v) {
        return rules.test(v)
               && capacity >= v.getSize();
    };

    public boolean park(Vehicle v) {
        boolean res = false;
        if (canPlaceVehicle(v)) {
            vehicles.add(v);
            capacity -= v.getSize();
            res = true;
        }
        return res;
    };

    public void remove(Vehicle v) {
        vehicles.remove(v);
        capacity += v.getSize();
    };
}
