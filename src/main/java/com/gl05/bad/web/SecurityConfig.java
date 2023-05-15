package com.gl05.bad.web;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    //Agregar y personalizar usuarios dentro del sistema
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("{noop}123")
//                .roles("ADMIN","USER")
//            .and()
//                .withUser("user")
//                .password("{noop}123")
//                .roles("USER")
//                ;
//                
//    }
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    
//     @Bean
//        public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception{
// 
//                http
//                        .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/editar/**", "/agregar/**", "/eliminar")
//                                .hasRole("ADMIN")
//                                .requestMatchers("/").hasAnyRole("ADMIN", "USER")
//                                .anyRequest().authenticated()
//                        )
//                        .formLogin(form -> form.loginPage("/login")
//                                .defaultSuccessUrl("/", true)
//                                .permitAll()
//                        )
//                        .logout(logout -> logout                                                
//                                .logoutUrl("/logout")
//                                .logoutSuccessUrl("/login")
//                                .invalidateHttpSession(true)
//                        )
//                        .exceptionHandling().accessDeniedPage("/errores/403");
//                
//                return http.build();
// 
////            
//              
//        }

    @Bean
        protected AuthenticationManager authManager(HttpSecurity http) throws Exception{
                return http.getSharedObject(AuthenticationManagerBuilder.class)
                        .userDetailsService(userDetailsService)
                        .passwordEncoder(passwordEncoder())
                        .and()
                        .build();
        }
    
         @Bean
        protected PasswordEncoder passwordEncoder(){
                return new BCryptPasswordEncoder();
        }

//    //@Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    
//    @Autowired
//    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
//        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
    
    
    //Metodo que se utiliza para la reestricción de urls
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
               //Con esto puedo reestringir los usuarios por
               //vistas
                .antMatchers("/welcome2")
                //Coloco el rol al cual podra redirigirse a estas vistas
//                    .hasRole("ADMIN")
                      .hasAuthority("VER_ADMIN_PRIVILEGE")
//                Modificar cuando se tenga login               
                .antMatchers("/login","/logout","/")
                    .hasAnyAuthority("VER_ADMIN_PRIVILEGE", "VER_USUARIO_PRIVILEGE")
//                    .hasAnyRole("USER","ADMIN")
                .antMatchers("/welcome3")
                      .hasAuthority("VER_USUARIO_PRIVILEGE")
                .and()
                .formLogin()
//                .loginPage("/login")
                ;
    }
    
}

