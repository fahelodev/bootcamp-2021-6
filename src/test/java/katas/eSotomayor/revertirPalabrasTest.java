package eSotomayor;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class revertirPalabrasTest {
    @Test
    public void reverseWords() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", revertirPalabras.reverseWords("The quick brown fox jumps over the lazy dog."));
        assertEquals("elppa", revertirPalabras.reverseWords("apple"));
        assertEquals("a b c d", revertirPalabras.reverseWords("a b c d"));
        assertEquals("elbuod  decaps  sdrow", revertirPalabras.reverseWords("double  spaced  words"));
    }
}