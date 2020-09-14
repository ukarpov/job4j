package store;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;

import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void whenAdd2Store() {
        Calendar now = Calendar.getInstance();
        Calendar nowMinus5 = Calendar.getInstance();
        nowMinus5.add(Calendar.DAY_OF_MONTH, -5);
        Calendar nowMinus2 = Calendar.getInstance();
        nowMinus2.add(Calendar.DAY_OF_MONTH, -2);

        Food bFresh = new Banana(now, 20);
        Food bOk = new Banana(nowMinus2, 20);
        Food bBad = new Banana(nowMinus5, 20);

        Store w = new Warehouse();
        Store s = new Shop();
        Store t = new Trash();

        ControlQuality cq = new ControlQuality();
        cq.addStore(w);
        cq.addStore(s);
        cq.addStore(t);
        cq.putFoodInStore(bFresh);
        cq.putFoodInStore(bOk);
        cq.putFoodInStore(bBad);

        assertEquals(Arrays.asList(bFresh), w.getFood());
        assertEquals(Arrays.asList(bOk), s.getFood());
        assertEquals(Arrays.asList(bBad), t.getFood());
    }

    @Test
    public void whenSetDiscount() {
        Calendar nowMinus80 = Calendar.getInstance();
        nowMinus80.add(Calendar.DAY_OF_MONTH, -80);
        Food cracker = new Cracker(nowMinus80, 10);
        Store w = new Warehouse();
        Store s = new Shop();
        Store t = new Trash();
        ControlQuality cq = new ControlQuality();
        cq.addStore(w);
        cq.addStore(s);
        cq.addStore(t);
        cq.putFoodInStore(cracker);

        assertEquals(Arrays.asList(cracker), s.getFood());
        assertTrue(cracker.getDiscount() > 0);
    }

    @Test
    public void whenResortFromWarehouseToTrash() {
        Calendar now = Calendar.getInstance();
        Calendar nowPlus5 = Calendar.getInstance();
        nowPlus5.add(Calendar.DAY_OF_MONTH, 5);

        Food b = new Banana(now, 20); // lifetime 4 days
        Store w = new Warehouse();
        Store s = new Shop();
        Store t = new Trash();

        ControlQuality cq = new ControlQuality();
        cq.addStore(w);
        cq.addStore(s);
        cq.addStore(t);
        cq.putFoodInStore(b);
        assertEquals(Arrays.asList(b), w.getFood());
        assertEquals(Collections.emptyList(), s.getFood());
        assertEquals(Collections.emptyList(), t.getFood());

        cq.resort(nowPlus5);
        assertEquals(Collections.emptyList(), w.getFood());
        assertEquals(Collections.emptyList(), s.getFood());
        assertEquals(Arrays.asList(b), t.getFood());
    }


}