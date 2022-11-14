public class PorComision extends Empleado {
    private int comision;
    private int piezas;

    public PorComision(int cedula, String nombre, int salario, int comision, int piezas) {
        super(cedula, nombre, salario);
        this.comision = comision;
        this.piezas = piezas;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public int getPiezas() {
        return piezas;
    }

    public void setPiezas(int piezas) {
        this.piezas = piezas;
    }

    @Override
    public int calcularSalario() {
        return comision * piezas;
    }

    @Override
    public String toString() {
        return super.toString() +
                "comision=" + comision +
                ", piezas=" + piezas +
                '}';
    }
}
