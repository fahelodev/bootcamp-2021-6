package iromero;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlternatingCaseTest {
    @Test
    public void testUpper() {
        assertEquals("HELLO WORLD", AlternatingCase.toAlternativeString("hello world"));
    }

    @Test
    public void testLower(){
        assertEquals("hello world", AlternatingCase.toAlternativeString("HELLO WORLD"));
    }

    @Test
    public void testMixed(){
        assertEquals("hEllO wOrld", AlternatingCase.toAlternativeString("HeLLo WoRLD"));
    }

    @Test
    public void testOfTest(){
        assertEquals("Hello World", AlternatingCase.toAlternativeString(AlternatingCase.toAlternativeString("Hello World")));
    }

    @Test
    public void testNumber(){
        assertEquals("12345", AlternatingCase.toAlternativeString("12345"));
    }
    @Test
    public void testMixedNumber(){
        assertEquals("1A2B3C4D5E", AlternatingCase.toAlternativeString("1a2b3c4d5e"));
    }
    @Test
    public void testPoint(){
        assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", AlternatingCase.toAlternativeString("StringUtils.toAlternatingCase"));

    }

    @Test
    public void kataTitleTests() {

        assertEquals("altERnaTIng cAsE <=> ALTerNAtiNG CaSe", AlternatingCase.toAlternativeString("ALTerNAtiNG CaSe <=> altERnaTIng cAsE"));
    }
}
