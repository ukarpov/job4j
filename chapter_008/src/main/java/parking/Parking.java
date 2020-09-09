package parking;

public class Parking {
    private final ParkZone cars;
    private final ParkZone trucks;

    public Parking(int carsCapacity, int trucksCapacity) {
        cars = new ParkZone(carsCapacity, 1, v -> false);
        trucks = new ParkZone(trucksCapacity, 3, v -> false);
    }

    public boolean park(Vehicle v) {
        return false;
    }

    public void remove(Vehicle v) {

    };


}
