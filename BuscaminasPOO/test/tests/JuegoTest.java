package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Juego;

public class JuegoTest {

    @Test
    void juegoDebeCrearse() {

        Juego juego =
                new Juego("Jack");

        assertNotNull(juego);
    }

    @Test
    void jugadorDebeExistir() {

        Juego juego =
                new Juego("Jack");

        assertEquals(
                "Jack",
                juego.getJugador()
                        .getNombre());
    }

    @Test
    void juegoNoDebeComenzarTerminado() {

        Juego juego =
                new Juego("Jack");

        assertFalse(
                juego.isTerminado());
    }

    @Test
    void juegoNoDebeComenzarGanado() {

        Juego juego =
                new Juego("Jack");

        assertFalse(
                juego.isVictoria());
    }

}
