package com.gl05.bad.controller;

import com.gl05.bad.domain.PlanEstudio;
import com.gl05.bad.servicio.PlanEstudioService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlanEstudioController {

    @Autowired
    private PlanEstudioService planEstudioService;
    
    
     @GetMapping("/GestionarPlanEstudio/{idMaestria}")
    public String listarPlanesEstudio(Model model,@PathVariable("idMaestria") Long idMaestria) {
        model.addAttribute("idMaestria", idMaestria);
        return "PlanEstudio/GestionarPlanEstudio";
    }
    
    @GetMapping("/planEstudio/data")
    @ResponseBody
    public DataTablesOutput<PlanEstudio> getPlanes(@Valid DataTablesInput input) {
      return planEstudioService.listarPlanEstudio(input);
    }
    
}
