package com.gl05.bad.servicio;

import com.gl05.bad.dao.PlanEstudioDao;
import com.gl05.bad.domain.PlanEstudio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

@Service
public class PlanEstudioServiceImp implements PlanEstudioService{
   
    @Autowired
    private PlanEstudioDao planEstudioDao;
    
    @Override
    public DataTablesOutput<PlanEstudio> listarPlanEstudio(DataTablesInput input){
        return (DataTablesOutput<PlanEstudio>)planEstudioDao.findAll(input);
    }
    
    @Override
    public void proAgregar(Long idMaestria, String codPlan, String modalidad, long cumMinimo, long notaMinimaAprobacion, short totalAsignaturas, short totalUv, short duracion_carrera, String tituloOtorgar, short anio) {
      planEstudioDao.sp_insert_planestudio(idMaestria, codPlan, modalidad, cumMinimo, notaMinimaAprobacion, totalAsignaturas, totalUv, duracion_carrera, tituloOtorgar, anio);
    }
}
