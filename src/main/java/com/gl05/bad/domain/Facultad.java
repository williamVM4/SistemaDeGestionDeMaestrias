package com.gl05.bad.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "Facultad.findAll", query = "SELECT f FROM Facultad f"),
    @NamedQuery(name = "Facultad.findByIdFacultad", query = "SELECT f FROM Facultad f WHERE f.idFacultad = :idFacultad"),
    @NamedQuery(name = "Facultad.findByNombreFacultad", query = "SELECT f FROM Facultad f WHERE f.nombreFacultad = :nombreFacultad")})
public class Facultad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "S_FACULTAD", sequenceName = "S_FACULTAD", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_FACULTAD")
    @Column(name = "ID_FACULTAD")
    private int idFacultad;
    @Basic(optional = false)
    @Column(name = "NOMBRE_FACULTAD")
    private String nombreFacultad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFacultad")
    private Collection<EscuelaPostgrado> escuelaPostgradoCollection;

    public Facultad() {
    }

    public Facultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    public Facultad(int idFacultad, String nombreFacultad) {
        this.idFacultad = idFacultad;
        this.nombreFacultad = nombreFacultad;
    }

    public int getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(int idFacultad) {
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
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + idFacultad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Facultad other = (Facultad) object;
        return idFacultad == other.idFacultad;
    }
    
    @Override
    public String toString() {
        return "Facultad[ idFacultad=" + idFacultad + " ]";
    }
    
}
