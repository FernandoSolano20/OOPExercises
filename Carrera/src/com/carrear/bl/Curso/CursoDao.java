package com.carrear.bl.Curso;

import com.carrear.bl.Carrera.Carrera;
import com.carrear.dl.AccessData;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursoDao implements ICurso {
    private AccessData dataAccess = new AccessData();
    @Override
    public List<Curso> obtenerCursos() throws Exception {
        List<Curso> cursos = new ArrayList<>();
        Curso curso = null;
        String queryString = "SELECT * FROM Curso";
        ResultSet result = dataAccess.selectData(queryString);
        try{
            while (result.next())
            {
                int id = result.getInt("codigo");
                String name = result.getString("nombre");
                int creditos = result.getInt("creditos");
                curso = new Curso(id,name,creditos);

                cursos.add(curso);
            }
        }
        catch (Exception e){
            throw new Exception("error en db");
        }
        return cursos;
    }

    @Override
    public String registrarCurso(Curso curso) throws Exception {
        String message = "";
        String queryString = "INSERT INTO Curso(codigo, nombre, creditos) " +
                "VALUES("+ curso.getCodigo() +", '" + curso.getNombre() + "', '" + curso.getCreditos() + "')";
        try {
            message = dataAccess.insertData(queryString);
        } catch (Exception e) {
            throw new Exception("error en db");
        }
        return message;
    }
}
