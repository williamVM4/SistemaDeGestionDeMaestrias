package com.gl05.bad.servicio;

import com.gl05.bad.dao.AsignaturaDao;
import com.gl05.bad.domain.Asignatura;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AsignaturaServiceImp implements AsignaturaService{
    @Autowired
    private AsignaturaDao asignaturaDao;
    
    @Override
    @Transactional(readOnly=true)
    public DataTablesOutput<Asignatura> listarAsignatura(DataTablesInput input) {
       return (DataTablesOutput<Asignatura>)asignaturaDao.findAll(input);
    }
    
    @Override
    @Transactional(readOnly=true)
    public Collection<Asignatura> listarAsignatura() {
        return (Collection<Asignatura>)asignaturaDao.findAll();
    }

    @Override
    public void agregarA(Asignatura asignatura) {
        asignaturaDao.save(asignatura);
    }

    @Override
    public void eliminarA(Asignatura asignatura) {
        asignaturaDao.delete(asignatura);
    }

    @Override
    public Asignatura encontrarA(Long Asignatura) {
        return asignaturaDao.findById(Asignatura).orElse(null);
    }
    @Override
    public void actualizarA(Asignatura asignatura) {
        System.out.println(1);
        // Verifica si el área de conocimiento existe en la base de datos
        if (asignaturaDao.existsById(asignatura.getIdAsignatura())) {
            // Actualiza el área de conocimiento en la base de datos
            asignaturaDao.save(asignatura);
        } else {
            // El área de conocimiento no existe, puedes lanzar una excepción o manejar el caso según tus necesidades
            throw new IllegalArgumentException("El área de conocimiento especificada no existe.");
        }
    }
}
