package com.biblioteca.bl;

import java.time.LocalDate;
import java.util.Objects;

public class Otros extends Material {
    private String descripcion;

    public Otros(int signatura, LocalDate fechaCompra, boolean restrigido, String tema, String descripcion) {
        super(signatura, fechaCompra, restrigido, tema);
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Otros{" +
                "'" + super.toString() + '\'' +
                "descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o instanceof Otros) return false;
        Otros otros = (Otros) o;
        return super.equals(otros);
    }
}
