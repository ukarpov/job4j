package store;

import java.util.ArrayList;
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

    public List<Food> getFood() {
        return new ArrayList<>(food);
    }
}
