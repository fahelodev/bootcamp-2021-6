package katas.fmarfull;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FighterTest {

    Fighter fighter1 = new Fighter("Lew", 10, 2);
    Fighter fighter2 = new Fighter("Harry", 5, 4);
    Fighter fighter3 = new Fighter("Harald", 20, 5);
    Fighter fighter4 = new Fighter("Jerry", 30, 3);

    @Before
    public void Setup() {
        fighter1.health = 10;
        fighter2.health = 5;
        fighter3.health = 20;
        fighter4.health = 30;
    }

    @Test
    public void fighterOneVsFighterTwoStartsFighterOne() {
        assertEquals("Lew", Fighter.declareWinner(fighter1, fighter2, "Lew"));
    }

    @Test
    public void basicTests2() {
        assertEquals("Harry", Fighter.declareWinner(fighter1, fighter2, "Harry"));
    }

    @Test
    public void basicTests3() {
        assertEquals("Harald", Fighter.declareWinner(fighter3, fighter2, "Harry"));
    }

    @Test
    public void basicTests4() {
        assertEquals("Harald", Fighter.declareWinner(fighter3, fighter2, "Harald"));
    }

    @Test
    public void basicTests5() {
        assertEquals("Harald", Fighter.declareWinner(fighter4, fighter3, "Jerry"));
    }

    @Test
    public void basicTests6() {
        assertEquals("Harald", Fighter.declareWinner(fighter4, fighter3, "Harald"));
    }

}