package store;

import java.util.Calendar;

public class Shop extends Store {

    @Override
    public boolean tryPutInStore(Food f, Calendar dt) {
        boolean res = false;
        float lt = f.getLifeTimeUsedPct(dt);
        if (25 <= lt && lt <= 75) {
            super.add(f);
            res = true;
        } else if (75 < lt && lt < 100) {
            f.setDiscount(30);
            super.add(f);
            res = true;
        }
        return res;
    }

    @Override
    public boolean tryPutInStore(Food f) {
        return tryPutInStore(f, Calendar.getInstance());
    }
}
