package com.gl05.bad.servicio;

import com.gl05.bad.domain.Facultad;
import java.util.List;

public interface FacultadService {
    
  public List<Facultad> listarFacultad();
  
  public void agregarFacultad(Facultad facultad);
  
  public void eliminarFacultad(Facultad facultad);
  
  public Facultad encontrarFacultad(Long facultad);
  
  public void actualizarFacultad(Facultad facultad);
}
