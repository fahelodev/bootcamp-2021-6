package fabriciof;
import org.junit.Test;
import static org.junit.Assert.*;
//import static org.junit.Assert.assertEquals;


public class KataPalabrasInversasTest {
    @Test
    public void exampleCases() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", fabricioKata.reverseWords("The quick brown fox jumps over the lazy dog."));
        assertEquals("elppa", fabricioKata.reverseWords("apple"));
        assertEquals("a b c d", fabricioKata.reverseWords("a b c d"));
        assertEquals("elbuod  decaps  sdrow", fabricioKata.reverseWords("double  spaced  words"));
    }

}
