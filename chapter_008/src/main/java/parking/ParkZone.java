package parking;

import java.util.ArrayList;
import java.util.function.Predicate;

public class ParkZone {
    private final int capacity;
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
        return false;
    };
    public boolean park(Vehicle v) {
        return false;
    };
    public void remove(Vehicle v) {
    };
}
