package com.gl05.bad.controller;

import com.gl05.bad.domain.ProgramaAsignatura;
import com.gl05.bad.servicio.ProgramaAsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProgramaAsignaturaController {

    @Autowired
    private ProgramaAsignaturaService programaAsignaturaService;

    @GetMapping("/viewPrograma/{idProgramaAsignatura}")
    public String mostrarActividad(Model model, RedirectAttributes redirectAttributes, @PathVariable("idProgramaAsignatura") Long idProgramaAsignatura) {
        ProgramaAsignatura listProgramaAsignaturaId = programaAsignaturaService.encontrarP(idProgramaAsignatura);

        model.addAttribute("programa", listProgramaAsignaturaId);
        model.addAttribute("idPrograma", idProgramaAsignatura);
        //System.out.println(elemento);
        return "/ProgramaAsignatura/index";
    }
}
