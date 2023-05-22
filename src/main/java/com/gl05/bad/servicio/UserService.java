package com.gl05.bad.servicio;

import com.gl05.bad.domain.Usuario;
import java.util.List;

public interface UserService {
    
    public List<Usuario> listaUsuarios();
   
    public void AgregarUsuarios(Usuario usuario);
    
//    public Usuario encontrarUsuario(Usuario usuario);
    
    public void eliminarUsuario(Usuario usuario);
    
    public Usuario encontrarUsuario(Long idUsuario);
    
    
}
