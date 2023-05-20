package com.gl05.bad.controller;

import com.gl05.bad.domain.AspiranteProfesor;
import com.gl05.bad.servicio.AspiranteProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AspiranteProfesorController {
    
    @Autowired
    private AspiranteProfesorService aspiranteService;
    
    
    @GetMapping("/PerfilAspiranteProfesor/{idAspiranteProfesor}")
    public String perfilAspiranteProfesor(Model model, AspiranteProfesor aspirante) {
        model.addAttribute("pageTitle", "PerfilAspiranteProfesor");
        var elemento = aspiranteService.encontrarAP(aspirante);
        model.addAttribute("aspiranteAP", elemento);
        return "/AspiranteProfesor/perfilAspiranteProfesor";
    }
        
    @GetMapping("/GestionarAspiranteProfesor")
    public String mostrarAspirantesProfesor(Model model) {
        model.addAttribute("pageTitle", "GestionarAspiranteProfesor");
        var elementos = aspiranteService.listarAspirantes();
        model.addAttribute("aspirantesAP", elementos);
        return "/AspiranteProfesor/gestionarAspiranteProfesor";
    }
    
    @PostMapping("/AgregarAspiranteProfesor")
    public String agregarAspiranteProfesor(AspiranteProfesor aspirante, RedirectAttributes redirectAttributes) {
        try {
            aspiranteService.agregarAP(aspirante);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha ingresado un aspirante a profesor.");
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ya existe un aspirante a profesor con ese identificador.");
        }
        return "redirect:/GestionarAspiranteProfesor";  
    }
    
    @GetMapping("/EliminarAspiranteProfesor/{idAspiranteProfesor}")
    public String eliminarAspiranteProfesor(AspiranteProfesor aspirante, RedirectAttributes redirectAttributes) {
        try {
            aspiranteService.eliminarAP(aspirante);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha eliminado un aspirante a profesor.");
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error al eliminar el aspirante a profesor.");
        }
        return "redirect:/GestionarAspiranteProfesor";
    }
}