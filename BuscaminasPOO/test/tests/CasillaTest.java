package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.CasillaMina;
import model.CasillaNormal;

public class CasillaTest {

    @Test
    void casillaNormalNoDebeTenerMina() {

        CasillaNormal casilla =
                new CasillaNormal(0,0);

        assertFalse(
                casilla.tieneMina());
    }

    @Test
    void casillaMinaDebeTenerMina() {

        CasillaMina casilla =
                new CasillaMina(0,0);

        assertTrue(
                casilla.tieneMina());
    }

    @Test
    void casillaNuevaDebeEstarOculta() {

        CasillaNormal casilla =
                new CasillaNormal(0,0);

        assertFalse(
                casilla.isDescubierta());
    }

}