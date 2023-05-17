package com.gl05.bad.web;

import com.gl05.bad.dao.UsuarioDao;
import com.gl05.bad.domain.Usuario;
import com.gl05.bad.servicio.UsuarioService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class FalloAutenticacion implements AuthenticationFailureHandler {

    private JavaMailSender javaMailSender;

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private UserDetailsService usuarioService;

    public FalloAutenticacion(JavaMailSender javaMailSender, UserDetailsService usuarioService) {
        this.javaMailSender = javaMailSender;
        this.usuarioService = usuarioService;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {

        //Formulario
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //Base
        Usuario usuario = usuarioDao.findByUsername(username);

        //Cuando el usuario esta bloqueado por los 3 intentos
        if (username.equals(usuario.getUsername()) && usuario.getUsuarioBloqueado() == 1) {
            response.sendRedirect("/correctcredentialsdisable");
        } else if (username.equals(usuario.getUsername()) || usuario.getUsuarioBloqueado() == 0) {
            //Incrementamos el contador de intentos fallidos
            int intentos = usuario.getNumerointentos() + 1;
            usuario.setNumerointentos(intentos);
            usuarioDao.save(usuario);

            //Verificar si el usuario ha sido bloqueado
            if (intentos >= 3) {
                usuario.setUsuarioBloqueado(1);
                usuarioDao.save(usuario);
                // Enviar correo electrónico al administrador 
                String usuarioEmail = usuario.getEmail();
                String adminEmail = "badmaestria08@gmail.com";
                String subject = "Usuario bloqueado";
                String message = "El usuario " + username + " con correo " + usuarioEmail + " ha sido bloqueado después de 3 intentos fallidos de inicio de sesión.";
                sendEmail(usuarioEmail, adminEmail, subject, message);
                response.sendRedirect("/errorpage");
            } else {
                // Redirigir al usuario a la página de inicio de sesión
                response.sendRedirect("/login");
            }
        }

    }

    //Metodo para el envio de correo electronico
    private void sendEmail(String from, String to, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);
    }

}
