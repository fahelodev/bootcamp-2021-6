import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Contar el número de duplicados
 *
 * Escriba la función duplicateCount, que devuelva
 * el numero (entero) de letras duplicadas.
 *
 * Condicion 1 del String de entrada: (distinct case-insensitive)
 * No distinguen entre mayúsculas y minúsculas
 *
 * Regla de negocio
 * Suponer que el String de entrada SOLO contiene alfabetos (mayúsculas y minúsculas) y dígitos numericos
 *
 * Ejemplos de retornos de la funcion
 *
 * "abcde" -> 0 # ningún carácter se repite más de una vez
 * "aabbcde" -> 2 # 'a' y 'b'
 * "aabBcde" -> 2 # 'a' aparece dos veces y 'b' dos veces (`b` y` B`)
 * "indivisibility" -> 1 # 'i' aparece seis veces
 * "aA11" -> 2 # 'a' y '1'
 * "ABBA" -> 2 # 'A' y 'B' ocurren dos veces
 */

public class CountingDuplicatesTest {

    @Test
    public void devuelveCero (){
        assertEquals(0,CountingDuplicates.duplicateCount("abcde"));

    }

    @Test
    public void devuelveDos (){
        assertEquals(2,CountingDuplicates.duplicateCount("aabbcde"));
    }

    @Test
    public void devuelveDosCaseInsensitive (){
        assertEquals(2,CountingDuplicates.duplicateCount("aabBcde"));
    }
    @Test
    public void devuelveUnoCaracterRepetido (){
        assertEquals(1,CountingDuplicates.duplicateCount("aaaaaaaaaa"));
    }

    @Test
    public void devuelveDosAlfaNumerico (){
        assertEquals(2,CountingDuplicates.duplicateCount("aA11"));
    }

}
