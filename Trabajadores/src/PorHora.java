public class PorHora extends Empleado {
    private int horas;
    private final int PRECIO_HORA = 5000;

    public PorHora(int cedula, String nombre, int salario, int horas) {
        super(cedula, nombre, salario);
        this.horas = horas;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public int calcularSalario() {
        return horas * PRECIO_HORA;
    }

    @Override
    public String toString() {
        return super.toString() +
                "horas=" + horas +
                ", PRECIO_HORA=" + PRECIO_HORA +
                '}';
    }
}
