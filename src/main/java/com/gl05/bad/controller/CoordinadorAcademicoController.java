package com.gl05.bad.controller;

import com.gl05.bad.dao.CoordinadorAcademicoDao;
import com.gl05.bad.domain.CoordinadorAcademico;
import com.gl05.bad.servicio.CoordinadorAcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class CoordinadorAcademicoController {

  private static final Logger logger = LoggerFactory.getLogger(CoordinadorAcademicoController.class);

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
  
  @GetMapping("/registrar")
  public String registrarViewCoordinadores(CoordinadorAcademico coor) {
      
      return "/coordinadorAcademico/registrarCoordinadorAcademico";
  }
  
  @PostMapping("/guardar")
  public String guardarCoordinadorAcademico(@ModelAttribute("coordinador") CoordinadorAcademico coordinador) {

      /*CoordinadorAcademico coordinador = new CoordinadorAcademico();
      coordinador.setCodCa(codCa);
      coordinador.setNombresCa(nombresCa);
      coordinador.setApellidosCa(apellidosCa);*/
    logger.info("Datos recibidos: " + coordinador.toString());
      coordinadorService.save(coordinador);

      // Redirige a la vista deseada después de guardar los datos
      return "redirect:/coordinadorAcademico/viewCoordinadoresAcademicos";
  }

 
}

