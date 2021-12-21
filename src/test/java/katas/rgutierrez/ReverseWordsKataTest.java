package katas.rgutierrez;

import junit.rgutierrez.ReverseWordsKata;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReverseWordsKataTest {

    @Test
    public void pruebaUno (){
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", ReverseWordsKata.reverseWords("The quick brown fox jumps over the lazy dog."));
    }

    @Test
    public void pruebaDos (){
        assertEquals("elppa", ReverseWordsKata.reverseWords("apple"));
    }

    @Test
    public void pruebaTres (){
        assertEquals("a b c d", ReverseWordsKata.reverseWords("a b c d"));
    }

    @Test
    public void pruebaCuatro (){
        assertEquals("elbuod  decaps  sdrow", ReverseWordsKata.reverseWords("double  spaced  words"));
    }

    @Test
    public void emptyString (){
        assertEquals("", ReverseWordsKata.reverseWords(""));
    }

    @Test
    public void allSpaces (){
        assertEquals("   ", ReverseWordsKata.reverseWords("   "));
    }

}