package com.gl05.bad.controller;

import com.gl05.bad.domain.AreaConocimiento;
import com.gl05.bad.servicio.AreaConocimientoService;
import static oracle.jdbc.OracleType.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AreaConocimientosController {
    @Autowired
    private AreaConocimientoService areaConocimientoService;
    
    @GetMapping("/GestionarAreaConocimiento")
    public String index(Model model) {
        model.addAttribute("pageTitle", "Àrea de Conocimientos");
        var elemento = areaConocimientoService.listarAreaConocimientos();
        model.addAttribute("AreaConocimiento", elemento);
        return "AreaConocimiento/index";
    }
    @PostMapping("/AgregarAreaConocimiento")
    public String AgregarAreaConocimiento(AreaConocimiento area, RedirectAttributes redirectAttributes) {     
        try {
            areaConocimientoService.agregarAC(area);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha Agregado una Nueva Àrea de Conocimiento.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ya existe una Àrea de Conocimiento con ese Nombre.");
        }

        return "redirect:/GestionarAreaConocimiento";
    }
    //ObtenerAreaConocimiento
    
    @GetMapping("/EliminarAreaConocimiento/{idAreaConocimiento}")
    public String EliminarRol(AreaConocimiento area, RedirectAttributes redirectAttributes) {
        System.out.println(area);
        try {
            areaConocimientoService.eliminarAC(area);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha eliminado el Area de Conocimiento correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error al eliminar el Area de Conocimiento.");
        }
        return "redirect:/GestionarAreaConocimiento";
    }
    @PostMapping("/ActualizarAreaConocimiento")
    public String ActualizarAreaConocimiento(AreaConocimiento area, RedirectAttributes redirectAttributes) {
        try {
            areaConocimientoService.actualizarAC(area);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha actualizado el Área de Conocimiento.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al actualizar el Área de Conocimiento.");
        }
        return "redirect:/GestionarAreaConocimiento";
    }
    
    @GetMapping("/ObtenerAreaConocimiento/{id}")
    public ResponseEntity<AreaConocimiento> obtenerAreaConocimiento(@PathVariable Long id) {
        AreaConocimiento area = areaConocimientoService.encontrarAC(id);
        if (area != null) {
            return ResponseEntity.ok(area);
        } else {
            return ResponseEntity.notFound().build();
        }
}


}
