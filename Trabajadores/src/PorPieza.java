public class PorPieza extends Empleado {
    private int pieza;
    private int montoPieza;

    public PorPieza(int cedula, String nombre, int salario, int pieza, int montoPieza) {
        super(cedula, nombre, salario);
        this.pieza = pieza;
        this.montoPieza = montoPieza;
    }

    public int getPieza() {
        return pieza;
    }

    public void setPieza(int pieza) {
        this.pieza = pieza;
    }

    public int getMontoPieza() {
        return montoPieza;
    }

    public void setMontoPieza(int montoPieza) {
        this.montoPieza = montoPieza;
    }

    @Override
    public int calcularSalario() {
        return pieza * montoPieza;
    }

    @Override
    public String toString() {
        return super.toString()+
                "pieza=" + pieza +
                ", montoPieza=" + montoPieza +
                '}';
    }
}
