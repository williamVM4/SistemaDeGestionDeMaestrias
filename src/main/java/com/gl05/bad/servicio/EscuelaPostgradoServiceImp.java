
package com.gl05.bad.servicio;

import com.gl05.bad.dao.EscuelaPostgradoDao;
import com.gl05.bad.domain.EscuelaPostgrado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EscuelaPostgradoServiceImp implements EscuelaPostgradoService{

    @Autowired
    private EscuelaPostgradoDao escuelaPostgradoDao;
    
    @Override
    public List<EscuelaPostgrado> listarEscuelaPostgrado() {
        return(List<EscuelaPostgrado>) escuelaPostgradoDao.findAll();
    }

    @Override
    public void agregarEscuela(EscuelaPostgrado escuela) {
        escuelaPostgradoDao.save(escuela);
    }

    @Override
    public void eliminarEscuela(EscuelaPostgrado escuela) {
       escuelaPostgradoDao.delete(escuela);
    }

    @Override
    public EscuelaPostgrado encontrarEscuela(Long escuela) {
        return escuelaPostgradoDao.findById(escuela).orElse(null);
    }

    @Override
    public void actualizarEscuela(EscuelaPostgrado escuela) {
         
        if (escuelaPostgradoDao.existsById(escuela.getIdPostgrado())) {
            escuelaPostgradoDao.save(escuela);
        } else {
            throw new IllegalArgumentException("La escuela de posgrado especificada no existe.");
        }
    }
    
}
