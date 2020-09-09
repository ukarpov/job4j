package store;

import java.util.Calendar;

public class Banana extends Food {
    public Banana(Calendar created, float price) {
        super("Banana", created, 4, price, 0);
    }
}
