package com.gl05.bad.servicio;

import com.gl05.bad.domain.AspiranteProfesor;
import com.gl05.bad.domain.PostulacionCohorte;
import java.util.List;

public interface PostuladoCohorteService {
    
    public List<AspiranteProfesor> listarAreaConocimientos(Long idCohorte);
    
    public void agregarP(PostulacionCohorte postulado);
  
}
