package com.carrear.bl.Curso;

import java.util.List;

public interface ICurso {
    List<Curso> obtenerCursos() throws Exception;

    String registrarCurso(Curso curso) throws Exception;
}
