package com.gl05.bad.servicio;

import com.gl05.bad.dao.MaestriaDao;
import com.gl05.bad.domain.Maestria;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MaestriaServiceImp implements MaestriaService{
    
    @Autowired
    private MaestriaDao maestriaDao;
    
    @Override
    @Transactional(readOnly=true)
    public Collection<Maestria> findAll() {
        return (Collection<Maestria>)maestriaDao.findAll();
    }
    
    @Override
    @Transactional(readOnly=true)
    public Page<Maestria> findAll(Pageable pageable) {
        return maestriaDao.findAll(pageable);
    }

    @Override
    @Transactional
    public void save(Maestria maestria) {
        maestriaDao.save(maestria);
    }

    @Override
    @Transactional
    public void delete(Maestria maestria) {
        maestriaDao.delete(maestria);
    }

    @Override
    @Transactional(readOnly=true)
    public Maestria findMaestria(Maestria maestria) {
        return maestriaDao.findById(maestria.getIdMaestria()).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Collection<Maestria> findBySearchValue(String searchValue) {
        return maestriaDao.findBySearchValue(searchValue);
    }
    
}
