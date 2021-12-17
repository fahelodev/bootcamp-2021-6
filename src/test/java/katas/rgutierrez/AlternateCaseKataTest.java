package rgutierrez;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlternateCaseKataTest {

    @Test
    public void pruebaUno (){
        assertEquals("HELLO WORLD", AlternateCaseKata.toAlternativeString("hello world"));
    }

    @Test
    public void pruebaDos (){
        assertEquals("hello world", AlternateCaseKata.toAlternativeString("HELLO WORLD"));
    }

    @Test
    public void pruebaTres (){
        assertEquals("HELLO world", AlternateCaseKata.toAlternativeString("hello WORLD"));
    }

    @Test
    public void pruebaCuatro (){
        assertEquals("hEllO wOrld", AlternateCaseKata.toAlternativeString("HeLLo WoRLD"));
    }

    @Test
    public void pruebaCinco (){
        assertEquals("Hello World", AlternateCaseKata.toAlternativeString(AlternateCaseKata.toAlternativeString("Hello World")));
    }

    @Test
    public void pruebaSeis (){
        assertEquals("12345", AlternateCaseKata.toAlternativeString("12345"));
    }

    @Test
    public void pruebaSiete (){
        assertEquals("1A2B3C4D5E", AlternateCaseKata.toAlternativeString("1a2b3c4d5e"));
    }

    @Test
    public void pruebaOcho (){
        assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", AlternateCaseKata.toAlternativeString("StringUtils.toAlternatingCase"));;
    }

}
