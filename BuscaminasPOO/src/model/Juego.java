package model;

import java.io.Serializable;

import exceptions.CasillaMarcadaException;
import exceptions.CasillaYaDescubiertaException;
import exceptions.CoordenadaInvalidaException;

public class Juego implements Serializable {

    private static final long serialVersionUID = 1L;

    private Tablero tablero;
    private Jugador jugador;

    private boolean terminado;
    private boolean victoria;

    public Juego(String nombreJugador) {

        jugador = new Jugador(nombreJugador);
        tablero = new Tablero();

        terminado = false;
        victoria = false;
    }

    public boolean descubrir(
            int fila,
            int columna)
            throws CasillaYaDescubiertaException,
                   CasillaMarcadaException,
                   CoordenadaInvalidaException {

        boolean resultado =
                tablero.descubrirCasilla(
                        fila,
                        columna);

        if (!resultado) {

            tablero.revelarTodo();

            terminado = true;

            victoria = false;

            return false;
        }

        verificarVictoria();

        return true;
    }

    public void marcar(
            int fila,
            int columna) {

        tablero.marcarCasilla(
                fila,
                columna);
    }

    private void verificarVictoria() {

        int descubiertas =
                tablero.contarCasillasSegurasDescubiertas();

        if (descubiertas ==
                tablero.getTotalSeguras()) {

            terminado = true;
            victoria = true;
        }
    }

    public boolean isTerminado() {
        return terminado;
    }

    public boolean isVictoria() {
        return victoria;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Jugador getJugador() {
        return jugador;
    }

}