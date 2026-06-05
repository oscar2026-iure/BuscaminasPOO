package model;

public class CasillaMina extends CasillaBase {

    private static final long serialVersionUID = 1L;

    public CasillaMina(int fila, int columna) {
        super(fila, columna);
    }

    @Override
    public boolean tieneMina() {
        return true;
    }

}