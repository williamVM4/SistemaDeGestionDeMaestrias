package com.gl05.bad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportesController {
            
    @GetMapping("/AreasAcademicas")
    public String mostrarPaises(Model model) {
        model.addAttribute("pageTitle", "Reporte Estadístico");
        return "/Reportes/areaConocimiento";
    }
    
}