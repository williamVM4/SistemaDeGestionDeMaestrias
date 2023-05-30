package com.gl05.bad.controller;

import com.gl05.bad.domain.Maestria;
import com.gl05.bad.domain.PostulacionCohorte;
import com.gl05.bad.servicio.EscuelaPostgradoService;
import com.gl05.bad.servicio.MaestriaService;
import com.gl05.bad.servicio.PostuladoCohorteService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PostularProfesorController {

    @Autowired
    private MaestriaService maestriaService;

    @Autowired
    private EscuelaPostgradoService escuelaPostgradoService;
    
    @Autowired
    private PostuladoCohorteService postulacionService;

    @GetMapping("/PostularProfesor")
    public String listarMaestrias(Model model) {
        var escuelas = escuelaPostgradoService.listarEscuelaPostgrado();
        model.addAttribute("escuelas", escuelas);
        return "PostularProfesor/index";
    }

    @GetMapping("/MaestriasPostular/data")
    @ResponseBody
    public DataTablesOutput<Maestria> getMaestrias(@Valid DataTablesInput input) {
        return maestriaService.listarMaestrias(input);
    }
    
    @PostMapping("/AgregarPostulado")
    public ResponseEntity AgregarActividad(PostulacionCohorte postulado, RedirectAttributes redirectAttributes) {
        try {
            postulacionService.agregarP(postulado);
            
            String mensaje = "Se ha Agregado una Nueva Actividad.";
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            String error = "Ya existe una Actividad con ese Nombre.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
}
