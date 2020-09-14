package store;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public abstract class Store {
    private final List<Food> food;

    public Store() {
        food = new ArrayList<>();
    }

    public void add(Food f) {
        food.add(f);
    }

    public abstract boolean tryPutInStore(Food f);

    public abstract boolean tryPutInStore(Food f, Calendar dt);

    public List<Food> getFood() {
        return new ArrayList<>(food);
    }

    public void clearStore() {
        food.clear();
    }
}
