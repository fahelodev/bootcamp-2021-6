package katas.ifuentes;

import org.junit.Test;
import static org.junit.Assert.*;



    public class convertirCaracteresTest{

        @Test
        public void PruebasFijas() {
            assertEquals("HELLO WORLD", convertirCaracteres.cadenaalternativa("hello world"));
            assertEquals("hello world", convertirCaracteres.cadenaalternativa("HELLO WORLD"));
            assertEquals("HELLO world", convertirCaracteres.cadenaalternativa("hello WORLD"));
            assertEquals("hEllO wOrld",convertirCaracteres.cadenaalternativa("HeLLo WoRLD"));
            assertEquals("Hello World", convertirCaracteres.cadenaalternativa(convertirCaracteres.cadenaalternativa("Hello World")));
            assertEquals("12345", convertirCaracteres.cadenaalternativa("12345"));
            assertEquals("1A2B3C4D5E", convertirCaracteres.cadenaalternativa("1a2b3c4d5e"));
            assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", convertirCaracteres.cadenaalternativa("StringUtils.toAlternatingCase"));
        }

        @Test
        public void Pruebas() {
            assertEquals("ALTerNAtiNG CaSe", convertirCaracteres.cadenaalternativa("altERnaTIng cAsE"));
            assertEquals("altERnaTIng cAsE",convertirCaracteres.cadenaalternativa("ALTerNAtiNG CaSe"));
            assertEquals("ALTerNAtiNG CaSe <=> altERnaTIng cAsE", convertirCaracteres.cadenaalternativa("altERnaTIng cAsE <=> ALTerNAtiNG CaSe"));
            assertEquals("altERnaTIng cAsE <=> ALTerNAtiNG CaSe", convertirCaracteres.cadenaalternativa("ALTerNAtiNG CaSe <=> altERnaTIng cAsE"));
        }
    }

