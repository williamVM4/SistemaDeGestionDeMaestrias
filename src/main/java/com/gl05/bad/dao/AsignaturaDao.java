package com.gl05.bad.dao;

import com.gl05.bad.domain.Asignatura;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

public interface AsignaturaDao extends DataTablesRepository<Asignatura, Long>{
    
}
