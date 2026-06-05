package model;

import java.io.Serializable;
import interfaces.Descubrible;

public abstract class CasillaBase
        implements Descubrible, Serializable {

    private static final long serialVersionUID = 1L;

    protected int fila;
    protected int columna;
    protected boolean descubierta;
    protected boolean marcada;

    public CasillaBase(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.descubierta = false;
        this.marcada = false;
    }

    @Override
    public void descubrir() {
        this.descubierta = true;
    }

    public void marcar() {
        this.marcada = !this.marcada;
    }

    public abstract boolean tieneMina();

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean isDescubierta() {
        return descubierta;
    }

    public void setDescubierta(boolean descubierta) {
        this.descubierta = descubierta;
    }

    public boolean isMarcada() {
        return marcada;
    }

    public void setMarcada(boolean marcada) {
        this.marcada = marcada;
    }

}
