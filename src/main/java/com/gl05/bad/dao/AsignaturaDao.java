package com.gl05.bad.dao;

import com.gl05.bad.domain.Asignatura;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface AsignaturaDao extends DataTablesRepository<Asignatura, Long> {

    @Procedure(name = "sp_insert_asignatura")
    void sp_insert_asignatura(
            @Param("p_codigo_asignatura") String codigoAsignatura,
            @Param("p_nombre_asignatura") String nombreAsignatura,
            @Param("p_uv") int uv,
            @Param("p_numero_correlativo") int numeroCorrelativo,
            @Param("p_ciclo") int ciclo,
            @Param("p_id_areaC") long idAreaC,
            @Param("p_id_malla") long idMalla,
            @Param("p_duracion") int duracion,
            @Param("p_horas_t") int horasT,
            @Param("p_horas_p") int horasP,
            @Param("p_hora_ciclo") int horaCiclo,
            @Param("p_introduccion") String introduccion,
            @Param("p_descipcion_programa") String descipcionPrograma,
            @Param("p_objetivo") String objetivo,
            @Param("p_metodologia") String metodologia,
            @Param("p_sistema_evaluacion") String sistemaEvaluacion,
            @Param("p_bibliografia") String bibliografia,
            @Param("p_actividad") String actividad,
            @Param("p_ponderacion") int ponderacion
    );
}
