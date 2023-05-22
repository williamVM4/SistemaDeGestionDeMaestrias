package com.gl05.bad.dao;

import com.gl05.bad.domain.Maestria;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MaestriaDao extends JpaRepository<Maestria, Integer>{
    @Query("SELECT m FROM Maestria m WHERE m.nombreMaestria LIKE %:searchValue%")
    Collection<Maestria> findBySearchValue(@Param("searchValue") String searchValue);
}
