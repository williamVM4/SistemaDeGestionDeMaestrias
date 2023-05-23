package com.gl05.bad.servicio;

import com.gl05.bad.dao.CoordinadorAcademicoDao;
import com.gl05.bad.domain.CoordinadorAcademico;
import java.lang.reflect.Field;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    @Transactional
    public void actualizarCA(CoordinadorAcademico coordinador) {
        CoordinadorAcademico coordinadorExistente = coordinadorDao.findById(coordinador.getIdCoorAca()).orElse(null);
        coordinadorExistente.setNombresCa(coordinador.getNombresCa());
        coordinadorExistente.setApellidosCa(coordinador.getApellidosCa());
        coordinadorExistente.setSexoCa(coordinador.getSexoCa());
        coordinadorExistente.setGeneroCa(coordinador.getGeneroCa());
        coordinadorExistente.setFechaNacCa(coordinador.getFechaNacCa());
        coordinadorExistente.setEstadoCivilCa(coordinador.getEstadoCivilCa());
        coordinadorExistente.setIdPais(coordinador.getIdPais());
        coordinadorExistente.setNacionalidadCa(coordinador.getNacionalidadCa());
        coordinadorExistente.setDuiCa(coordinador.getDuiCa());
        coordinadorExistente.setNitCa(coordinador.getNitCa());
        coordinadorExistente.setNupCa(coordinador.getNupCa());
        coordinadorExistente.setPasaporteCa(coordinador.getPasaporteCa());
        coordinadorExistente.setDocPersonalCa(coordinador.getDocPersonalCa());
        
        Blob fotoActual = coordinadorExistente.getFotografiaCa();
        
        if (coordinador.getFotografiaCa() == null && fotoActual != null) {
          byte[] fotoBytes;
          try {
            fotoBytes = fotoActual.getBytes(1, (int) fotoActual.length());
            coordinadorExistente.setFotografiaCa(new javax.sql.rowset.serial.SerialBlob(fotoBytes));
          } catch (SQLException ex) {
            Logger.getLogger(AtestadoTaServiceImp.class.getName()).log(Level.SEVERE, null, ex);
          }
        } else {
          coordinadorExistente.setFotografiaCa(null);
        }
        
        coordinadorDao.save(coordinadorExistente);
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

    @Override
    @Transactional
    public void actualizarCampo(CoordinadorAcademico coordinador, String nombreCampo, Blob valorCampo) {
        CoordinadorAcademico coordinadorExistente = coordinadorDao.findById(coordinador.getIdCoorAca()).orElse(null);
        switch (nombreCampo) {
            case "fotografiaCa":
                coordinadorExistente.setFotografiaCa(valorCampo);
                break;
        }
        coordinadorDao.save(coordinadorExistente);
    }

}
