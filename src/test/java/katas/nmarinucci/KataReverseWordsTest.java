package nmarinucci;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KataReverseWordsTest {
    @Test
    public void casoLargo() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", KataReverseWords.reverseWords("The quick brown fox jumps over the lazy dog."));
     }

    @Test
    public void casoPalabra(){
        assertEquals("elppa", KataReverseWords.reverseWords("apple"));
    }

    @Test
    public void casoLetras(){
        assertEquals("a b c d", KataReverseWords.reverseWords("a b c d"));
    }

    @Test
    public void casoCorto(){
        assertEquals("elbuod  decaps  sdrow", KataReverseWords.reverseWords("double  spaced  words"));
    }
}