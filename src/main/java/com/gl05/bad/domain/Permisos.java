package com.gl05.bad.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name = "PERMISO")
public class Permisos implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Column(name="IDPERMISO")
    @Id
    @SequenceGenerator(name = "PERMISO_SEQ", sequenceName = "PERMISO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERMISO_SEQ")
    private int idPermiso;
    
    @Column(name="NOMBRE")
    private String nombre;
    
    @ManyToMany(mappedBy = "permisos")
    private Collection<Roles> roles;

    public int getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(int idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
