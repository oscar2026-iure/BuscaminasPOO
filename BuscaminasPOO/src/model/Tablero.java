package model;

import java.io.Serializable;
import java.util.Random;

import exceptions.CasillaMarcadaException;
import exceptions.CasillaYaDescubiertaException;
import exceptions.CoordenadaInvalidaException;

public class Tablero implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int TAMANO = 10;
    private static final int MINAS = 10;

    private CasillaBase[][] casillas;

    public Tablero() {
        casillas = new CasillaBase[TAMANO][TAMANO];
        inicializar();
    }

    private void inicializar() {

        crearCasillas();
        colocarMinas();
        calcularNumeros();

    }

    private void crearCasillas() {

        for (int fila = 0; fila < TAMANO; fila++) {

            for (int columna = 0; columna < TAMANO; columna++) {

                casillas[fila][columna] =
                        new CasillaNormal(fila, columna);

            }
        }
    }

    private void colocarMinas() {

        Random random = new Random();

        int minasColocadas = 0;

        while (minasColocadas < MINAS) {

            int fila = random.nextInt(TAMANO);
            int columna = random.nextInt(TAMANO);

            if (!casillas[fila][columna].tieneMina()) {

                casillas[fila][columna] =
                        new CasillaMina(fila, columna);

                minasColocadas++;
            }
        }
    }

    private void calcularNumeros() {

        for (int fila = 0; fila < TAMANO; fila++) {

            for (int columna = 0; columna < TAMANO; columna++) {

                if (casillas[fila][columna].tieneMina()) {
                    continue;
                }

                int minas = contarMinasAlrededor(fila, columna);

                ((CasillaNormal) casillas[fila][columna])
                        .setMinasAlrededor(minas);
            }
        }
    }

    private int contarMinasAlrededor(
            int fila,
            int columna) {

        int contador = 0;

        for (int i = -1; i <= 1; i++) {

            for (int j = -1; j <= 1; j++) {

                int nuevaFila = fila + i;
                int nuevaColumna = columna + j;

                if (esValida(nuevaFila, nuevaColumna)) {

                    if (casillas[nuevaFila][nuevaColumna]
                            .tieneMina()) {

                        contador++;
                    }
                }
            }
        }

        return contador;
    }

    public boolean esValida(
            int fila,
            int columna) {

        return fila >= 0
                && fila < TAMANO
                && columna >= 0
                && columna < TAMANO;
    }

    public CasillaBase getCasilla(
            int fila,
            int columna) {

        return casillas[fila][columna];
    }

    public void marcarCasilla(
            int fila,
            int columna) {

        casillas[fila][columna].marcar();
    }

    public void revelarTodo() {

        for (int fila = 0;
             fila < TAMANO;
             fila++) {

            for (int columna = 0;
                 columna < TAMANO;
                 columna++) {

                casillas[fila][columna]
                        .setDescubierta(true);
            }
        }
    }
    
    public boolean descubrirCasilla(
            int fila,
            int columna)
            throws CasillaYaDescubiertaException,
                   CasillaMarcadaException,
                   CoordenadaInvalidaException {

        if (!esValida(fila, columna)) {

            throw new CoordenadaInvalidaException();
        }

        CasillaBase casilla =
                casillas[fila][columna];

        if (casilla.isDescubierta()) {

            throw new CasillaYaDescubiertaException();
        }

        if (casilla.isMarcada()) {

            throw new CasillaMarcadaException();
        }

        casilla.descubrir();

        if (casilla.tieneMina()) {
            return false;
        }

        if (casilla instanceof CasillaNormal) {

            CasillaNormal normal =
                    (CasillaNormal) casilla;

            if (normal.getMinasAlrededor() == 0) {

                for (int i = -1; i <= 1; i++) {

                    for (int j = -1; j <= 1; j++) {

                        if (i != 0 || j != 0) {

                            descubrirVacias(
                                    fila + i,
                                    columna + j);
                        }
                    }
                }
            }
        }

        return true;
    }

    private void descubrirVacias(
            int fila,
            int columna) {

        if (!esValida(fila, columna)) {
            return;
        }

        CasillaBase casilla =
                casillas[fila][columna];

        if (casilla.isDescubierta()) {
            return;
        }

        if (casilla.tieneMina()) {
            return;
        }

        casilla.setDescubierta(true);

        if (casilla instanceof CasillaNormal) {

            CasillaNormal normal =
                    (CasillaNormal) casilla;

            if (normal.getMinasAlrededor() == 0) {

                for (int i = -1; i <= 1; i++) {

                    for (int j = -1; j <= 1; j++) {

                        if (i != 0 || j != 0) {

                            descubrirVacias(
                                    fila + i,
                                    columna + j);
                        }
                    }
                }
            }
        }
    }

    public int contarCasillasSegurasDescubiertas() {

        int contador = 0;

        for (int fila = 0; fila < TAMANO; fila++) {

            for (int columna = 0; columna < TAMANO; columna++) {

                CasillaBase c =
                        casillas[fila][columna];

                if (!c.tieneMina()
                        && c.isDescubierta()) {

                    contador++;
                }
            }
        }

        return contador;
    }

    public int getTamano() {
        return TAMANO;
    }

    public int getTotalSeguras() {
        return (TAMANO * TAMANO) - MINAS;
    }

}