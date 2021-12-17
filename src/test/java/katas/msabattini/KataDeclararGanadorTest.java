package msabattini;
import org.junit.Test;
import static org.junit.Assert.*;


public class KataDeclararGanadorTest {
    @Test
    public void basicTests() {
        assertEquals("Lew", KataDeclararGanador.declararGanador(new Luchador("Lew", 10, 2),new Luchador("Harry", 5, 4), "Lew"));
        assertEquals("Harry",KataDeclararGanador.declararGanador(new Luchador("Lew", 10, 2),new Luchador("Harry", 5, 4), "Harry"));
        assertEquals("Harald", KataDeclararGanador.declararGanador(new Luchador("Harald", 20, 5), new Luchador("Harry", 5, 4), "Harry"));
        assertEquals("Harald", KataDeclararGanador.declararGanador(new Luchador("Harald", 20, 5), new Luchador("Harry", 5, 4), "Harald"));
        assertEquals("Harald", KataDeclararGanador.declararGanador(new Luchador("Jerry", 30, 3), new Luchador("Harald", 20, 5), "Jerry"));
        assertEquals("Harald", KataDeclararGanador.declararGanador(new Luchador("Jerry", 30, 3), new Luchador("Harald", 20, 5), "Harald"));
        assertEquals(" ", KataDeclararGanador.declararGanador(new Luchador("Jerry", 30, 3), new Luchador(" ", 20, 5), "Harald"));

    }



}
