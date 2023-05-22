package com.gl05.bad.servicio;

import com.gl05.bad.domain.AreaConocimiento;
import java.util.List;

public interface AreaConocimientoService {
  public List<AreaConocimiento> listarAreaConocimientos();
  
  public void agregarAC(AreaConocimiento area);
  
  public void eliminarAC(AreaConocimiento area);
  
  public AreaConocimiento encontrarAC(Long area);
  
  public void actualizarAC(AreaConocimiento areaConocimiento);
  
}
