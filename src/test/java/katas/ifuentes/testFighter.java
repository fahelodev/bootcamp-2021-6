package ifuentes;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class testFighter {

    @Test
    public void fighterTest() {
        assertEquals("Lew", fighter.declareWinner(new fighter("Lew", 10, 2),new fighter("Harry", 5, 4), "Lew"));
        assertEquals("Harry", fighter.declareWinner(new fighter("Lew", 10, 2),new fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald", fighter.declareWinner(new fighter("Harald", 20, 5), new fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald", fighter.declareWinner(new fighter("Harald", 20, 5), new fighter("Harry", 5, 4), "Harald"));
        assertEquals("Harald", fighter.declareWinner(new fighter("Jerry", 30, 3), new fighter("Harald", 20, 5), "Jerry"));
        assertEquals("Harald", fighter.declareWinner(new fighter("Jerry", 30, 3), new fighter("Harald", 20, 5), "Harald"));
    }
}