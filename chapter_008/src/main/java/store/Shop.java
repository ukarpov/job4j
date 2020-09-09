package store;

public class Shop extends Store {

    @Override
    public boolean tryPutInStore(Food f) {
        boolean res = false;
        float lt = f.getLifeTimeUsedPct();
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
}
