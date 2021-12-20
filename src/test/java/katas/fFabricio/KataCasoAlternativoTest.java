package katas.fFabricio;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KataCasoAlternativoTest {

    @Test
    public void fixedTests() {
        assertEquals("HELLO WORLD", CasoAlternativoJava.toAlternativeString("hello world"));
        assertEquals("hello world", CasoAlternativoJava.toAlternativeString("HELLO WORLD"));
        assertEquals("HELLO world", CasoAlternativoJava.toAlternativeString("hello WORLD"));
        assertEquals("hEllO wOrld", CasoAlternativoJava.toAlternativeString("HeLLo WoRLD"));
        assertEquals("Hello World", CasoAlternativoJava.toAlternativeString(CasoAlternativoJava.toAlternativeString("Hello World")));
        assertEquals("12345", CasoAlternativoJava.toAlternativeString("12345"));
        assertEquals("1A2B3C4D5E", CasoAlternativoJava.toAlternativeString("1a2b3c4d5e"));
        assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", CasoAlternativoJava.toAlternativeString("StringUtils.toAlternatingCase"));
    }

    @Test
    public void kataTitleTests() {
        assertEquals("ALTerNAtiNG CaSe", CasoAlternativoJava.toAlternativeString("altERnaTIng cAsE"));
        assertEquals("altERnaTIng cAsE", CasoAlternativoJava.toAlternativeString("ALTerNAtiNG CaSe"));
        assertEquals("ALTerNAtiNG CaSe <=> altERnaTIng cAsE", CasoAlternativoJava.toAlternativeString("altERnaTIng cAsE <=> ALTerNAtiNG CaSe"));
        assertEquals("altERnaTIng cAsE <=> ALTerNAtiNG CaSe", CasoAlternativoJava.toAlternativeString("ALTerNAtiNG CaSe <=> altERnaTIng cAsE"));
    }

}
