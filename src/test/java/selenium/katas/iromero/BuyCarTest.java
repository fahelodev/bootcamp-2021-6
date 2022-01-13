package katas.iromero;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuyCarTest {
    @Test
    public void testSixMonth() {
        int[] r = new int[] { 6, 766 };
        assertArrayEquals(r, BuyCar.nbMonths(2000, 8000, 1000, 1.5));
    }
    @Test
    public void testZeroMonth() {
        int[] r = new int[] { 0, 4000 };
        assertArrayEquals(r, BuyCar.nbMonths(12000, 8000, 1000, 1.5));
    }

    @Test
    public void testFloat(){
        int [] r = new int[]{6, 766};
        assertArrayEquals(r, BuyCar.nbMonths(2000.2f, 8000.4f, 1000.01f, 1.5));

    }


}