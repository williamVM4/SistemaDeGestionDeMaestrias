package com.gl05.bad.controller;

import com.gl05.bad.domain.Maestria;
import com.gl05.bad.domain.Usuario;
import com.gl05.bad.servicio.MaestriaService;
import com.gl05.bad.servicio.UserService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class CohorteController {
    
    @Autowired
    private MaestriaService maestriaService;
    
    @Autowired
    private UserService userService;
    
     @GetMapping("/GestionarCohorte")
    public String listarCohortes(Model model, Authentication authentication) {
        // Obtener el nombre del usuario autenticado
        String username = authentication.getName();
        // Obtener el ID del usuario autenticado desde tu servicio de seguridad
        Usuario usuario = userService.encontrarUsuarioPorUsername(username);
        Long idUsuarioLong = usuario.getIdUsuario();
        Integer idUsuario = idUsuarioLong.intValue();
        // Buscar las maestrías asociadas al ID del usuario
        Collection<Maestria> maestrias = maestriaService.encontrarMaestria(idUsuario);

        // Agregar las maestrías al modelo para mostrar en la vista
        model.addAttribute("maestrias", maestrias);

        return "Cohorte/GestionarCohorte";
    }
    
}
