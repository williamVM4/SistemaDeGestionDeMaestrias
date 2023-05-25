package com.gl05.bad.servicio;

import com.gl05.bad.dao.EstudianteDao;
import com.gl05.bad.domain.Estudiante;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServiceImp implements EstudianteService{

    @Autowired
    private EstudianteDao estudianteDao;
    
    @Override
    public List<Estudiante> listaEstudiantes() {
         return (List<Estudiante>) estudianteDao.findAll();
    }

    @Override
    public void AgregarEstudiante(Estudiante estudiante) {
       estudianteDao.save(estudiante);
    }

    @Override
    public Estudiante encontrarEstudiante(Long estudiante) {
         return estudianteDao.findById(estudiante).orElse(null);
    }

    @Override
    public void eliminarEstudiante(Estudiante estudiante) {
        estudianteDao.delete(estudiante);
    }

    @Override
    public void actualizarEstudiante(Estudiante estudiante) {
        if (estudianteDao.existsById(estudiante.getIdEstudiante())) {
            // Actualiza el estudiante en la base de datos
            estudianteDao.save(estudiante);
        } else {
            throw new IllegalArgumentException("El estudiante no existe.");
        }
    }
    
}
