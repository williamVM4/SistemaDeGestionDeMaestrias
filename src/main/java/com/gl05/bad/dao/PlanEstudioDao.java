package com.gl05.bad.dao;

import com.gl05.bad.domain.PlanEstudio;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface PlanEstudioDao extends DataTablesRepository<PlanEstudio, Long>{
    @Procedure(name = "sp_insert_planestudio")
    void sp_insert_planestudio(
        @Param("p_id_maestria") Long idMaestria,
        @Param("p_cod_plan") String codPlan,
        @Param("p_modalidad") String modalidad,
        @Param("p_cum_minimo") long cumMinimo,
        @Param("p_nota_minima_aprobacion") long notaMinimaAprobacion,
        @Param("p_total_asignaturas") short totalAsignaturas,
        @Param("p_total_uv") short totalUv,
        @Param("p_duracion_carrera") short duracion_carrera,
        @Param("p_titulo_otorgar") String tituloOtorgar,
        @Param("p_anio") short anio
    );
}
