package com.carrear.bl.Carrera;

import com.carrear.bl.Curso.Curso;
import com.carrear.dl.AccessData;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarreraDao implements ICarrera {
    private AccessData dataAccess = new AccessData();
    @Override
    public String registrarCurso(Carrera carrera) throws Exception {
        String message = "";
        String queryString = "INSERT INTO Carrera(codigo, nombre) " +
                "VALUES("+ carrera.getCodigo() +", '" + carrera.getNombre() + "')";
        try {
            message = dataAccess.insertData(queryString);
        } catch (Exception e) {
            throw new Exception("error en db");
        }
        return message;
    }

    @Override
    public List<Carrera> obtenerCarreras() throws Exception {
        List<Carrera> carreras = new ArrayList<>();
        Carrera carrera = null;
        String queryString = "SELECT * FROM Carrera";
        ResultSet result = dataAccess.selectData(queryString);
        try{
            while (result.next())
            {
                int id = result.getInt("codigo");
                String name = result.getString("nombre");
                carrera = new Carrera(id,name);

                Curso curso = null;
                String queryStringGender = "SELECT * FROM CarreraCurso as cu " +
                        "INNER JOIN Curso as ca " +
                        "ON cu.codigoCurso = ca.codigo " +
                        "WHERE cu.codigoCarrera = " + carrera.getCodigo();
                ResultSet resultCurso = dataAccess.selectData(queryStringGender);
                try{
                    while (resultCurso.next())
                    {
                        int idCurso = resultCurso.getInt("codigo");
                        String nameCurso = resultCurso.getString("nombre");
                        int creditos = resultCurso.getInt("creditos");
                        curso = new Curso(idCurso,nameCurso,creditos);
                        carrera.setCursos(curso);
                    }
                }
                catch (Exception e){
                    throw new Exception("error en db");
                }

                carreras.add(carrera);
            }
        }
        catch (Exception e){
            throw new Exception("error en db");
        }
        return carreras;
    }

    @Override
    public String asosiar(Carrera carrera) throws Exception {
        String message = "";
        List<Curso> cursos = carrera.getCursos();
        for (Curso curso:cursos) {
            String queryString = "INSERT INTO CarreraCurso (codigoCarrera, codigoCurso) " +
                    "VALUES('"+ carrera.getCodigo() +"', '" + curso.getCodigo() +"')";
            try {
                message = dataAccess.insertData(queryString);
            } catch (Exception e) {
                throw new Exception("error en db");
            }
        }
        return message;
    }
}
