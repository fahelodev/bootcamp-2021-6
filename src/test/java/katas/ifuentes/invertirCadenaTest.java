package ifuentes;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class invertirCadenaTest {
    @Test
    public void inversa() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god",invertirCadena.palabrasinversas("The quick brown fox jumps over the lazy dog."));
        assertEquals("elppa", invertirCadena.palabrasinversas("apple"));
        assertEquals("a b c d", invertirCadena.palabrasinversas("a b c d"));
        assertEquals("elbuod  decaps  sdrow", invertirCadena.palabrasinversas("double  spaced  words"));
        }
}