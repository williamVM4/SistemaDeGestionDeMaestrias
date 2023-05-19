package com.gl05.bad.controller;

import com.gl05.bad.dao.CoordinadorAcademicoDao;
import com.gl05.bad.domain.CoordinadorAcademico;
import com.gl05.bad.servicio.CoordinadorAcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CoordinadorAcademicoController {

  @Autowired
  private CoordinadorAcademicoService coordinadorService;
  
  @Autowired
  private CoordinadorAcademicoDao coordinadorDao;
  
  
  
  @GetMapping("/CoordinadorAcademico")
  public String mostrarPerfilCoordinador(Model model) {
      model.addAttribute("pageTitle", "PerfilCoordinadorAcademico");
      return "/coordinadorAcademico/perfilCoordinadorAcademico";
  }

  @GetMapping("/viewCoordinadoresAcademicos")
  public String mostrarViewCoordinadores(Model model) {
      model.addAttribute("pageTitle", "ViewCoordinadoresAcademicos");

      var elementos = coordinadorDao.findAll();

      model.addAttribute("coordinadoresAC", elementos);
      return "/coordinadorAcademico/viewCoordinadorAcademico";
  }
  
  @PostMapping("/guardarCA")
  public String guardarCoordinadorAcademico(CoordinadorAcademico coordinador) {
      coordinadorService.save(coordinador);
      return "redirect:/viewCoordinadoresAcademicos";
  }
}

