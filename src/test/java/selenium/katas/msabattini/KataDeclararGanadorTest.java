package katas.msabattini;
import org.junit.Test;
import static org.junit.Assert.*;


public class KataDeclararGanadorTest {
    @Test
    public void basicTests() {
        assertEquals("Lew", KataDeclararGanador.declararGanador(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Lew"));
        assertEquals("Harry",KataDeclararGanador.declararGanador(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald", KataDeclararGanador.declararGanador(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald", KataDeclararGanador.declararGanador(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald"));
        assertEquals("Harald", KataDeclararGanador.declararGanador(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));
        assertEquals("Harald", KataDeclararGanador.declararGanador(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));
        assertEquals(" ", KataDeclararGanador.declararGanador(new Fighter("Jerry", 30, 3), new Fighter(" ", 20, 5), "Harald"));

    }



}
