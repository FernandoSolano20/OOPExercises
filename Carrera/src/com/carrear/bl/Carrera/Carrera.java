package com.carrear.bl.Carrera;

import com.carrear.bl.Curso.Curso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Carrera {
    private int codigo;
    private String nombre;
    private List<Curso> cursos;

    public Carrera(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        cursos = new ArrayList<>();
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

    @Override
    public String toString() {
        return "Carrera{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", cursos=" + cursos +
                '}';
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Curso curso) {
        this.cursos.add(curso);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrera carrera = (Carrera) o;
        return codigo == carrera.codigo &&
                Objects.equals(nombre, carrera.nombre);
    }
}
