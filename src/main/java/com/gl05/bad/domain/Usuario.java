package com.gl05.bad.domain;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
//import lombok.Data;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Column(name="IDUSUARIO")
    @Id
    @SequenceGenerator(name = "USUARIO_SEQ", sequenceName = "USUARIO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SEQ")
    private Long idUsuario;
 
    @Column(name="USERNAME")
    private String username;
    
    @Column(name="EMAIL")
    private String email;
    
    @Column(name="PASSWORD_USER")
    private String password;
    
    @Column(name="ENABLE_USER")
    private boolean enabled;
    
    @Column(name="NUMEROINTENTOS")
    private int numerointentos;
    
    @Column(name="BLOQUEADO")
    private int usuarioBloqueado;
    
    
   //Establezco la relación con la base de datos
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   @JoinTable(
           name = "USUARIO_ROLES",
            joinColumns = @JoinColumn(name="IDUSUARIO"),
            inverseJoinColumns = @JoinColumn(name="IDROL")
    )
    private Collection<Roles> roles;
 
    
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Collection<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Roles> roles) {
        this.roles = roles;
    }

    public int getNumerointentos() {
        return numerointentos;
    }

    public void setNumerointentos(int numerointentos) {
        this.numerointentos = numerointentos;
    }

    public int getUsuarioBloqueado() {
        return usuarioBloqueado;
    }

    public void setUsuarioBloqueado(int usuarioBloqueado) {
        this.usuarioBloqueado = usuarioBloqueado;
    }

    
}
