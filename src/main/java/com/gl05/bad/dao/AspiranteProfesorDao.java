package com.gl05.bad.dao;

import com.gl05.bad.domain.AspiranteProfesor;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

public interface AspiranteProfesorDao extends DataTablesRepository<AspiranteProfesor, Long>{
    
    AspiranteProfesor findByIdusuario(Integer idUsuario);
}
