package com.igualdad.bl;

import java.util.Objects;

public class Medico extends Persona{
    private int numeroColegiado;
    private String especialidad;

    public Medico() {
        super();
    }

    public Medico(int cedula, String nombre, String apellidos, int numeroColegiado, String especialidad) {
        super(cedula, nombre, apellidos);
        this.numeroColegiado = numeroColegiado;
        this.especialidad = especialidad;
    }

    public int getNumeroColegiado() {
        return numeroColegiado;
    }

    public void setNumeroColegiado(int numeroColegiado) {
        this.numeroColegiado = numeroColegiado;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "numeroColegiado=" + numeroColegiado +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof  Medico)) return false;
        Medico medico = (Medico) o;
        return numeroColegiado == medico.numeroColegiado;
    }
}
