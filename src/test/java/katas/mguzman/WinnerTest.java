package katas.mguzman;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class WinnerTest {
    @Test
    public void basicTests() {
        assertEquals("Lew", Winner.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Lew"));
        assertEquals("Harry", Winner.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald", Winner.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald", Winner.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald"));
        assertEquals("Harald", Winner.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));
        assertEquals("Harald", Winner.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));
    }
}