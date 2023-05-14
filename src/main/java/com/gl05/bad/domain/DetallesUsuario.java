package com.gl05.bad.domain;

import java.util.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DetallesUsuario implements UserDetails{

    private Usuario usuario;

    public DetallesUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Roles> roles = usuario.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        
        for(Roles role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getNombre()));
        }
        
        return authorities;
    }

    @Override
    public String getPassword() {
       return usuario.getPassword();
    }

    @Override
    public String getUsername() {
        return usuario.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return usuario.isEnabled();
    }
    
}
