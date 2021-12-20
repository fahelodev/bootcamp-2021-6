package katas.fFabricio;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class KataComprarCarroTest {

    @Test
    public void test1() {
        int[] r = new int[] { 6, 766 };
        assertArrayEquals(r, ComprarCarroJava.nbMonths(2000, 8000, 1000, 1.5));
    }
    @Test
    public void test2() {
        int[] r = new int[] { 0, 4000 };
        assertArrayEquals(r, ComprarCarroJava.nbMonths(12000, 8000, 1000, 1.5));
    }
}
