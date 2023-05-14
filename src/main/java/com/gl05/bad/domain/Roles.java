package com.gl05.bad.domain;

import java.io.Serializable;
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

    
    
    
}
