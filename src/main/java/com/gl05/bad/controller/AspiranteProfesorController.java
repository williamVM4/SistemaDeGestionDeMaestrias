package com.gl05.bad.controller;

import com.gl05.bad.domain.AspiranteProfesor;
import com.gl05.bad.servicio.AspiranteProfesorService;
import com.gl05.bad.servicio.PaisService;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
public class AspiranteProfesorController {
    
    @Autowired
    private AspiranteProfesorService aspiranteService;
    
    @Autowired
    private PaisService paisService;
    
    
    @GetMapping("/PerfilAspiranteProfesor/{idAspiranteProfesor}")
    public String perfilAspiranteProfesor(Model model, AspiranteProfesor aspirante) {
        model.addAttribute("pageTitle", "PerfilAspiranteProfesor");
        var aspiranteNew = aspiranteService.encontrarAP(aspirante);
        //Se cargan para la edicion de la informacion general del aspirante
        List<String> sexos = listarSexos();
        List<String> generos = listarGeneros();
        List<String> estadosCiviles = listarEstados();
        List<String> nacionalidades = listarNacionalidades();
        var paises = paisService.listarPaises();
        
        model.addAttribute("aspiranteAP", aspiranteNew);
        model.addAttribute("paises", paises);
        model.addAttribute("sexos", sexos);
        model.addAttribute("generos", generos);
        model.addAttribute("estadosCiviles", estadosCiviles);
        model.addAttribute("nacionalidades", nacionalidades);
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
    
    @PostMapping("/ActualizarAspiranteProfesor/{idAspiranteProfesor}")
    public String actualizarAspiranteProfesor(AspiranteProfesor aspirante, @PathVariable("idAspiranteProfesor") int idAspiranteProfesor, RedirectAttributes redirectAttributes) {
        try {
            aspiranteService.actualizarAP(aspirante);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha actualizado la información general del aspirante a profesor.");
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "No se actualizó la la información general del aspirante a profesor.");
        }
        String redirectUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/PerfilAspiranteProfesor/{idAspiranteProfesor}").buildAndExpand(idAspiranteProfesor).toUriString();
        return "redirect:" + redirectUrl;  
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
    
    public List<String> listarSexos() {
        List<String> generos = Arrays.asList("Masculino", "Femenino","LGBTIQ+","Prefiero no decirlo");        
        return generos;
    }
    public List<String> listarGeneros() {
        List<String> sexos= Arrays.asList("Hombre", "Mujer");  
        return sexos;
    }
    public List<String> listarEstados() {
        List<String> estados = Arrays.asList("Soltero", "Casado","Divorciado","Separado","Acompañado","Unión libre");  
        return estados;
    }
    public List<String> listarNacionalidades() {
        List<String> estados = Arrays.asList("Nacimiento", "Naturalización", "Residencia");
        return estados;
    }
}