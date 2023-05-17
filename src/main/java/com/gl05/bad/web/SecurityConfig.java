package com.gl05.bad.web;

import com.gl05.bad.dao.UsuarioDao;
import com.gl05.bad.domain.Usuario;
import java.io.IOException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import java.util.Properties;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

//    @Autowired
//    private JavaMailSender javaMailSender;
    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("badmaestria08@gmail.com");
        mailSender.setPassword("wdayaatpxrhlpvri");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        
        Session session = Session.getDefaultInstance(props);
        mailSender.setSession(session);
        
        return mailSender;
    }

    @Bean
    public AuthenticationFailureHandler falloAutenticacionHandler() {
        return new FalloAutenticacion(javaMailSender(), userDetailsService);
    }

    @Bean
    protected AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Metodo que se utiliza para la reestricción de urls
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                //Con esto puedo reestringir los usuarios por
                //vistas
                .antMatchers("/welcome2")
                //Coloco el rol al cual podra redirigirse a estas vistas
                //                    .hasRole("ADMIN")
                .hasAuthority("VER_ADMIN_PRIVILEGE")
                //                Modificar cuando se tenga login               
                .antMatchers("/login", "/logout", "/")
                .hasAnyAuthority("VER_ADMIN_PRIVILEGE", "VER_USUARIO_PRIVILEGE")
                //                    .hasAnyRole("USER","ADMIN")
                .antMatchers("/welcome3")
                .hasAuthority("VER_USUARIO_PRIVILEGE")
                .and()
                .formLogin()
                .failureHandler(falloAutenticacionHandler())
                .successHandler(authenticationSuccessHandler());
                //.failureUrl("/login?error=true");
    }
    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return (AuthenticationSuccessHandler) new CustomAuthenticationSuccessHandler();
    }
    @Autowired
    private UsuarioDao usuarioDao;
    private class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
            String username = authentication.getName();
            Usuario usuario = usuarioDao.findByUsername(username);

            if (usuario != null && usuario.getUsuarioBloqueado() == 1) {
                response.sendRedirect("/correctcredentialsdisable");
            } else {
                super.onAuthenticationSuccess(request, response, authentication);
            }
        }
    }

}
