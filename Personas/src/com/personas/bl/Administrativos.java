package com.personas.bl;

import java.util.Objects;

public class Administrativos extends Persona {
    private char nombramiento;
    private int cantidadHoras;

    public Administrativos(int id, String nombre, String apellido, char nombramiento, int cantidadHoras) {
        super(id, nombre, apellido);
        this.nombramiento = nombramiento;
        this.cantidadHoras = cantidadHoras;
    }

    public char getNombramiento() {
        return nombramiento;
    }

    public void setNombramiento(char nombramiento) {
        this.nombramiento = nombramiento;
    }

    public int getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(int cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    @Override
    public String toString() {
        return "Administrativos{" +
                "nombramiento=" + nombramiento +
                ", cantidadHoras=" + cantidadHoras +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Administrativos that = (Administrativos) o;
        return nombramiento == that.nombramiento &&
                cantidadHoras == that.cantidadHoras;
    }
}
