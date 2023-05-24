package com.gl05.bad.servicio;

import com.gl05.bad.domain.EscuelaPostgrado;
import java.util.List;

public interface EscuelaPostgradoService {
   
  public List<EscuelaPostgrado> listarEscuelaPostgrado();
  
  public void agregarEscuela(EscuelaPostgrado escuela);
  
  public void eliminarEscuela(EscuelaPostgrado escuela);
  
  public EscuelaPostgrado encontrarEscuela(Long escuela);
  
  public void actualizarEscuela(EscuelaPostgrado escuela);
    
}

