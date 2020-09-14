package store;

import java.util.Calendar;

public abstract class Food {
    private final String name;
    private final Calendar expire;
    private final Calendar created;
    private float price;
    private float discount;

    public Food(String name, Calendar created, int freshDays, float price, float discount) {
        this.name = name;
        this.created = clearCalendarTime(created);
        this.expire = (Calendar) this.created.clone();
        this.expire.add(Calendar.DATE, freshDays);
        this.price = price;
        this.discount = discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getDiscount() {
        return this.discount;
    }

    private Calendar clearCalendarTime(Calendar dt) {
        dt.set(Calendar.HOUR, 0);
        dt.set(Calendar.HOUR_OF_DAY, 0);
        dt.set(Calendar.MINUTE, 0);
        dt.set(Calendar.SECOND, 0);
        dt.set(Calendar.MILLISECOND, 0);
        return dt;
    }

    public float getLifeTimeUsedPct() {
        return getLifeTimeUsedPct(Calendar.getInstance());
    }

    public float getLifeTimeUsedPct(Calendar dt) {
        float full = expire.getTimeInMillis() - created.getTimeInMillis();
        float rest = expire.getTimeInMillis() - clearCalendarTime(dt).getTimeInMillis();
        return 100 - ((rest / full)  * 100);
    }

    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        Food b = new Banana(now, 10);
        System.out.println(b.getLifeTimeUsedPct());

        now.set(2020, Calendar.SEPTEMBER, 1);
        Food b2 = new Banana(now, 10);
        System.out.println(b2.getLifeTimeUsedPct());
    }
}
