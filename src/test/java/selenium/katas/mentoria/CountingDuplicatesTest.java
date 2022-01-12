package katas.mentoria;

import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertEquals(0, CountingDuplicates.duplicateCount("abcde"));

    }

    @Test
    public void devuelveDos (){
        Assert.assertEquals(2, CountingDuplicates.duplicateCount("aabbcde"));
    }

    @Test
    public void devuelveDosCaseInsensitive (){
        Assert.assertEquals(2, CountingDuplicates.duplicateCount("aabBcde"));
    }
    @Test
    public void devuelveUnoCaracterRepetido (){
        Assert.assertEquals(1, CountingDuplicates.duplicateCount("aaaaaaaabcdaa"));
    }

    @Test
    public void devuelveDosAlfaNumerico (){
        Assert.assertEquals(2, CountingDuplicates.duplicateCount("aA11"));
    }

    @Test
    public void neg_IngresoDeStringNoAlfaNumerico(){
        Assert.assertEquals(-1, CountingDuplicates.duplicateCount("!@##$%^@"));
    }
}
