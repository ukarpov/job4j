package store;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private final List<Store> stores;

    public ControlQuality() {
        stores = new ArrayList<>();
    }

    public void addStore(Store s) {
        stores.add(s);
    }

    public void putFoodInStore(Food f) {
        for (Store s : stores) {
            if (s.tryPutInStore(f)) {
                break;
            }
        }
    }
}
