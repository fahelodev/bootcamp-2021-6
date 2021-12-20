package msabattini;
import msabattini.KataReverse;
import org.junit.Test;
import static org.junit.Assert.*;



public class KataReverseTest {

    @Test
    public void caso1(){
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", KataReverse.reverseString("The quick brown fox jumps over the lazy dog."));
    }

    @Test
    public void caso2(){
        assertEquals("elppa", KataReverse.reverseString("apple"));
    }

    @Test
    public void caso3(){
        assertEquals("a b c d", KataReverse.reverseString("a b c d"));
    }

    @Test

    public void caso4(){
        assertEquals("elbuod  decaps  sdrow", KataReverse.reverseString("double  spaced  words"));
    }

}
