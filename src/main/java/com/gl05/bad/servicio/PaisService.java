package com.gl05.bad.servicio;

import com.gl05.bad.domain.Pais;
import java.util.List;

public interface PaisService {
  
  public List<Pais> listarPaises();
  
  public void agregarP(Pais pais);
  
  public void eliminarP(Pais pais);
  
  public Pais encontrarP(Pais pais);

}
