package com.carrear.tl;

import com.carrear.bl.Carrera.Carrera;
import com.carrear.bl.Carrera.ICarrera;
import com.carrear.bl.Curso.Curso;
import com.carrear.bl.Curso.ICurso;
import com.carrear.bl.factory.DaoFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private DaoFactory factory;
    private ICurso cursoDao;
    private ICarrera carreraDao;

    public Controller() {
        factory = DaoFactory.getDaoFactory(1);
        cursoDao = factory.getCursoDao();
        carreraDao = factory.getCarreraDao();
    }

    public String registrarCurso(int codigo, String nombre, int creditos) throws Exception {
        Curso curso = new Curso(codigo,nombre,creditos);
        String response = "";
        if(buscarCurso(curso.getCodigo()) == null){
            return cursoDao.registrarCurso(curso);
        }
        return "Error";
    }

    private Curso buscarCurso(int codigo) throws Exception {
        List<Curso> cursos = obtenerCursos();
        Curso cursoResponse = null;
        for (Curso curso1:cursos) {
            if (curso1.getCodigo() == codigo){
                cursoResponse = curso1;
                break;
            }
        }
        return cursoResponse;
    }

    private List<Curso> obtenerCursos() throws Exception {
        return cursoDao.obtenerCursos();
    }

    public List<String> listarCursos() throws Exception {
        List<Curso> cursos = obtenerCursos();
        List<String> response = new ArrayList<>();
        for (Curso curso:cursos) {
            response.add(curso.toString());
        }
        return response;
    }


    public String registrarCarrera(int codigo, String nombre) throws Exception {
        Carrera carrera = new Carrera(codigo,nombre);
        String response = "";
        if(buscarCarrea(carrera.getCodigo()) == null){
            return carreraDao.registrarCurso(carrera);
        }
        return "Error";
    }

    private Carrera buscarCarrea(int codigo) throws Exception {
        List<Carrera> carreras = obtenerCarreras();
        Carrera carrera = null;
        for (Carrera carrera1:carreras) {
            if (carrera1.getCodigo() == codigo){
                carrera = carrera1;
                break;
            }
        }
        return carrera;
    }

    private List<Carrera> obtenerCarreras() throws Exception {
        return carreraDao.obtenerCarreras();
    }

    public List<String> listarCarreras() throws Exception {
        List<Carrera> carreras = obtenerCarreras();
        List<String> response = new ArrayList<>();
        for (Carrera carrera:carreras) {
            response.add(carrera.toString());
        }
        return response;
    }

    public String agregarCursoCarrera(int codigoCarrera, int codigoCurso) throws Exception {
        Carrera carrera = buscarCarrea(codigoCarrera);
        Curso curso = buscarCurso(codigoCurso);
        if(carrera != null && curso != null){
            carrera.setCursos(curso);
            return carreraDao.asosiar(carrera);
        }
        return "Error";
    }
}
