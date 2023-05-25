package com.gl05.bad.servicio;

import com.gl05.bad.domain.Estudiante;
import java.util.List;

public interface EstudianteService {
    
    public List<Estudiante> listaEstudiantes();
   
    public void AgregarEstudiante(Estudiante estudiante);
    
    public Estudiante encontrarEstudiante(Long estudiante);
    
    public void eliminarEstudiante(Estudiante estudiante);
    
    public void actualizarEstudiante(Estudiante estudiante);
    
}
