package com.gl05.bad.servicio;

import com.gl05.bad.dao.AspiranteProfesorDao;
import com.gl05.bad.domain.AspiranteProfesor;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import java.util.Collection;

@Service
public class AspiranteProfesorServiceImp implements AspiranteProfesorService{
  
    @Autowired
    private AspiranteProfesorDao aspiranteDao;
    
    @Override
    @Transactional(readOnly=true)
    public Collection<AspiranteProfesor> listarAspirantes() {
        return (Collection<AspiranteProfesor>)aspiranteDao.findAll();
    }
    
    @Override
    @Transactional(readOnly=true)
    public DataTablesOutput<AspiranteProfesor> listarAspirantes(DataTablesInput input) {
        return (DataTablesOutput<AspiranteProfesor>)aspiranteDao.findAll(input);
    }

    /*@Override
    public List<AspiranteProfesor> listarAspirantes() {
        return (List<AspiranteProfesor>) aspiranteDao.findAll();S
    }*/

    @Override
    @Transactional
    public void agregarAP(AspiranteProfesor aspirante) {
        aspiranteDao.save(aspirante);
    }
    
    @Override
    @Transactional
    public void actualizarAP(AspiranteProfesor aspirante) {
        AspiranteProfesor aspiranteExistente = aspiranteDao.findById(aspirante.getIdAspiranteProfesor()).orElse(null);
        aspiranteExistente.setNombresAp(aspirante.getNombresAp());
        aspiranteExistente.setApellidosAp(aspirante.getApellidosAp());
        aspiranteExistente.setSexoAp(aspirante.getSexoAp());
        aspiranteExistente.setGeneroAp(aspirante.getGeneroAp());
        aspiranteExistente.setFechaNacAp(aspirante.getFechaNacAp());
        aspiranteExistente.setEstadoCivilAp(aspirante.getEstadoCivilAp());
        aspiranteExistente.setIdPais(aspirante.getIdPais());
        aspiranteExistente.setNacionalidadAp(aspirante.getNacionalidadAp());
        aspiranteExistente.setDuiAp(aspirante.getDuiAp());
        aspiranteExistente.setNitAp(aspirante.getNitAp());
        aspiranteExistente.setNupAp(aspirante.getNupAp());
        aspiranteExistente.setPasaporteAp(aspirante.getPasaporteAp());
        aspiranteExistente.setDocPersonalAp(aspirante.getDocPersonalAp());
        
        Blob fotoActual = aspiranteExistente.getFotografiaAp();
        
        if (aspirante.getFotografiaAp() == null && fotoActual != null) {
          byte[] fotoBytes;
          try {
            fotoBytes = fotoActual.getBytes(1, (int) fotoActual.length());
            aspiranteExistente.setFotografiaAp(new javax.sql.rowset.serial.SerialBlob(fotoBytes));
          } catch (SQLException ex) {
            Logger.getLogger(AtestadoTaServiceImp.class.getName()).log(Level.SEVERE, null, ex);
          }
        } else {
          aspiranteExistente.setFotografiaAp(null);
        }
        
        aspiranteDao.save(aspiranteExistente);
    }

    @Override
    public void eliminarAP(AspiranteProfesor aspirante) {
        aspiranteDao.delete(aspirante);
    }

    @Override
    public AspiranteProfesor encontrarAP(AspiranteProfesor aspirante) {
        return aspiranteDao.findById(aspirante.getIdAspiranteProfesor()).orElse(null);
    }
    
    @Override
    @Transactional
    public void actualizarFoto(AspiranteProfesor aspirante, String nombreCampo, Blob valorCampo) {
        AspiranteProfesor coordinadorExistente = aspiranteDao.findById(aspirante.getIdAspiranteProfesor()).orElse(null);
        switch (nombreCampo) {
          case "fotografiaCa":
            coordinadorExistente.setFotografiaAp(valorCampo);
            break;}
        aspiranteDao.save(coordinadorExistente);
    }
    
    @Override
    @Transactional(readOnly=true)
    public AspiranteProfesor encontrarPorIdUsuario(Integer idUsuario) {
        return aspiranteDao.findByIdusuario(idUsuario);
    }
}
