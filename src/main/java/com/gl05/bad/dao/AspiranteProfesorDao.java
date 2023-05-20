package com.gl05.bad.dao;

import com.gl05.bad.domain.AspiranteProfesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface AspiranteProfesorDao extends JpaRepository<AspiranteProfesor, Long>{
  
    /*@Procedure(name = "insert_aspirante")
    void insert_aspirante(@Param("p_cod") String cod, @Param("p_nombre") String nombre, @Param("p_apellido") String apellido);*/
}
