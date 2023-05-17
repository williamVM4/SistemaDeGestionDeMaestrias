package com.gl05.bad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoordinadorAcademicoController {
    @GetMapping("/CoordinadorAcademico")
    public String prueba(Model model) {
        model.addAttribute("pageTitle", "PerfilCoordinadorAcadémico");
        return "/coordinadorAcademico/perfilCoordinadorAcademico";
    }
}

