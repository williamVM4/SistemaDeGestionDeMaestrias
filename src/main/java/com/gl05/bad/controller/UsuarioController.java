package com.gl05.bad.controller;

import com.gl05.bad.domain.Usuario;
import com.gl05.bad.servicio.RolesService;
import com.gl05.bad.servicio.UserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsuarioController {

    @Autowired
    private UserService userService;

    @Autowired
    private RolesService rolesService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //Obtener los usuarios y mostrarlos en tablas
    @GetMapping("/viewUsuarios")
    public String mostrarUsuarios(Model model) {
        model.addAttribute("pageTitle", "mostrarUsuarios");

        var elemento = userService.listaUsuarios();
        model.addAttribute("usuarios", elemento);

        var elementoRol = rolesService.listaRoles();
        model.addAttribute("roles", elementoRol);
        model.addAttribute("usuario", new Usuario());

        return "/Usuarios/GestionarUsuarios";
    }

    @PostMapping("/AgregarUsuario")
    public String AgregarUsuario(Usuario usuario, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            String password = usuario.getPassword();
            String encryptedPassword = passwordEncoder.encode(password);
            usuario.setPassword(encryptedPassword);
            userService.AgregarUsuarios(usuario);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha ingresado un Usuario.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ya existe un usuario con ese identificador.");
        }

        return "redirect:/viewUsuarios";
    }

    @GetMapping("/EliminarUsuario/{idUsuario}")
    public String EliminarUsuario(Usuario usuario, RedirectAttributes redirectAttributes) {
        try {
            userService.eliminarUsuario(usuario);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha eliminado el usuario correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "No se puede eliminar el usuario");
        }
        return "redirect:/viewUsuarios";
    }

    @GetMapping("/ObtenerUsuario/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Long id) {
        Usuario usuario = userService.encontrarUsuario(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/ActualizarUsuario")
    public String ActualizarUsuario(Usuario usuario, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            String password = usuario.getPassword();

            if (password != null && !password.isEmpty()) {
                // Se proporcionó una nueva contraseña, realizar validación y encriptación
                String encryptedPassword = passwordEncoder.encode(password);
                usuario.setPassword(encryptedPassword);
            } else {
                // No se proporcionó una nueva contraseña, mantener la existente en la base de datos
                Usuario existingUsuario = userService.encontrarUsuario(usuario.getIdUsuario());
                usuario.setPassword(existingUsuario.getPassword());
            }

            userService.actualizarUsuario(usuario);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha actualizado el usuario.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al actualizar el usuario.");
        }
        return "redirect:/viewUsuarios";
    }

}
