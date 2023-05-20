package com.gl05.bad.controller;

import com.gl05.bad.servicio.CoordinadorAcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CoordinadorAcademicoController {

  @Autowired
  private CoordinadorAcademicoService coordinadorService;
  
  @GetMapping("/CoordinadorAcademico")
  public String mostrarPerfilCoordinador(Model model) {
      model.addAttribute("pageTitle", "PerfilCoordinadorAcademico");
      return "/coordinadorAcademico/perfilCoordinadorAcademico";
  }

  @GetMapping("/viewCoordinadoresAcademicos")
  public String mostrarViewCoordinadores(Model model) {
      model.addAttribute("pageTitle", "ViewCoordinadoresAcademicos");

      var elementos = coordinadorService.listarCoordinadores();

      model.addAttribute("coordinadoresAC", elementos);
      return "/coordinadorAcademico/viewCoordinadorAcademico";
  }
 
    @PostMapping("/guardarCA")
    public String registerCoordinador(
        @RequestParam("codCa") String codCa,
        @RequestParam("nombresCa") String nombresCa,
        @RequestParam("apellidosCa") String apellidosCa,
        RedirectAttributes redirectAttributes) {

        try {
            coordinadorService.proIsertarCA(codCa, nombresCa, apellidosCa);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha ingresado un coordinador.");
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ya existe un coordinador con ese identificador.");
        }

        return "redirect:/viewCoordinadoresAcademicos";  
    }

      
  /*@PostMapping("/guardarCA")
  public String guardarCoordinadorAcademico(CoordinadorAcademico coordinador) {
      coordinadorService.save(coordinador);
      return "redirect:/viewCoordinadoresAcademicos";
  }*/
}

