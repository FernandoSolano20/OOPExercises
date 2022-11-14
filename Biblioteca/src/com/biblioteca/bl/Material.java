package com.biblioteca.bl;

import java.time.LocalDate;
import java.util.Objects;

public class Material {
    private int signatura;
    private LocalDate fechaCompra;
    private boolean restrigido;
    private String tema;

    public Material(int signatura, LocalDate fechaCompra, boolean restrigido, String tema) {
        this.signatura = signatura;
        this.fechaCompra = fechaCompra;
        this.restrigido = restrigido;
        this.tema = tema;
    }

    public int getSignatura() {
        return signatura;
    }

    public void setSignatura(int signatura) {
        this.signatura = signatura;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public boolean isRestrigido() {
        return restrigido;
    }

    public void setRestrigido(boolean restrigido) {
        this.restrigido = restrigido;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @Override
    public String toString() {
        return "{" +
                "signatura=" + signatura +
                ", fechaCompra=" + fechaCompra +
                ", restrigido=" + restrigido +
                ", tema='" + tema + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o instanceof Material) return false;
        Material material = (Material) o;
        return signatura == material.signatura;
    }
}
