package katas.iromero;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeclareWinnerTest {
    @Test
    public void basicTests() {
        assertEquals("Lew", DeclareWinner.declareWinner(new Fighter("Lew", 10, 2), new Fighter("Harry", 5, 4), "Lew"));

    }
    @Test
    public void testHarry(){
        assertEquals("Harry", DeclareWinner.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Harry"));
    }

    @Test
    public void testHarald(){
        assertEquals("Harald", DeclareWinner.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));
    }

    @Test
    public void test(){
        assertEquals("Harald", DeclareWinner.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));
    }
}