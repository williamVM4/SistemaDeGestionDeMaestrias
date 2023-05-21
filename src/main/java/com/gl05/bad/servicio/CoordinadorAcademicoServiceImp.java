package com.gl05.bad.servicio;

import com.gl05.bad.dao.CoordinadorAcademicoDao;
import com.gl05.bad.domain.CoordinadorAcademico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CoordinadorAcademicoServiceImp implements CoordinadorAcademicoService{
  
  @Autowired
  private CoordinadorAcademicoDao coordinadorDao;

  @Override
  @Transactional
  public void agregarCA(CoordinadorAcademico coordinador) {
    coordinadorDao.save(coordinador);
  }

  @Override
  public List<CoordinadorAcademico> listarCoordinadores() {
    return (List<CoordinadorAcademico>)coordinadorDao.findAll();
  }

  @Override
  public void eliminarCA(CoordinadorAcademico coordinador) {
    coordinadorDao.delete(coordinador);
  }

  @Override
  public CoordinadorAcademico encontrarCA(CoordinadorAcademico coordinador) {
    return coordinadorDao.findById(coordinador.getIdCoorAca()).orElse(null);
  }

  @Override
  public void proIsertarCA(String cod, String nombre, String apellido) {
    coordinadorDao.sp_insert_coordinador(cod, nombre, apellido);
  }
  
      
  /*  public void actualizarFoto(CoordinadorAcademico c){
      String sql = "UPDATE COORDINADOR_ACADEMICO SET FOTOGRAFIA_CA = (?) WHERE ID_COOR_ACA = (?)";
    }*/

  @Override
  public void actualizarFoto(CoordinadorAcademico coordinador) {
    CoordinadorAcademico coordinadorExistente = coordinadorDao.findById(coordinador.getIdCoorAca()).orElse(null);
    coordinadorExistente.setFotografiaCa(coordinador.getFotografiaCa());
    coordinadorDao.save(coordinadorExistente);
    
  }
}
