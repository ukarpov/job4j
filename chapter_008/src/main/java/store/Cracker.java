package store;

import java.util.Calendar;

public class Cracker extends Food {
    public Cracker(Calendar created, float price) {
        super("Cracker", created, 100, price, 0);
    }
}