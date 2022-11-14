package com.carrear.bl.Carrera;

import java.sql.SQLException;
import java.util.List;

public interface ICarrera {
    String registrarCurso(Carrera carrera) throws Exception;

    List<Carrera> obtenerCarreras() throws Exception;

    String asosiar(Carrera carrera) throws Exception;
}
