package com.gl05.bad.dao;

import com.gl05.bad.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteDao extends JpaRepository<Estudiante, Long>{
    
}
