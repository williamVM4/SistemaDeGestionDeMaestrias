package com.gl05.bad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AspiranteProfesorController {
    @GetMapping("/AspiranteProfesor")
    public String perfilAspiranteProfesor(Model model) {
        model.addAttribute("pageTitle", "PerfilAspiranteProfesor");
        return "/AspiranteProfesor/perfilAspiranteProfesor";
    }
    
    @GetMapping("/GestionarAspiranteProfesor")
    public String gestionarAspiranteProfesor(Model model) {
        model.addAttribute("pageTitle", "GestionarAspiranteProfesor");
        return "/AspiranteProfesor/gestionarAspiranteProfesor";
    }
    
    /*@PostMapping("/AgregarAspiranteProfesor")
    public String agregarAspiranteProfesor(AspiranteProfesor aspiranteProfesor){
        aspiranteProfesorService.agregar(aspiranteProfesor);
        return "redirect:/GestionarAspiranteProfesor";
    }*/
}