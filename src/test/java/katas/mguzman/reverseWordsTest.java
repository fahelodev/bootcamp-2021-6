package katas.mguzman;
import static org.junit.Assert.*;

import org.junit.Test;

public class reverseWordsTest {
    @Test
    public void testText() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", ReverseWords.reverseWords("The quick brown fox jumps over the lazy dog."));
    }

    @Test
    public void testApple() {
        assertEquals("elppa", ReverseWords.reverseWords("apple"));
    }

    @Test
    public void testAlpha() {
        assertEquals("a b c d", ReverseWords.reverseWords("a b c d"));
    }

    @Test
    public void testDoubleSpaced() {
        assertEquals("elbuod  decaps  sdrow", ReverseWords.reverseWords("double  spaced  words"));
    }
    @Test
    public void testAllSpace(){
        assertEquals("       ", ReverseWords.reverseWords("       "));
    }
}