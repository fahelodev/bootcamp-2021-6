package katas.nparco;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlternatingCaseTest {

    @Test
    public void fixedTests() {
        assertEquals("HELLO WORLD", AlternatingCase.toAlternativeString("hello world"));
        assertEquals("hello world", AlternatingCase.toAlternativeString("HELLO WORLD"));
        assertEquals("HELLO world", AlternatingCase.toAlternativeString("hello WORLD"));
        assertEquals("hEllO wOrld", AlternatingCase.toAlternativeString("HeLLo WoRLD"));
        assertEquals("Hello World", AlternatingCase.toAlternativeString(AlternatingCase.toAlternativeString("Hello World")));
        assertEquals("12345", AlternatingCase.toAlternativeString("12345"));
        assertEquals("1A2B3C4D5E", AlternatingCase.toAlternativeString("1a2b3c4d5e"));
        assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", AlternatingCase.toAlternativeString("StringUtils.toAlternatingCase"));
    }

    @Test
    public void kataTitleTests() {
        assertEquals("ALTerNAtiNG CaSe", AlternatingCase.toAlternativeString("altERnaTIng cAsE"));
        assertEquals("altERnaTIng cAsE", AlternatingCase.toAlternativeString("ALTerNAtiNG CaSe"));
        assertEquals("ALTerNAtiNG CaSe <=> altERnaTIng cAsE", AlternatingCase.toAlternativeString("altERnaTIng cAsE <=> ALTerNAtiNG CaSe"));
        assertEquals("altERnaTIng cAsE <=> ALTerNAtiNG CaSe", AlternatingCase.toAlternativeString("ALTerNAtiNG CaSe <=> altERnaTIng cAsE"));
    }
}