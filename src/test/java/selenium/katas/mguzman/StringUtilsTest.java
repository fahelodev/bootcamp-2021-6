package katas.mguzman;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void testUpper() {
        assertEquals("HELLO WORLD", StringUtils.toAlternativeString("hello world"));
    }

    @Test
    public void testLower(){
        assertEquals("hello world", StringUtils.toAlternativeString("HELLO WORLD"));
    }

    @Test
    public void testMixed(){
        assertEquals("hEllO wOrld", StringUtils.toAlternativeString("HeLLo WoRLD"));
    }

    @Test
    public void testOfTest(){
        assertEquals("Hello World", StringUtils.toAlternativeString(StringUtils.toAlternativeString("Hello World")));
    }

    @Test
    public void testNumber(){
        assertEquals("12345", StringUtils.toAlternativeString("12345"));
    }
    @Test
    public void testMixedNumber(){
        assertEquals("1A2B3C4D5E", StringUtils.toAlternativeString("1a2b3c4d5e"));
    }
    @Test
    public void testPoint(){
        assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", StringUtils.toAlternativeString("StringUtils.toAlternatingCase"));

    }

    @Test
    public void kataTitleTests() {

        assertEquals("altERnaTIng cAsE <=> ALTerNAtiNG CaSe", StringUtils.toAlternativeString("ALTerNAtiNG CaSe <=> altERnaTIng cAsE"));
    }

}
