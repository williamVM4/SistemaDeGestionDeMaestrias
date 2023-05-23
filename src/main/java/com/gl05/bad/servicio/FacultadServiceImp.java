
package com.gl05.bad.servicio;

import com.gl05.bad.dao.FacultadDao;
import com.gl05.bad.domain.Facultad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultadServiceImp implements FacultadService{

    @Autowired
    private FacultadDao facultadDao;
    
    @Override
    public List<Facultad> listarFacultad() {
        return (List<Facultad>) facultadDao.findAll();
    }

    @Override
    public void agregarFacultad(Facultad facultad) {
        facultadDao.save(facultad);
    }

    @Override
    public void eliminarFacultad(Facultad facultad) {
       facultadDao.delete(facultad);
    }

    @Override
    public Facultad encontrarFacultad(Long facultad) {
      return facultadDao.findById(facultad).orElse(null);
    }

    @Override
    public void actualizarFacultad(Facultad facultad) {
        
        if (facultadDao.existsById(facultad.getIdFacultad())) {
            facultadDao.save(facultad);
        } else {
            throw new IllegalArgumentException("La facultad especificada no existe.");
        }
    }
    
}
