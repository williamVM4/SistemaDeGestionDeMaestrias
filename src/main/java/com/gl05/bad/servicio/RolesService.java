package com.gl05.bad.servicio;

import com.gl05.bad.domain.Roles;
import java.util.List;

public interface RolesService {
    
    public List<Roles> listaRoles();
   
    public void AgregarRol(Roles rol);
    
    public Roles encontrarRol(Long rol);
    
    public void eliminarRol(Roles rol);
    
    public void actualizarRol(Roles rol);
}
