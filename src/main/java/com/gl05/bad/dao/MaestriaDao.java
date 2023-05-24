package com.gl05.bad.dao;

import com.gl05.bad.domain.Maestria;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;


public interface MaestriaDao extends DataTablesRepository<Maestria, Long>{
    
    @Procedure(name = "sp_insert_maestria")
    void sp_insert_maestria(
        @Param("p_nombre_maestria") String nombre,
        @Param("p_id_postgrado") String posgrado
    );
}
