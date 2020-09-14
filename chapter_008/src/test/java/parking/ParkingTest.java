package parking;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void simpleParkCar() {
        Parking p = new Parking(1, 1);
        Vehicle car = new Car("Mazda", "a123aa");
        Vehicle truck = new Truck("MAZ", "b456bb");

        assertTrue(p.park(car));
        assertTrue(p.park(truck));
    }

    @Test
    public void parkTrucks() {
        Parking p = new Parking(3, 1);
        Vehicle truck1 = new Truck("KAMAZ", "a123aa");
        Vehicle truck2 = new Truck("MAZ", "b456bb");

        assertTrue(p.park(truck1));
        assertTrue(p.park(truck2));
    }

    @Test
    public void removeFromParking() {
        Parking p = new Parking(1, 1);
        Vehicle car1 = new Car("Mazda", "a123aa");
        Vehicle car2 = new Car("KIA", "a789zz");
        p.park(car1);

        assertFalse(p.park(car2));
        p.remove(car1);
        assertTrue(p.park(car2));
    }

    @Test
    public void cannotParkWhenFull() {
        Parking p = new Parking(1, 1);
        Vehicle car1 = new Car("Mazda", "a123aa");
        Vehicle car2 = new Car("KIA", "a789zz");
        Vehicle truck = new Truck("MAZ", "b456bb");

        p.park(car1);
        p.park(truck);
        assertFalse(p.park(car2));
    }


}