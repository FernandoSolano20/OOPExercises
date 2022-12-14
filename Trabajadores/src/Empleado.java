public abstract class Empleado {
    private int cedula;
    private String nombre;
    private int salario;

    public Empleado(int cedula, String nombre, int salario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.salario = salario;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public abstract int calcularSalario();
}
