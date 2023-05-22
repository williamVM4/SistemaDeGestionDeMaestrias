package com.gl05.bad.dao;

import com.gl05.bad.domain.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoDao extends JpaRepository<Documento, Long>{
  
}

