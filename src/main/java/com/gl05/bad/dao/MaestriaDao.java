package com.gl05.bad.dao;

import com.gl05.bad.domain.Maestria;
import java.util.Collection;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MaestriaDao extends DataTablesRepository<Maestria, Long>{

}
