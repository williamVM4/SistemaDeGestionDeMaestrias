package com.gl05.bad.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "ROL")
public class Roles implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Column(name="IDROL")
    @Id
    @SequenceGenerator(name = "ROL_SEQ", sequenceName = "ROL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROL_SEQ")
    private int idRol;
    
    @Column(name="NOMBRE")
    private String nombre;
    
    @ManyToMany(mappedBy = "roles")
    private Collection<Usuario> users;
    
    //Establezco la relación con la base de datos
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   @JoinTable(
           name = "ROLES_PERMISOS",
            joinColumns = @JoinColumn(name="IDROL"),
            inverseJoinColumns = @JoinColumn(name="IDPERMISO")
    )
    private Collection<Permisos> permisos;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Permisos> getPermisos() {
        return permisos;
    }

    public void setPermisos(Collection<Permisos> permisos) {
        this.permisos = permisos;
    }

}
