package katas.fFabricio;
import org.junit.Test;
import static org.junit.Assert.*;
//import static org.junit.Assert.assertEquals;


public class KataPalabrasInversasTest {
    @Test
    public void exampleCases() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", PalabrasInvertidaJava.reverseWords("The quick brown fox jumps over the lazy dog."));
        assertEquals("elppa", PalabrasInvertidaJava.reverseWords("apple"));
        assertEquals("a b c d", PalabrasInvertidaJava.reverseWords("a b c d"));
        assertEquals("elbuod  decaps  sdrow", PalabrasInvertidaJava.reverseWords("double  spaced  words"));
    }

}
