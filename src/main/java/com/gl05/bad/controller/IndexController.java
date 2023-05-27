package com.gl05.bad.controller;

import com.gl05.bad.domain.Maestria;
import com.gl05.bad.domain.Usuario;
import com.gl05.bad.servicio.MaestriaService;
import com.gl05.bad.servicio.UserService;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @Autowired
    private MaestriaService maestriaService;
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pageTitle", "Welcome");
        return "welcome";
    }
    
    @GetMapping("/ObtenerMaestriasCoordinador")
    public ResponseEntity<Collection<Maestria>> obtenerMaestriasCoordinador(Authentication authentication, HttpSession session) {
        // Obtener el nombre del usuario autenticado
        String username = authentication.getName();
        // Obtener el ID del usuario autenticado desde tu servicio de seguridad
        Usuario usuario = userService.encontrarUsuarioPorUsername(username);
        Long idUsuarioLong = usuario.getIdUsuario();
        Integer idUsuario = idUsuarioLong.intValue();
        // Buscar las maestrías asociadas al ID del usuario
        Collection<Maestria> maestriasCoordinador = maestriaService.encontrarMaestrias(idUsuario);
        return ResponseEntity.ok(maestriasCoordinador);
    }
    
    @GetMapping("/welcome2")
    public String pagina2(Model model) {
        model.addAttribute("pageTitle", "welcome2");
        return "welcome2";
    }
    
      @GetMapping("/welcome3")
    public String pagina3(Model model) {
        model.addAttribute("pageTitle", "welcome2");
        return "welcome3";
    }
    
      @GetMapping("/errorpage")
    public String error(Model model) {
        model.addAttribute("pageTitle", "welcome2");
        return "errorPage";
    }
    
    @GetMapping("/usuariobloqueado")
    public String correctDisable(Model model) {
        model.addAttribute("pageTitle", "welcome2");
        return "usuariobloqueado";
    }
    
    @GetMapping("/usuarioinhabilitado")
    public String usernothabilitate(Model model) {
        model.addAttribute("pageTitle", "welcome2");
        return "usuarioinhabilitado";
    }
    
    @GetMapping("/usuariodeshabilitadobloqueado")
    public String usernothabilitateblocked(Model model) {
        model.addAttribute("pageTitle", "welcome2");
        return "usuariobloqdes";
    }
    
}
