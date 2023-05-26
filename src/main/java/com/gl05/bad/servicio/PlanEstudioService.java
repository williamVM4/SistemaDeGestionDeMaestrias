package com.gl05.bad.servicio;

import com.gl05.bad.domain.PlanEstudio;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

public interface PlanEstudioService {
    
    public DataTablesOutput<PlanEstudio> listarPlanEstudio(DataTablesInput input);
    
    public void proAgregar(Long idMaestria, String codPlan, String modalidad, long cumMinimo, long notaMinimaAprobacion, short totalAsignaturas, short totalUv, short duracion_carrera, String tituloOtorgar, short anio);
    
}
