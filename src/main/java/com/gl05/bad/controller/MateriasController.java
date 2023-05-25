package com.gl05.bad.controller;

import com.gl05.bad.domain.Maestria;
import com.gl05.bad.domain.Usuario;
import com.gl05.bad.servicio.MaestriaService;
import com.gl05.bad.servicio.UserService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MateriasController {

    @Autowired
    private MaestriaService maestriaService;
    
    @Autowired
    private UserService userService;
    
     @GetMapping("/GestionarPlanEstudio/{idMaestria}")
    public String listarCohortes(Model model,@PathVariable("idMaestria") Long idMaestria) {
        model.addAttribute("idMaestria", idMaestria);
        return "Materias/GestionarPlanEstudio";
    }
    
}