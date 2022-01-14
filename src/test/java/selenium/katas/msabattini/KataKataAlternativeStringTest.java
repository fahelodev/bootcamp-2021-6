package katas.msabattini;

import org.junit.Test;

import static org.junit.Assert.*;

public class KataKataAlternativeStringTest {

    @Test
    public void fixedTests() {
        assertEquals("HELLO WORLD", KataAlternativeString.AlternativeString("hello world"));
        assertEquals("hello world", KataAlternativeString.AlternativeString("HELLO WORLD"));
        assertEquals("HELLO world", KataAlternativeString.AlternativeString("hello WORLD"));
        assertEquals("hEllO wOrld", KataAlternativeString.AlternativeString("HeLLo WoRLD"));
        assertEquals("Hello World", KataAlternativeString.AlternativeString(KataAlternativeString.AlternativeString("Hello World")));
        assertEquals("12345", KataAlternativeString.AlternativeString("12345"));
        assertEquals("1A2B3C4D5E", KataAlternativeString.AlternativeString("1a2b3c4d5e"));
        assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", KataAlternativeString.AlternativeString("StringUtils.toAlternatingCase"));
    }

    @Test
    public void kataTitleTests() {
        assertEquals("ALTerNAtiNG CaSe", KataAlternativeString.AlternativeString("altERnaTIng cAsE"));
        assertEquals("altERnaTIng cAsE", KataAlternativeString.AlternativeString("ALTerNAtiNG CaSe"));
        assertEquals("ALTerNAtiNG CaSe <=> altERnaTIng cAsE", KataAlternativeString.AlternativeString("altERnaTIng cAsE <=> ALTerNAtiNG CaSe"));
        assertEquals("altERnaTIng cAsE <=> ALTerNAtiNG CaSe", KataAlternativeString.AlternativeString("ALTerNAtiNG CaSe <=> altERnaTIng cAsE"));
    }


}
