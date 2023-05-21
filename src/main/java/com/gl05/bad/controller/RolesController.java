package com.gl05.bad.controller;

import com.gl05.bad.domain.Roles;
import com.gl05.bad.servicio.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RolesController {

    @Autowired
    private RolesService rolesService;

    //Obtener los roles y mostrarlos en tablas
    @GetMapping("/viewRoles")
    public String mostrarRoles(Model model) {
        model.addAttribute("pageTitle", "mostrarRoles");

        var elemento = rolesService.listaRoles();
        model.addAttribute("Roles", elemento);
        
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
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error al eliminar el rol.");
        }
        return "redirect:/viewRoles";
    }

}
