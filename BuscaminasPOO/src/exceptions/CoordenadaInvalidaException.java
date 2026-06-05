package exceptions;

public class CoordenadaInvalidaException extends Exception {

    private static final long serialVersionUID = 1L;

    public CoordenadaInvalidaException() {

        super("La coordenada ingresada no es válida.");
    }
}