package com.gl05.bad.servicio;

import com.gl05.bad.domain.Asignatura;
import com.gl05.bad.domain.Cohorte;
import com.gl05.bad.domain.EstudianteAsignatura;

public interface EstudianteAsignaturaService {
    public void guardarEstudianteAsignatura(EstudianteAsignatura estudianteAsignatura);
    
    public boolean existeEstudianteAsignatura(Cohorte cohorte, Asignatura asignatura);
}
