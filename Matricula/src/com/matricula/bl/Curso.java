package com.matricula.bl;

import java.util.ArrayList;
import java.util.Objects;

public class Curso {
    private int codigo;
    private String nombre;
    private int creditos;
    private ArrayList<Curso> cursos = new ArrayList<>();

    public Curso(int codigo, String nombre, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void agregarCurso(Curso curso){
        cursos.add(curso);
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", creditos=" + creditos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return codigo == curso.codigo &&
                creditos == curso.creditos &&
                Objects.equals(nombre, curso.nombre);
    }
}
