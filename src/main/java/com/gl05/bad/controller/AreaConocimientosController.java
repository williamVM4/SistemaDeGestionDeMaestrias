package com.gl05.bad.controller;

import com.gl05.bad.domain.AreaConocimiento;
import com.gl05.bad.domain.Maestria;
import com.gl05.bad.servicio.AreaConocimientoService;
import javax.validation.Valid;
import static oracle.jdbc.OracleType.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @GetMapping("/areaConocimiento/data")
    @ResponseBody
    public DataTablesOutput<AreaConocimiento> getAreaConocimiento(@Valid DataTablesInput input) {
      System.out.println(areaConocimientoService.listarAreaConocimientos(input));
        return areaConocimientoService.listarAreaConocimientos(input);
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
    
    @PostMapping("/EliminarAreaConocimiento/{idAreaConocimiento}")
    public ResponseEntity EliminarAreaConocimiento(AreaConocimiento area) {
        try {
            areaConocimientoService.eliminarAC(area);
            String mensaje = "Se ha eliminado la Maestria correctamente.";
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            String error = "Ha ocurrido un error al eliminar la maestria.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
    @PostMapping("/ActualizarAreaConocimiento")
    public ResponseEntity ActualizarAreaConocimiento(AreaConocimiento area, RedirectAttributes redirectAttributes) {
        try {
            areaConocimientoService.actualizarAC(area);
            String mensaje = "Se ha actualizado la maestria correctamente.";
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            String error = "Ha ocurrido un error al actualizar la maestria.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
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
