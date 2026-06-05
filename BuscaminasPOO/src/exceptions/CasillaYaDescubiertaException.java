package exceptions;

public class CasillaYaDescubiertaException extends Exception {

    private static final long serialVersionUID = 1L;

    public CasillaYaDescubiertaException() {

        super("La casilla ya fue descubierta.");
    }
}