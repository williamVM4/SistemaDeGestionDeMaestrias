package com.gl05.bad.controller;

import com.gl05.bad.domain.VistaEstudiantesProfesores;
import com.gl05.bad.servicio.VistaEstudiantesProfesoresService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReportesController {
    
    @Autowired
    private VistaEstudiantesProfesoresService vEstudiantesProfesoresService;
            
    @GetMapping("/AreasAcademicas")
    public String mostrarAreaConocimiento(Model model) {
        model.addAttribute("pageTitle", "Reporte Estadístico");
        return "/Reportes/areaConocimiento";
    }
    
    @GetMapping("/AreasConocimiento/data")
    @ResponseBody
    public DataTablesOutput<VistaEstudiantesProfesores> getCohortes(@Valid DataTablesInput input) {
        return vEstudiantesProfesoresService.obtenerEstudiantesProfesores(input);
    }
}