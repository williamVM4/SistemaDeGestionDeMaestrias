package com.gl05.bad.controller;

import com.gl05.bad.domain.Cohorte;
import com.gl05.bad.domain.Maestria;
import com.gl05.bad.domain.Usuario;
import com.gl05.bad.servicio.CohorteService;
import com.gl05.bad.servicio.MaestriaService;
import com.gl05.bad.servicio.UserService;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CohorteController {
    
    @Autowired
    private MaestriaService maestriaService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private CohorteService cohorteService;
    
     @GetMapping("/GestionarCohorte/{idMaestria}")
    public String listarCohortes(Model model,@PathVariable("idMaestria") Long idMaestria) {
        model.addAttribute("idMaestria", idMaestria);
        return "Cohorte/GestionarCohorte";
    }
    
    @GetMapping("/cohorte/data")
    @ResponseBody
    public DataTablesOutput<Cohorte> getCohortes(@Valid DataTablesInput input, @RequestParam("idMaestria") Long idMaestria) {
        return cohorteService.listarCohorteFiltrado(input, idMaestria);
    }
    
    @PostMapping("/AgregarCohorte")
    public ResponseEntity<String> agregarCohorte(
            @RequestParam("idMaestria") Long idMaestria,
            @RequestParam("nombreCohorte") String nombreCohorte,
            @RequestParam("fechaApertura") String fechaAperturaString,
            @RequestParam("estadoCohorte") short estadoCohorte) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
            Date fechaApertura = dateFormat.parse(fechaAperturaString);
            cohorteService.proAgregar(idMaestria, nombreCohorte, fechaApertura, estadoCohorte);
            System.out.println(fechaApertura);
            String mensaje = "Se ha agregado una cohorte a la maestria.";
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            String error = "Ocurrió un error al agregar la cohorte.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
    
    @PostMapping("/ActualizarCohorte")
    public ResponseEntity ActualizarCohorte(Cohorte cohorte, RedirectAttributes redirectAttributes) {
        try {
            Cohorte cohorteExistente = cohorteService.encontrarCohorte(cohorte);
            cohorteExistente.setNombreCohorte(cohorte.getNombreCohorte());
            cohorteExistente.setFechaApertura(cohorte.getFechaApertura());
            cohorteExistente.setEstadoCohorte(cohorte.getEstadoCohorte());
            
            cohorteService.actualizarCohorte(cohorte);
            String mensaje = "Se ha actualizado la cohorte correctamente.";
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            System.out.println(e);
            String error = "Ha ocurrido un error al actualizar la cohorte.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
    
     @PostMapping("/EliminarCohorte/{idCohorte}")
    public ResponseEntity EliminarCohorte(Cohorte cohorte) {
        try {
            cohorteService.eliminarCohorte(cohorte);
            String mensaje = "Se ha eliminado la cohorte correctamente.";
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            String error = "Ha ocurrido un error al eliminar la cohorte";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
    
    @GetMapping("/ObtenerCoherte/{id}")
    public ResponseEntity<Cohorte> obtenerCohorte(@PathVariable Long id) {
        Cohorte cohorteID = new Cohorte(id);
        Cohorte cohorte = cohorteService.encontrarCohorte(cohorteID);
        if (cohorte != null) {
            return ResponseEntity.ok(cohorte);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    
}
