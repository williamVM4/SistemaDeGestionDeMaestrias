package com.gl05.bad.controller;

import com.gl05.bad.domain.EscuelaPostgrado;
import com.gl05.bad.servicio.EscuelaPostgradoService;
import com.gl05.bad.servicio.FacultadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EscuelaPostgradoController {
    
    @Autowired
    private EscuelaPostgradoService escuelaPostgradoService;
    
    @Autowired
    private FacultadService facultadService;
    
    @GetMapping("/viewEscuelaPosgrado")
    public String mostrarEscuelas(Model model) {
        model.addAttribute("pageTitle", "Escuelas de Posgrado");
        
        var elemento = escuelaPostgradoService.listarEscuelaPostgrado();
        model.addAttribute("escuela", elemento);
        
        var elementoFacultad = facultadService.listarFacultad();
        model.addAttribute("facultad", elementoFacultad);
        
        return "EscuelaPostgrado/GestionarEscuela";
    }
    
    @PostMapping("/AgregarEscuelaPosgrado")
    public String AgregarEscuela(EscuelaPostgrado escuela, RedirectAttributes redirectAttributes) {
        try {
            escuelaPostgradoService.agregarEscuela(escuela);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha agregado una escuela de posgrado.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ya existe una escuela de posgrado con ese Nombre.");
        }

        return "redirect:/viewEscuelaPosgrado";
    }
    
    @GetMapping("/EliminarEscuelaPosgrado/{idPostgrado}")
    public String EliminarEscuela(EscuelaPostgrado escuela, RedirectAttributes redirectAttributes) {
        try {
            escuelaPostgradoService.eliminarEscuela(escuela);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha eliminado la escuela de posgrado correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error al eliminar la escuela de posgrado.");
        }
        return "redirect:/viewEscuelaPosgrado";
    }
    
    @PostMapping("/ActualizarEscuelaPosgrado")
    public String ActualizarFacultad(EscuelaPostgrado escuela, RedirectAttributes redirectAttributes) {
        try {
            escuelaPostgradoService.actualizarEscuela(escuela);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha actualizado la escuela de posgrado correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al actualizar la escuela de posgrado.");
        }
        return "redirect:/viewEscuelaPosgrado";
    }
    
    @GetMapping("/ObtenerEscuelaPosgrado/{id}")
    public ResponseEntity<EscuelaPostgrado> obtenerEscuela(@PathVariable Long id) {
        EscuelaPostgrado escuela = escuelaPostgradoService.encontrarEscuela(id);
        if (escuela != null) {
            return ResponseEntity.ok(escuela);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
