package com.personas.bl;

import java.util.Objects;

public class Estudiantes extends Persona {
    private String carrera;
    private int creditos;

    public Estudiantes(int id, String nombre, String apellido, String carrera, int creditos) {
        super(id, nombre, apellido);
        this.carrera = carrera;
        this.creditos = creditos;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return "Estudiantes{" +
                "carrera='" + carrera + '\'' +
                ", creditos=" + creditos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Estudiantes that = (Estudiantes) o;
        return creditos == that.creditos &&
                Objects.equals(carrera, that.carrera);
    }
}
