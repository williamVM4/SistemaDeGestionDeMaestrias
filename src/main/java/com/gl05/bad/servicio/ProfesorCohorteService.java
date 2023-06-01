package com.gl05.bad.servicio;

import com.gl05.bad.domain.ProfesorCohorte;
import java.util.List;


public interface ProfesorCohorteService {
    
    public ProfesorCohorte contratarP(ProfesorCohorte profesorCohorte);
    
    public List<ProfesorCohorte> listaProfesoresC(Long idCohorte);
    
    public void eliminarPC(ProfesorCohorte profesorCohorte);
}
