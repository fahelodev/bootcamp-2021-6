package katas.rvargas;

import static org.junit.Assert.*;
import org.junit.Test;

public class ReverseWordsTest {

    @Test
    public void testText() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", ReverseWords.reverseWords("The quick brown fox jumps over the lazy dog."));
        assertEquals("elppa", ReverseWords.reverseWords("apple"));
        assertEquals("a b c d", ReverseWords.reverseWords("a b c d"));
        assertEquals("elbuod  decaps  sdrow", ReverseWords.reverseWords("double  spaced  words"));
        //assertEquals("       ", ReverseWords.reverseWords("       "));
        assertEquals("!a !b !c !d", ReverseWords.reverseWords("a! b! c! d!"));
        assertEquals("(/&%$#!@", ReverseWords.reverseWords("@!#$%&/("));
    }

}