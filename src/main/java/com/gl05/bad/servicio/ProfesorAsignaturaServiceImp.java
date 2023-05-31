package com.gl05.bad.servicio;

import com.gl05.bad.dao.ProfesorAsignaturaDao;
import com.gl05.bad.domain.ProfesorAsignatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorAsignaturaServiceImp implements ProfesorAsignaturaService {

    @Autowired
    private ProfesorAsignaturaDao profesorAsignaturaDao;
    
    @Override
    public void agregarA(ProfesorAsignatura profesorAsignatura) {
        profesorAsignaturaDao.save(profesorAsignatura);
    }

}
