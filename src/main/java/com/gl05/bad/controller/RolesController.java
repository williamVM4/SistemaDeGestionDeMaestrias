package com.gl05.bad.controller;

import com.gl05.bad.dao.RolesDao;
import com.gl05.bad.dao.UsuarioDao;
import com.gl05.bad.domain.Permisos;
import com.gl05.bad.domain.Roles;
import com.gl05.bad.domain.Usuario;
import com.gl05.bad.servicio.PermisosService;
import com.gl05.bad.servicio.RolesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @Autowired
    private PermisosService permisosService;

    @Autowired
    private RolesDao rolDao;

    //Obtener los roles y mostrarlos en tablas
    @GetMapping("/viewRoles")
    public String mostrarRoles(Model model) {
        model.addAttribute("pageTitle", "mostrarRoles");

        var elemento = rolesService.listaRoles();
        model.addAttribute("Roles", elemento);

        var elementoPermiso = permisosService.listaPermisos();
        model.addAttribute("Permisos", elementoPermiso);
        model.addAttribute("rol", new Roles());

        return "/Roles/GestionarRoles";
    }

    @PostMapping("/AgregarRol")
    public String AgregarRol(Roles rol, RedirectAttributes redirectAttributes) {
        try {
            rolesService.AgregarRol(rol);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha ingresado un rol.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ya existe un rol con ese identificador.");
        }

        return "redirect:/viewRoles";
    }

    @GetMapping("/EliminarRol/{idRol}")
    public String EliminarRol(Roles rol, RedirectAttributes redirectAttributes) {
        try {
            rolesService.eliminarRol(rol);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha eliminado el rol correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "No se puede eliminar el rol porque lo tienen un usuario");
        }
        return "redirect:/viewRoles";
    }

    @GetMapping("/ObtenerRol/{id}")
    public ResponseEntity<Roles> obtenerRol(@PathVariable Long id) {
        Roles rol = rolesService.encontrarRol(id);
        if (rol != null) {
            return ResponseEntity.ok(rol);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/ActualizarRol")
    public String ActualizarRol(Roles rol, RedirectAttributes redirectAttributes) {
        try {
            rolesService.actualizarRol(rol);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha actualizado el Rol.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al actualizar el Rol.");
        }
        return "redirect:/viewRoles";
    }
    

}
