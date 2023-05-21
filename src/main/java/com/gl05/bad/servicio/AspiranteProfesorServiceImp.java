package com.gl05.bad.servicio;

import com.gl05.bad.dao.AspiranteProfesorDao;
import com.gl05.bad.domain.AspiranteProfesor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AspiranteProfesorServiceImp implements AspiranteProfesorService{
  
    @Autowired
    private AspiranteProfesorDao aspiranteDao;

    @Override
    public List<AspiranteProfesor> listarAspirantes() {
        return (List<AspiranteProfesor>) aspiranteDao.findAll();
    }

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
}
