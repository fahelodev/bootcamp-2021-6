package fabriciof;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KataCasoAlternativoTest {

    @Test
    public void fixedTests() {
        assertEquals("HELLO WORLD", fabricioKata1.toAlternativeString("hello world"));
        assertEquals("hello world", fabricioKata1.toAlternativeString("HELLO WORLD"));
        assertEquals("HELLO world", fabricioKata1.toAlternativeString("hello WORLD"));
        assertEquals("hEllO wOrld", fabricioKata1.toAlternativeString("HeLLo WoRLD"));
        assertEquals("Hello World", fabricioKata1.toAlternativeString(fabricioKata1.toAlternativeString("Hello World")));
        assertEquals("12345", fabricioKata1.toAlternativeString("12345"));
        assertEquals("1A2B3C4D5E", fabricioKata1.toAlternativeString("1a2b3c4d5e"));
        assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", fabricioKata1.toAlternativeString("StringUtils.toAlternatingCase"));
    }

    @Test
    public void kataTitleTests() {
        assertEquals("ALTerNAtiNG CaSe", fabricioKata1.toAlternativeString("altERnaTIng cAsE"));
        assertEquals("altERnaTIng cAsE", fabricioKata1.toAlternativeString("ALTerNAtiNG CaSe"));
        assertEquals("ALTerNAtiNG CaSe <=> altERnaTIng cAsE", fabricioKata1.toAlternativeString("altERnaTIng cAsE <=> ALTerNAtiNG CaSe"));
        assertEquals("altERnaTIng cAsE <=> ALTerNAtiNG CaSe", fabricioKata1.toAlternativeString("ALTerNAtiNG CaSe <=> altERnaTIng cAsE"));
    }

}
