package util;

import exceptions.CoordenadaInvalidaException;
import model.Coordenada;

public class CoordenadaUtils {

    public static Coordenada convertir(
            String texto)
            throws CoordenadaInvalidaException {

        texto = texto.trim().toUpperCase();

        if (texto.length() < 2) {

            throw new CoordenadaInvalidaException();
        }

        char letra = texto.charAt(0);

        int fila = letra - 'A';

        int columna;

        try {

            columna =
                    Integer.parseInt(
                            texto.substring(1)) - 1;

        } catch (NumberFormatException e) {

            throw new CoordenadaInvalidaException();
        }

        if (fila < 0
                || fila > 9
                || columna < 0
                || columna > 9) {

            throw new CoordenadaInvalidaException();
        }

        return new Coordenada(
                fila,
                columna);
    }
}