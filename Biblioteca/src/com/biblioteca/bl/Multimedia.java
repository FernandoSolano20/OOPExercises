package com.biblioteca.bl;

import java.time.LocalDate;
import java.util.Objects;

public class Multimedia extends Material {
    private String formato;
    private int duracion;
    private String idioma;

    public Multimedia(int signatura, LocalDate fechaCompra, boolean restrigido, String tema, String formato, int duracion, String idioma) {
        super(signatura, fechaCompra, restrigido, tema);
        this.formato = formato;
        this.duracion = duracion;
        this.idioma = idioma;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "'" + super.toString() + '\'' +
                "formato='" + formato + '\'' +
                ", duracion=" + duracion +
                ", idioma='" + idioma + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o instanceof Multimedia) return false;
        Multimedia that = (Multimedia) o;
        return super.equals(that);
    }
}
