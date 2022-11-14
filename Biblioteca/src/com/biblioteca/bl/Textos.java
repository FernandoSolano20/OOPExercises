package com.biblioteca.bl;

import java.time.LocalDate;
import java.util.Objects;

public class Textos extends Material {
    private String titulo;
    private String autor;
    private LocalDate publicacion;
    private int numeroPaginas;
    private String idioma;

    public Textos(int signatura, LocalDate fechaCompra, boolean restrigido, String tema, String titulo, String autor, LocalDate publicacion, int numeroPaginas, String idioma) {
        super(signatura, fechaCompra, restrigido, tema);
        this.titulo = titulo;
        this.autor = autor;
        this.publicacion = publicacion;
        this.numeroPaginas = numeroPaginas;
        this.idioma = idioma;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(LocalDate publicacion) {
        this.publicacion = publicacion;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Textos{" +
                "'" + super.toString() + '\'' +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", publicacion=" + publicacion +
                ", numeroPaginas=" + numeroPaginas +
                ", idioma='" + idioma + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o instanceof Textos) return false;
        Textos textos = (Textos) o;
        return super.equals(textos);
    }
}
