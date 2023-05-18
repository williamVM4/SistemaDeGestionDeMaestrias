package com.gl05.bad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoordinadorAcademicoController {
    @GetMapping("/CoordinadorAcademico")
    public String mostrarPerfilCoordinador(Model model) {
        model.addAttribute("pageTitle", "PerfilCoordinadorAcademico");
        return "/coordinadorAcademico/perfilCoordinadorAcademico";
    }
    
    @GetMapping("/registrarCoordinadorAcademico")
    public String mostrarRegistrarCoordinador(Model model) {
        model.addAttribute("pageTitle", "RegistrarCoordinadorAcademico");
        return "/coordinadorAcademico/registrarCoordinadorAcademico";
    }
    
    @GetMapping("/viewCoordinadoresAcademicos")
    public String mostrarViewCoordinadores(Model model) {
        model.addAttribute("pageTitle", "ViewCoordinadoresAcademicos");
        return "/coordinadorAcademico/viewCoordinadorAcademico";
    }
}

