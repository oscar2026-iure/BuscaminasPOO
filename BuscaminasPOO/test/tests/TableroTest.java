package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Tablero;

public class TableroTest {

    @Test
    void tableroDebeExistir() {

        Tablero tablero =
                new Tablero();

        assertNotNull(tablero);
    }

    @Test
    void tableroDebeSer10x10() {

        Tablero tablero =
                new Tablero();

        assertEquals(
                10,
                tablero.getTamano());
    }

    @Test
    void coordenadaValidaDebeRetornarTrue() {

        Tablero tablero =
                new Tablero();

        assertTrue(
                tablero.esValida(5,5));
    }

    @Test
    void coordenadaInvalidaDebeRetornarFalse() {

        Tablero tablero =
                new Tablero();

        assertFalse(
                tablero.esValida(-1,20));
    }

}
