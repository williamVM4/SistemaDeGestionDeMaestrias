package com.gl05.bad.controller;

import com.gl05.bad.domain.AspiranteProfesor;
import com.gl05.bad.servicio.AspiranteProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AspiranteProfesorController {
    
    @Autowired
    private AspiranteProfesorService aspiranteService;
    
    
    @GetMapping("/AspiranteProfesor")
    public String perfilAspiranteProfesor(Model model) {
        model.addAttribute("pageTitle", "PerfilAspiranteProfesor");
        return "/AspiranteProfesor/perfilAspiranteProfesor";
    }
    
    /*@GetMapping("/GestionarAspiranteProfesor")
    public String gestionarAspiranteProfesor(Model model) {
        model.addAttribute("pageTitle", "GestionarAspiranteProfesor");
        return "/AspiranteProfesor/gestionarAspiranteProfesor";
    }*/
    
    @GetMapping("/GestionarAspiranteProfesor")
    public String mostrarAspirantesProfesor(Model model) {
        model.addAttribute("pageTitle", "GestionarAspiranteProfesor");
        var elementos = aspiranteService.listarAspirantes();
        model.addAttribute("aspirantesAP", elementos);
        return "/AspiranteProfesor/gestionarAspiranteProfesor";
    }
    
    @PostMapping("/AgregarAspiranteProfesor")
    public String agregarAspiranteProfesor(AspiranteProfesor aspirante) {
        aspiranteService.agregarAP(aspirante);
        return "redirect:/GestionarAspiranteProfesor";
    }
}