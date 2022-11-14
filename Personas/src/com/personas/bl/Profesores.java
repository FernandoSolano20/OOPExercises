package com.personas.bl;

import java.time.LocalDate;
import java.util.Objects;

public class Profesores extends Persona {
    private String contrato;
    private LocalDate fechaContrato;

    public Profesores(int id, String nombre, String apellido, String contrato, LocalDate fechaContrato) {
        super(id, nombre, apellido);
        this.contrato = contrato;
        this.fechaContrato = fechaContrato;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public LocalDate getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(LocalDate fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    @Override
    public String toString() {
        return "Profesores{" +
                "contrato='" + contrato + '\'' +
                ", fechaContrato=" + fechaContrato +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Profesores that = (Profesores) o;
        return Objects.equals(contrato, that.contrato) &&
                Objects.equals(fechaContrato, that.fechaContrato);
    }
}
