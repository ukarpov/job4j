package store;

public class Warehouse extends Store {
    @Override
    public boolean tryPutInStore(Food f) {
        boolean res = false;
        if (f.getLifeTimeUsedPct() < 25) {
            super.add(f);
            res = true;
        }
        return res;
    }
}
