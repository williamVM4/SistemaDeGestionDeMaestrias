package com.gl05.bad.servicio;

import com.gl05.bad.dao.CoordinadorAcademicoDao;
import com.gl05.bad.domain.CoordinadorAcademico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CoordinadorAcademicoServiceImp implements CoordinadorAcademicoService{
  
  @Autowired
  private CoordinadorAcademicoDao coordinadorDao;

  @Override
  @Transactional
  public void save(CoordinadorAcademico coordinador) {
    coordinadorDao.save(coordinador);
  }
  
  
}
