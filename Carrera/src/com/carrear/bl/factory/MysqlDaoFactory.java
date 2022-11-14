package com.carrear.bl.factory;

import com.carrear.bl.Carrera.CarreraDao;
import com.carrear.bl.Carrera.ICarrera;
import com.carrear.bl.Curso.CursoDao;
import com.carrear.bl.Curso.ICurso;

public class MysqlDaoFactory extends DaoFactory{
    @Override
    public ICarrera getCarreraDao() {
        return new CarreraDao();
    }

    @Override
    public ICurso getCursoDao() {
        return new CursoDao();
    }
}
