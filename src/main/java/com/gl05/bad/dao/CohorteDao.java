package com.gl05.bad.dao;

import com.gl05.bad.domain.Cohorte;
import java.util.Date;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface CohorteDao extends DataTablesRepository<Cohorte, Long>{
//    @Procedure(name = "sp_insert_cohorte")
//    void sp_insert_cohorte(
//        @Param("p_estado_cohorte") short estadoCohorte,
//        @Param("p_fecha_apertura") Date fechaApertura
//    );
}
