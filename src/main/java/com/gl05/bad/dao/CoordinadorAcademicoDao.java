package com.gl05.bad.dao;

import com.gl05.bad.domain.CoordinadorAcademico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface CoordinadorAcademicoDao extends JpaRepository<CoordinadorAcademico, Long>{
      
  @Procedure(name = "sp_insert_coordinador")
    void sp_insert_coordinador(
        @Param("p_cod") String cod,
        @Param("p_nombre") String nombre,
        @Param("p_apellido") String apellido
    );
    
    CoordinadorAcademico findByIdusuario(Integer idUsuario);
}
