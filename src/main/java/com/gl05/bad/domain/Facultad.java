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

/**
 *
 * @author william
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Facultad.findAll", query = "SELECT f FROM Facultad f"),
    @NamedQuery(name = "Facultad.findByIdFacultad", query = "SELECT f FROM Facultad f WHERE f.idFacultad = :idFacultad"),
    @NamedQuery(name = "Facultad.findByNombreFacultad", query = "SELECT f FROM Facultad f WHERE f.nombreFacultad = :nombreFacultad")})
public class Facultad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_FACULTAD")
    private Long idFacultad;
    @Basic(optional = false)
    @Column(name = "NOMBRE_FACULTAD")
    private String nombreFacultad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFacultad")
    private Collection<EscuelaPostgrado> escuelaPostgradoCollection;

    public Facultad() {
    }

    public Facultad(Long idFacultad) {
        this.idFacultad = idFacultad;
    }

    public Facultad(Long idFacultad, String nombreFacultad) {
        this.idFacultad = idFacultad;
        this.nombreFacultad = nombreFacultad;
    }

    public Long getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Long idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getNombreFacultad() {
        return nombreFacultad;
    }

    public void setNombreFacultad(String nombreFacultad) {
        this.nombreFacultad = nombreFacultad;
    }

    public Collection<EscuelaPostgrado> getEscuelaPostgradoCollection() {
        return escuelaPostgradoCollection;
    }

    public void setEscuelaPostgradoCollection(Collection<EscuelaPostgrado> escuelaPostgradoCollection) {
        this.escuelaPostgradoCollection = escuelaPostgradoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacultad != null ? idFacultad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facultad)) {
            return false;
        }
        Facultad other = (Facultad) object;
        if ((this.idFacultad == null && other.idFacultad != null) || (this.idFacultad != null && !this.idFacultad.equals(other.idFacultad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gl05.bad.domain.Facultad[ idFacultad=" + idFacultad + " ]";
    }
    
}
