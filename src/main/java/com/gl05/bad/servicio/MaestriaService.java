package com.gl05.bad.servicio;

import com.gl05.bad.domain.Maestria;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MaestriaService {
    
    public Collection<Maestria> findAll();
    
    public Page<Maestria> findAll(Pageable pageable);
    
    public void save (Maestria maestria);
    
    public void delete (Maestria maestria);
    
    public Maestria findMaestria(Maestria maestria);
    
    public Collection<Maestria> findBySearchValue(String searchValue);
}
