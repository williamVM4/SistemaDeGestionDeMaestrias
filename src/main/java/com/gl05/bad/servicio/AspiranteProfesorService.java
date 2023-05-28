package com.gl05.bad.servicio;

import com.gl05.bad.domain.AspiranteProfesor;
import java.sql.Blob;
import java.util.List;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import java.util.Collection;

public interface AspiranteProfesorService {
    
  public Collection<AspiranteProfesor> listarAspirantes();
    
  public DataTablesOutput<AspiranteProfesor> listarAspirantes(DataTablesInput input);
  
  //public List<AspiranteProfesor> listarAspirantes();
  
  public void agregarAP(AspiranteProfesor aspirante);
  
  public void actualizarAP(AspiranteProfesor aspirante);
  
  public void eliminarAP(AspiranteProfesor aspirante);
  
  public AspiranteProfesor encontrarAP(AspiranteProfesor aspirante);
  
  public void actualizarFoto(AspiranteProfesor aspirante, String nombreCampo, Blob valorCampo);

  public AspiranteProfesor encontrarPorIdUsuario(Integer idUsuario);
  
  public String generarPassword(int length);
}
