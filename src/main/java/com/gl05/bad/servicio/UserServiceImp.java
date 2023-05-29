package com.gl05.bad.servicio;

import com.gl05.bad.dao.UsuarioDao;
import com.gl05.bad.domain.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> listaUsuarios() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    public void AgregarUsuarios(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    public Usuario encontrarUsuario(Long idUsuario) {
        return usuarioDao.findById(idUsuario).orElse(null);
    }
    
    @Override
    public Usuario encontrarUsuarioPorUsername(String username){
        return usuarioDao.findByUsername(username);
    }
    
    @Override
    public Usuario encontrarUsuarioPorEmail(String email){
        return usuarioDao.findByEmail(email);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        if (usuarioDao.existsById(usuario.getIdUsuario())) {
            // Actualiza el rol en la base de datos
            usuarioDao.save(usuario);
        } else {
            throw new IllegalArgumentException("El usuario no existe.");
        }
    }

}
