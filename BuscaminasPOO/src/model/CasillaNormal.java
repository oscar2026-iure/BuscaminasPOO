package model;

public class CasillaNormal extends CasillaBase {

    private static final long serialVersionUID = 1L;

    private int minasAlrededor;

    public CasillaNormal(int fila, int columna) {
        super(fila, columna);
        this.minasAlrededor = 0;
    }

    @Override
    public boolean tieneMina() {
        return false;
    }

    public int getMinasAlrededor() {
        return minasAlrededor;
    }

    public void setMinasAlrededor(int minasAlrededor) {
        this.minasAlrededor = minasAlrededor;
    }

}