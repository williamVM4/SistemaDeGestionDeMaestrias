package com.gl05.bad.controller;

import com.gl05.bad.domain.Estudiante;
import com.gl05.bad.servicio.EstudianteService;
import com.gl05.bad.servicio.PaisService;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private PaisService paisService;

    //Obtener los roles y mostrarlos en tablas
    @GetMapping("/viewEstudiantes")
    public String mostrarEstudiantes(Model model) {
        model.addAttribute("pageTitle", "mostrarEstudiantes");

        var elemento = estudianteService.listaEstudiantes();
        model.addAttribute("estudiantes", elemento);

        var elementoPais = paisService.listarPaises();
        model.addAttribute("pais", elementoPais);

        List<String> sexos = listarSexos();
        List<String> generos = listarGeneros();
        List<String> nacionalidades = listarNacionalidades();
        
        model.addAttribute("sexos", sexos);
        model.addAttribute("generos", generos);
        model.addAttribute("nacionalidades", nacionalidades);

        return "/Estudiante/GestionarEstudiante";
    }

    @GetMapping("/estudiantes/data")
    @ResponseBody
    public DataTablesOutput<Estudiante> getEstudiantes(@Valid DataTablesInput input) {
        return estudianteService.listaEstudiantes(input);
    }
    
    @PostMapping("/AgregarEstudiante")
    public String AgregarEstudiante(Estudiante estudiante, RedirectAttributes redirectAttributes) {
         
        try {
            estudianteService.agregarEstudiante(estudiante);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha ingresado un estudiante.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ya existe un estudiante con ese identificador.");
        }

        return "redirect:/viewEstudiantes";
    }
    
    @GetMapping("/EliminarEstudiante/{idEstudiante}")
    public String EliminarEstudiante(Estudiante estudiante, RedirectAttributes redirectAttributes) {
        try {
            estudianteService.eliminarEstudiante(estudiante);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha eliminado el estudiante correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "No se puede eliminar el estudiante ");
        }
        return "redirect:/viewEstudiantes";
    }

    @GetMapping("/ObtenerEstudiante/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiante(@PathVariable Long id) {
        Estudiante estudiante = estudianteService.encontrarEstudiante(id);
        if (estudiante != null) {
            return ResponseEntity.ok(estudiante);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/ActualizarEstudiante")
    public String ActualizarEstudiante(Estudiante estudiante, RedirectAttributes redirectAttributes) {
        try {
            estudianteService.actualizarEstudiante(estudiante);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha actualizado el Estudiante.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al actualizar el Estudiante.");
        }
        return "redirect:/viewRoles";
    }
    
    public List<String> listarGeneros() {
        List<String> generos = Arrays.asList("Masculino", "Femenino", "LGBTIQ+", "Prefiero no decirlo");
        return generos;
    }

    public List<String> listarSexos() {
        List<String> sexos = Arrays.asList("Hombre", "Mujer");
        return sexos;
    }

    public List<String> listarNacionalidades() {
        List<String> estados = Arrays.asList("Nacimiento", "Naturalización", "Residencia");
        return estados;
    }

}
