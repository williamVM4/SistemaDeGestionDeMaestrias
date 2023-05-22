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
    @NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p"),
    @NamedQuery(name = "Pais.findByIdPais", query = "SELECT p FROM Pais p WHERE p.idPais = :idPais"),
    @NamedQuery(name = "Pais.findByCodigoPais", query = "SELECT p FROM Pais p WHERE p.codigoPais = :codigoPais"),
    @NamedQuery(name = "Pais.findByNombrePais", query = "SELECT p FROM Pais p WHERE p.nombrePais = :nombrePais")})
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PAIS")
    private Long idPais;
    @Basic(optional = false)
    @Column(name = "CODIGO_PAIS")
    private String codigoPais;
    @Basic(optional = false)
    @Column(name = "NOMBRE_PAIS")
    private String nombrePais;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPais")
    //private Collection<AspiranteProfesor> aspiranteProfesorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPais")
    private Collection<CoordinadorAcademico> coordinadorAcademicoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPais")
    private Collection<Estudiante> estudianteCollection;

    public Pais() {
    }

    public Pais(Long idPais) {
        this.idPais = idPais;
    }

    public Pais(Long idPais, String codigoPais, String nombrePais) {
        this.idPais = idPais;
        this.codigoPais = codigoPais;
        this.nombrePais = nombrePais;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

   /* public Collection<AspiranteProfesor> getAspiranteProfesorCollection() {
        return aspiranteProfesorCollection;
    }

    public void setAspiranteProfesorCollection(Collection<AspiranteProfesor> aspiranteProfesorCollection) {
        this.aspiranteProfesorCollection = aspiranteProfesorCollection;
    }*/

    public Collection<CoordinadorAcademico> getCoordinadorAcademicoCollection() {
        return coordinadorAcademicoCollection;
    }

    public void setCoordinadorAcademicoCollection(Collection<CoordinadorAcademico> coordinadorAcademicoCollection) {
        this.coordinadorAcademicoCollection = coordinadorAcademicoCollection;
    }

    public Collection<Estudiante> getEstudianteCollection() {
        return estudianteCollection;
    }

    public void setEstudianteCollection(Collection<Estudiante> estudianteCollection) {
        this.estudianteCollection = estudianteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPais != null ? idPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.idPais == null && other.idPais != null) || (this.idPais != null && !this.idPais.equals(other.idPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gl05.bad.domain.Pais[ idPais=" + idPais + " ]";
    }
    
}
