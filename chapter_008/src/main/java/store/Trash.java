package store;

public class Trash extends Store {

    @Override
    public boolean tryPutInStore(Food f) {
        boolean res = false;
        if (f.getLifeTimeUsedPct() >= 100) {
            super.add(f);
            res = true;
        }
        return res;
    }
}
