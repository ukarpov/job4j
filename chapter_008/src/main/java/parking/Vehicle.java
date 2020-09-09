package parking;

public abstract class Vehicle {
    private final int size;
    private final String name;
    private final String id;

    public Vehicle(String name, int size, String id) {
        this.id = id;
        this.name = name;
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
