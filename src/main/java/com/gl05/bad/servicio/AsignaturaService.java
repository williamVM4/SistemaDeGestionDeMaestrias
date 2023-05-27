package com.gl05.bad.servicio;

import com.gl05.bad.domain.Asignatura;
import java.util.Collection;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

public interface AsignaturaService {
    
  public DataTablesOutput<Asignatura> listarAsignatura(DataTablesInput input);
  
  public Collection<Asignatura> listarAsignatura();
  
  public void agregarA(Asignatura asignatura);
  
  public void AgregarAsig(String codigoAsignatura, String nombreAsignatura, int uv, int numeroCorrelativo, int ciclo, long idAreaC, long idMalla, int duracion, int horasT, int horasP, int horaCiclo, String introduccion, String descipcionPrograma, String objetivo, String metodologia, String sistemaEvaluacion, String bibliografia, String actividad, int ponderacion);
  
  public void eliminarA(Asignatura asignatura);
  
  public Asignatura encontrarA(Asignatura asignatura);
  
  public void actualizarA(Asignatura asignatura);
}
