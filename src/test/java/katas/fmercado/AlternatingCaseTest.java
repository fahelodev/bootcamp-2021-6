package katas.fmercado;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/*public void fixedTests(){
        StringUtils.toAlternativeString("hello world") == "HELLO WORLD"
        StringUtils.toAlternativeString("HELLO WORLD") == "hello world"
        StringUtils.toAlternativeString("hello WORLD") == "HELLO world"
        StringUtils.toAlternativeString("HeLLo WoRLD") == "hEllO wOrld"
        StringUtils.toAlternativeString("12345") == "12345" // Non-alphabetical characters are unaffected
        StringUtils.toAlternativeString("1a2b3c4d5e") == "1A2B3C4D5E"
        StringUtils.toAlternativeString("StringUtils.toAlternatingCase") == "sTRINGuTILS.TOaLTERNATINGcASE"
        }*/

public class AlternatingCaseTest {
    @Test
    public void fixedTest(){
        assertEquals( "HELLO WORLD", AlternatingCase.toAlternativeString( "hello world"));
        assertEquals("hello world", AlternatingCase.toAlternativeString("HELLO WORLD"));
        assertEquals("HELLO world", AlternatingCase.toAlternativeString("hello WORLD"));
        assertEquals("hEllO wOrld", AlternatingCase.toAlternativeString("HeLLo WoRLD"));
        assertEquals("12345", AlternatingCase.toAlternativeString("12345"));
        assertEquals("1a2b3c4d5e", AlternatingCase.toAlternativeString("1A2B3C4D5E"));
        assertEquals("StringUtils.toAlternatingCase", AlternatingCase.toAlternativeString("sTRINGuTILS.TOaLTERNATINGcASE"));
    }
    @Test
    public void kataTitleTests() {
        assertEquals("ALTerNAtiNG CaSe", AlternatingCase.toAlternativeString("altERnaTIng cAsE"));
        assertEquals("altERnaTIng cAsE", AlternatingCase.toAlternativeString("ALTerNAtiNG CaSe"));
        assertEquals("ALTerNAtiNG CaSe <=> altERnaTIng cAsE", AlternatingCase.toAlternativeString("altERnaTIng cAsE <=> ALTerNAtiNG CaSe"));
        assertEquals("altERnaTIng cAsE <=> ALTerNAtiNG CaSe", AlternatingCase.toAlternativeString("ALTerNAtiNG CaSe <=> altERnaTIng cAsE"));
    }

}
