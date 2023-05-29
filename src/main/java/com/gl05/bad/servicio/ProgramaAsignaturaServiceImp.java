
package com.gl05.bad.servicio;

import com.gl05.bad.dao.ProgramaAsignaturaDao;
import com.gl05.bad.domain.ProgramaAsignatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramaAsignaturaServiceImp implements ProgramaAsignaturaService{

    @Autowired
    private ProgramaAsignaturaDao programaAsignaturaDao;

    @Override
    public long encontrarPrograma(Long listProgramaAsignaturaId) {
        return programaAsignaturaDao.findProgramaByAsignaturaId(listProgramaAsignaturaId);
    }

    @Override
    public ProgramaAsignatura encontrarP(Long idProgramaAsignatura) {
        return programaAsignaturaDao.findById(idProgramaAsignatura).orElse(null);
    }
     
}
