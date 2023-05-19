package com.gl05.bad.controller;

import com.gl05.bad.dao.CoordinadorAcademicoDao;
import com.gl05.bad.domain.CoordinadorAcademico;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoordinadorAcademicoController {
  @Autowired
  private CoordinadorAcademicoDao coordinadorDao;
  
  
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
        
        var elementos = coordinadorDao.findAll();
        
        model.addAttribute("coordinadoresAC", elementos);
        return "/coordinadorAcademico/viewCoordinadorAcademico";
    }
}

