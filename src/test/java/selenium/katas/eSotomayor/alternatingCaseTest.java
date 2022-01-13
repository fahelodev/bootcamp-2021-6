package eSotomayor;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;


public class alternatingCaseTest {
    @Test
    public void alternar() {
        assertEquals("hello world", alternatingCase.cadenaalternativa("HELLO WORLD"));
        assertEquals("HELLO WORLD", alternatingCase.cadenaalternativa("hello world"));
        assertEquals("hello WORLD", alternatingCase.cadenaalternativa("HELLO world"));
        assertEquals("HeLLo WoRLD", alternatingCase.cadenaalternativa("hEllO wOrld"));
        assertEquals("12345", alternatingCase.cadenaalternativa("12345"));
        assertEquals("1a2b3c4d5e", alternatingCase.cadenaalternativa("1A2B3C4D5E"));
        assertEquals("StringUtils.toAlternatingCase", alternatingCase.cadenaalternativa("sTRINGuTILS.TOaLTERNATINGcASE"));
    }

}
