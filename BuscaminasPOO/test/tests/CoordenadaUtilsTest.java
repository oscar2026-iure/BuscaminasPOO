package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Coordenada;
import util.CoordenadaUtils;

public class CoordenadaUtilsTest {

    @Test
    void convertirA5() throws Exception {

        Coordenada coordenada =
                CoordenadaUtils
                        .convertir("A5");

        assertEquals(
                0,
                coordenada.getFila());

        assertEquals(
                4,
                coordenada.getColumna());
    }

    @Test
    void convertirJ10() throws Exception {

        Coordenada coordenada =
                CoordenadaUtils
                        .convertir("J10");

        assertEquals(
                9,
                coordenada.getFila());

        assertEquals(
                9,
                coordenada.getColumna());
    }

}