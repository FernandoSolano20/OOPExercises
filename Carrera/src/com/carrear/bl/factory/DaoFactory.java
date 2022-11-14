package com.carrear.bl.factory;

import com.carrear.bl.Carrera.ICarrera;
import com.carrear.bl.Curso.ICurso;

public abstract class DaoFactory {
    public static DaoFactory getDaoFactory(int tipo){
        switch (tipo){
            // es MySql
            case 1:
                return new MysqlDaoFactory();

            default: return null;
        }
    }

    public abstract ICarrera getCarreraDao();
    public abstract ICurso getCursoDao();
}
