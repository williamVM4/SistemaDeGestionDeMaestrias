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

//    @Override
//    public Usuario encontrarUsuario(Usuario usuario) {
//        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
//    }
    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    public Usuario encontrarUsuario(Long idUsuario) {
        return usuarioDao.findById(idUsuario).orElse(null);
    }

}
