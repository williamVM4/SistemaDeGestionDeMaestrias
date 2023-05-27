package com.gl05.bad.servicio;

import com.gl05.bad.domain.AspiranteProfesor;
import java.sql.Blob;
import java.util.List;

public interface AspiranteProfesorService {
  
  public List<AspiranteProfesor> listarAspirantes();
  
  public void agregarAP(AspiranteProfesor aspirante);
  
  public void actualizarAP(AspiranteProfesor aspirante);
  
  public void eliminarAP(AspiranteProfesor aspirante);
  
  public AspiranteProfesor encontrarAP(AspiranteProfesor aspirante);
  
  public void actualizarFoto(AspiranteProfesor aspirante, String nombreCampo, Blob valorCampo);

  public AspiranteProfesor encontrarPorIdUsuario(Integer idUsuario);
}
