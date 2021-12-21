package fabriciof;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class KataDeclararGanaTest {
    @Test
    public void basicTests() {
        assertEquals("Lew", KataJava.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Lew"));
        assertEquals("Harry", KataJava.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald", KataJava.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald", KataJava.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald"));
        assertEquals("Harald", KataJava.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));
        assertEquals("Harald", KataJava.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));
    }
}
