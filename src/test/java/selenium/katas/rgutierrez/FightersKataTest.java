package katas.rgutierrez;

import org.junit.Test;

import static org.junit.Assert.*;

public class FightersKataTest {

    @Test
    public void pruebaUno (){
        assertEquals("Lew", FightersKata.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Lew"));
    }

    @Test
    public void pruebaDos (){
        assertEquals("Harry", FightersKata.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Harry"));
    }

    @Test
    public void pruebaTres (){
        assertEquals("Harald", FightersKata.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));
    }

    @Test
    public void pruebaCuatro (){
        assertEquals("Harald", FightersKata.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald"));
    }

    @Test
    public void pruebaCinco (){
        assertEquals("Harald", FightersKata.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));
    }

    @Test
    public void pruebaSeis (){
        assertEquals("Harald", FightersKata.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));
    }

}