/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl05.bad.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author william
 */
@Entity
@Table(name = "AREA_CONOCIMIENTO")
@NamedQueries({
    @NamedQuery(name = "AreaConocimiento.findAll", query = "SELECT a FROM AreaConocimiento a"),
    @NamedQuery(name = "AreaConocimiento.findByIdAreaConocimiento", query = "SELECT a FROM AreaConocimiento a WHERE a.idAreaConocimiento = :idAreaConocimiento"),
    @NamedQuery(name = "AreaConocimiento.findByNombreArea", query = "SELECT a FROM AreaConocimiento a WHERE a.nombreArea = :nombreArea"),
    @NamedQuery(name = "AreaConocimiento.findByDescripcion", query = "SELECT a FROM AreaConocimiento a WHERE a.descripcion = :descripcion")})
public class AreaConocimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_AREA_CONOCIMIENTO")
    private Long idAreaConocimiento;
    @Basic(optional = false)
    @Column(name = "NOMBRE_AREA")
    private String nombreArea;
    @Basic(optional = false)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAreaConocimiento")
    private Collection<Asignatura> asignaturaCollection;

    public AreaConocimiento() {
    }

    public AreaConocimiento(Long idAreaConocimiento) {
        this.idAreaConocimiento = idAreaConocimiento;
    }

    public AreaConocimiento(Long idAreaConocimiento, String nombreArea, String descripcion) {
        this.idAreaConocimiento = idAreaConocimiento;
        this.nombreArea = nombreArea;
        this.descripcion = descripcion;
    }

    public Long getIdAreaConocimiento() {
        return idAreaConocimiento;
    }

    public void setIdAreaConocimiento(Long idAreaConocimiento) {
        this.idAreaConocimiento = idAreaConocimiento;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<Asignatura> getAsignaturaCollection() {
        return asignaturaCollection;
    }

    public void setAsignaturaCollection(Collection<Asignatura> asignaturaCollection) {
        this.asignaturaCollection = asignaturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAreaConocimiento != null ? idAreaConocimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaConocimiento)) {
            return false;
        }
        AreaConocimiento other = (AreaConocimiento) object;
        if ((this.idAreaConocimiento == null && other.idAreaConocimiento != null) || (this.idAreaConocimiento != null && !this.idAreaConocimiento.equals(other.idAreaConocimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gl05.bad.domain.AreaConocimiento[ idAreaConocimiento=" + idAreaConocimiento + " ]";
    }
    
}
