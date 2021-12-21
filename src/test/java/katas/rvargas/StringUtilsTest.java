package katas.rvargas;

import static org.junit.Assert.*;
import org.junit.Test;
public class StringUtilsTest {

    @Test
    public void fixedTests() {
        assertEquals("HELLO WORLD", StringUtils.toAlternativeString("hello world"));
        assertEquals("hello world", StringUtils.toAlternativeString("HELLO WORLD"));
        assertEquals("HELLO world", StringUtils.toAlternativeString("hello WORLD"));
        assertEquals("hEllO wOrld", StringUtils.toAlternativeString("HeLLo WoRLD"));
        assertEquals("Hello World", StringUtils.toAlternativeString(StringUtils.toAlternativeString("Hello World")));
        assertEquals("12345", StringUtils.toAlternativeString("12345"));
        assertEquals("1A2B3C4D5E", StringUtils.toAlternativeString("1a2b3c4d5e"));
        assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", StringUtils.toAlternativeString("StringUtils.toAlternatingCase"));
    }

}