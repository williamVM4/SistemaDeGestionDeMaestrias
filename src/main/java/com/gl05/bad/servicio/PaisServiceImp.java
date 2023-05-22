package com.gl05.bad.servicio;

import java.util.List;
import com.gl05.bad.dao.PaisDao;
import com.gl05.bad.domain.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaisServiceImp implements PaisService{
  
    @Autowired
    private PaisDao paisDao;

    @Override
    public List<Pais> listarPaises() {
        return (List<Pais>) paisDao.findAll();
    }

    @Override
    @Transactional
    public void agregarP(Pais pais) {
        paisDao.save(pais);
    }

    @Override
    public void eliminarP(Pais pais) {
        paisDao.delete(pais);
    }

    @Override
    public Pais encontrarP(Pais pais) {
        return paisDao.findById(pais.getIdPais()).orElse(null);
    }
}
