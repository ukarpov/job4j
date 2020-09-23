package parking;

public class Parking {
    private final ParkZone cars;
    private final ParkZone trucks;

    public Parking(int carsCapacity, int trucksCapacity) {
        cars = new ParkZone(carsCapacity, 1, v -> v.getSize() == 1 || v.getSize() == 3);
        trucks = new ParkZone(trucksCapacity, 3, v -> v.getSize() == 3);
    }

    public boolean park(Vehicle v) {
        return trucks.park(v) || cars.park(v);
    }

    public void remove(Vehicle v) {
        trucks.remove(v);
        cars.remove(v);
    };


}
