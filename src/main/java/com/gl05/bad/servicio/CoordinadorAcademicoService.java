package com.gl05.bad.servicio;

import com.gl05.bad.domain.CoordinadorAcademico;
import java.util.List;

public interface CoordinadorAcademicoService {
  
  public List<CoordinadorAcademico> listarCoordinadores();
  
  public void agregarCA(CoordinadorAcademico coordinador);
  
  public void eliminarCA(CoordinadorAcademico coordinador);
  
  public CoordinadorAcademico encontrarCA(CoordinadorAcademico coordinador);
  
  public void proIsertarCA(String cod, String nombre, String apellido);
  

  
}
