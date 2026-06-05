package exceptions;

public class CasillaMarcadaException extends Exception {

    private static final long serialVersionUID = 1L;

    public CasillaMarcadaException() {

        super("La casilla está marcada. Desmárcala antes de descubrirla.");
    }
}