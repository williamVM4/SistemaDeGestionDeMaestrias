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
    public void agregarAP(AspiranteProfesor aspirante) {
        aspiranteDao.save(aspirante);
    }

    @Override
    public void eliminarAP(AspiranteProfesor aspirante) {
        aspiranteDao.delete(aspirante);
    }

    @Override
    public AspiranteProfesor encontrarAP(AspiranteProfesor aspirante) {
        return aspiranteDao.findById(aspirante.getIdAspiranteProfesor()).orElse(null);
    }

    /*@Override
    public void proIsertarAP(String cod, String nombre, String apellido) {
        aspiranteDao.insert_aspirante(cod, nombre, apellido);
    }*/
}
