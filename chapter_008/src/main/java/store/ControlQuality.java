package store;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ControlQuality {

    private final List<Store> stores;

    public ControlQuality() {
        stores = new ArrayList<>();
    }

    public void addStore(Store s) {
        stores.add(s);
    }

    public void putFoodInStore(Food f, Calendar dt) {
        for (Store s : stores) {
            if (s.tryPutInStore(f, dt)) {
                break;
            }
        }
    }

    public void putFoodInStore(Food f) {
        putFoodInStore(f, Calendar.getInstance());
    }

    public void resort(Calendar onDate) {
        List<Food> allFood = new ArrayList<>();
        for (Store s : stores) {
            allFood.addAll(s.getFood());
            s.clearStore();
        }
        allFood.forEach(s -> putFoodInStore(s, onDate));
    }

    public void resort() {
        resort(Calendar.getInstance());
    }
}
