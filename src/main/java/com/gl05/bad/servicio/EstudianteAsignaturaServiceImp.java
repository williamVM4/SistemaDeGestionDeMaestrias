package com.gl05.bad.servicio;

import com.gl05.bad.dao.EstudianteAsignaturaDao;
import com.gl05.bad.domain.EstudianteAsignatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstudianteAsignaturaServiceImp implements EstudianteAsignaturaService{
    
    @Autowired
    private EstudianteAsignaturaDao estudianteAsignaturaDao;
    
    @Autowired
    public EstudianteAsignaturaServiceImp(EstudianteAsignaturaDao estudianteAsignaturaDao) {
        this.estudianteAsignaturaDao = estudianteAsignaturaDao;
    }
    
    @Override
    @Transactional()
    public void guardarEstudianteAsignatura(EstudianteAsignatura estudianteAsignatura) {
        estudianteAsignaturaDao.save(estudianteAsignatura);
    }
    
}
