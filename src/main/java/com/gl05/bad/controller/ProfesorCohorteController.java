package com.gl05.bad.controller;

import com.gl05.bad.domain.AspiranteProfesor;
import com.gl05.bad.servicio.PostuladoCohorteService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProfesorCohorteController {

    @Autowired
    private PostuladoCohorteService postuladoCohorteService;

    @GetMapping("/PostuladosCohorte/{idCohorte}")
    public String ProfesorCohorte(Model model, RedirectAttributes redirectAttributes, @PathVariable("idCohorte") Long idCohorte) {
        var postulados = postuladoCohorteService.listarAreaConocimientos(idCohorte);
        //Long idMallaC = asignaturaService.encontrarMalla(idPlanEstudio);
        //model.addAttribute("areaC", areaC);
        //model.addAttribute("idMallaC", idMallaC);
        model.addAttribute("postulados", postulados);
        return "ProfesorCohorte/index";
    }

    /*@GetMapping("/Asignatura/data")
    @ResponseBody
    public DataTablesOutput<AspiranteProfesor> getAsignatura(@Valid DataTablesInput input,
            @RequestParam("idCohorte") Long idCohorte) {
        return postuladoCohorteService.listarAspiranteFiltrado(input, idCohorte);
    }*/
}
