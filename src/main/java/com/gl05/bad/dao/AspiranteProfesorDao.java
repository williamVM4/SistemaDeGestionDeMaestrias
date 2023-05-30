package com.gl05.bad.dao;

import com.gl05.bad.domain.AspiranteProfesor;
import java.util.List;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AspiranteProfesorDao extends DataTablesRepository<AspiranteProfesor, Long>{
    
    AspiranteProfesor findByIdusuario(Integer idUsuario);
    
    @Query("SELECT ap FROM PostulacionCohorte pc JOIN pc.idAspiranteProfesor ap WHERE pc.idCohorte.idCohorte = :idCohorte")
    List<AspiranteProfesor> findAspiranteByCohorte(@Param("idCohorte") Long idCohorte);

}
