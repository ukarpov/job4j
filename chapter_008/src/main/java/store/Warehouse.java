package store;

import java.util.Calendar;

public class Warehouse extends Store {
    @Override
    public boolean tryPutInStore(Food f, Calendar dt) {
        boolean res = false;
        if (f.getLifeTimeUsedPct(dt) < 25) {
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
