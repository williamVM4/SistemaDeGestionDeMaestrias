package com.gl05.bad.servicio;

import com.gl05.bad.dao.RolesDao;
import com.gl05.bad.domain.Roles;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesServiceImp implements RolesService{

     @Autowired
     private RolesDao rolDao;
    
    @Override
    public List<Roles> listaRoles() {
        return (List<Roles>) rolDao.findAll();
    }

    @Override
    public void AgregarRol(Roles rol) {
       rolDao.save(rol);
    }

    @Override
    public Roles encontrarRol(Roles rol) {
        return rolDao.findById(rol.getIdRol()).orElse(null);
    }

    @Override
    public void eliminarRol(Roles rol) {
        rolDao.delete(rol);
    }
    
}
