package com.gl05.bad.servicio;

import com.gl05.bad.dao.ProfesorCohorteDao;
import com.gl05.bad.domain.ProfesorCohorte;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorCohorteServiceImp implements ProfesorCohorteService {

    @Autowired
    private ProfesorCohorteDao profesorCohorteDao;

    @Override
    public ProfesorCohorte contratarP(ProfesorCohorte profesorCohorte) {
        ProfesorCohorte profesor = profesorCohorteDao.save(profesorCohorte);
        return profesor;
    }

    @Override
    public List<ProfesorCohorte> listaProfesoresC(Long idCohorte) {
        return (List<ProfesorCohorte>) profesorCohorteDao.findProfesByCohorteId(idCohorte);
    }

    @Override
    public void eliminarPC(ProfesorCohorte profesorCohorte) {
        profesorCohorteDao.delete(profesorCohorte);
    }

}
