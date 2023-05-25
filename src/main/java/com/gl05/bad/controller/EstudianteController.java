package com.gl05.bad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EstudianteController {
    //Obtener los roles y mostrarlos en tablas
    @GetMapping("/viewEstudiantes")
    public String mostrarEstudiantes(Model model) {
//        model.addAttribute("pageTitle", "mostrarEstudiantes");
//
//        var elemento = rolesService.listaRoles();
//        model.addAttribute("Roles", elemento);
//
//        var elementoPermiso = permisosService.listaPermisos();
//        model.addAttribute("Permisos", elementoPermiso);
//        //model.addAttribute("rol", new Roles());

        return "/Estudiante/GestionarEstudiante";
    }
}
