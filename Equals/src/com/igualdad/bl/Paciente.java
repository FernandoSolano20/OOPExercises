package com.igualdad.bl;

import java.time.LocalDate;
import java.util.Objects;

public class Paciente extends Persona{
    private LocalDate fechaIngreso;
    private String doctor;

    public Paciente() {
    }

    public Paciente(int cedula, String nombre, String apellidos, LocalDate fechaIngreso, String doctor) {
        super(cedula, nombre, apellidos);
        this.fechaIngreso = fechaIngreso;
        this.doctor = doctor;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "fechaIngreso=" + fechaIngreso +
                ", doctor='" + doctor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof  Paciente)) return false;
        Paciente paciente = (Paciente) o;
        return this.getCedula() == paciente.getCedula();
    }
}
