package com.gl05.bad.servicio;

import com.gl05.bad.domain.Asignatura;
import java.util.Collection;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

public interface AsignaturaService {
    
  public DataTablesOutput<Asignatura> listarAsignatura(DataTablesInput input);
  
  public Collection<Asignatura> listarAsignatura();
  
  public void agregarA(Asignatura area);
  
  public void eliminarA(Asignatura area);
  
  public Asignatura encontrarA(Long area);
  
  public void actualizarA(Asignatura as);
}
