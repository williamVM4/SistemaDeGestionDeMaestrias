package com.gl05.bad.controller;

import com.gl05.bad.domain.Maestria;
import com.gl05.bad.servicio.EscuelaPostgradoService;
import com.gl05.bad.servicio.MaestriaService;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MaestriaController {
    @Autowired
    private MaestriaService maestriaService;
    
    @Autowired
    private EscuelaPostgradoService escuelaPostgradoService;
    
    @GetMapping("/GestionarMaestria")
    public String listarMaestrias(Model model) {
        var escuelas = escuelaPostgradoService.listarEscuelaPostgrado();
        model.addAttribute("escuelas", escuelas);
        return "maestria/index";
    }
    
    @GetMapping("/maestria/data")
    @ResponseBody
    public DataTablesOutput<Maestria> getMaestrias(@Valid DataTablesInput input) {
      return maestriaService.listarMaestrias(input);
    }
    
    @PostMapping("/AgregarMaestria")
    public String AgregarMaestria(
        @RequestParam("nombreMaestria") String nombreMaestria,
        @RequestParam("escuelaPostgrado") String escuelaPostgrado,
        RedirectAttributes redirectAttributes) {     
        try {
            maestriaService.proAgregar(nombreMaestria,escuelaPostgrado);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha Agregado una Maestria.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ya existe una Maestria con ese nombre en la escuela de posgrado seleccionada.");
        }

        return "redirect:/GestionarAreaConocimiento";
    }
    
    @GetMapping("/EliminarMaestria/{idMaestria}")
    public String EliminarMaestria(Maestria maestria, RedirectAttributes redirectAttributes) {
        try {
            maestriaService.eliminar(maestria);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha eliminado la Maestria correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error al eliminar el Area de Conocimiento.");
        }
        return "redirect:/GestionarMaestria";
    }
    
    @GetMapping("/DetalleMaestria/{idMaestria}")
    public String EliminarMaestria(Model model) {
        return "maestria/detalleMaestria";
    }
    
}
