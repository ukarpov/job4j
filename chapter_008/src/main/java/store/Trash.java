package store;

import java.util.Calendar;

public class Trash extends Store {

    @Override
    public boolean tryPutInStore(Food f, Calendar dt) {
        boolean res = false;
        if (f.getLifeTimeUsedPct(dt) >= 100) {
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
