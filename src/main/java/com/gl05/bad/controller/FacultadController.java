package com.gl05.bad.controller;

import com.gl05.bad.domain.Facultad;
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
public class FacultadController {

    @Autowired
    private FacultadService facultadService;

    @GetMapping("/viewFacultad")
    public String mostrarFacultades(Model model) {
        model.addAttribute("pageTitle", "Facultad");
        var elemento = facultadService.listarFacultad();
        model.addAttribute("facultad", elemento);
        return "Facultad/GestionarFacultad";
    }

    @PostMapping("/AgregarFacultad")
    public String AgregarFacultad(Facultad facultad, RedirectAttributes redirectAttributes) {
        try {
            facultadService.agregarFacultad(facultad);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha agregado una facultad.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ya existe una facultad con ese Nombre.");
        }

        return "redirect:/viewFacultad";
    }

    @GetMapping("/EliminarFacultad/{idFacultad}")
    public String EliminarFacultad(Facultad facultad, RedirectAttributes redirectAttributes) {
        try {
            facultadService.eliminarFacultad(facultad);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha eliminado la facultad correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error al eliminar la facultad.");
        }
        return "redirect:/viewFacultad";
    }

    @PostMapping("/ActualizarFacultad")
    public String ActualizarFacultad(Facultad facultad, RedirectAttributes redirectAttributes) {
        try {
            facultadService.actualizarFacultad(facultad);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha actualizado la facultad correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al actualizar la facultad.");
        }
        return "redirect:/viewFacultad";
    }

    @GetMapping("/ObtenerFacultad/{id}")
    public ResponseEntity<Facultad> obtenerFacultad(@PathVariable Long id) {
        Facultad facultad = facultadService.encontrarFacultad(id);
        System.out.println(facultad);
        if (facultad != null) {
            return ResponseEntity.ok(facultad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
