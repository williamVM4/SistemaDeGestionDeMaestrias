/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl05.bad.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "LISTADO_PERFIL_ASPIRANTE")
@NamedQueries({
    @NamedQuery(name = "ListadoPerfilAspirante.findAll", query = "SELECT l FROM ListadoPerfilAspirante l"),
    @NamedQuery(name = "ListadoPerfilAspirante.findByIdLpa", query = "SELECT l FROM ListadoPerfilAspirante l WHERE l.idLpa = :idLpa")})
public class ListadoPerfilAspirante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_LPA")
    private Long idLpa;
    @OneToMany(mappedBy = "idLpa")
    private Collection<PerfilAspirante> perfilAspiranteCollection;
    @OneToMany(mappedBy = "idLpa")
    private Collection<Maestria> maestriaCollection;

    public ListadoPerfilAspirante() {
    }

    public ListadoPerfilAspirante(Long idLpa) {
        this.idLpa = idLpa;
    }

    public Long getIdLpa() {
        return idLpa;
    }

    public void setIdLpa(Long idLpa) {
        this.idLpa = idLpa;
    }

    public Collection<PerfilAspirante> getPerfilAspiranteCollection() {
        return perfilAspiranteCollection;
    }

    public void setPerfilAspiranteCollection(Collection<PerfilAspirante> perfilAspiranteCollection) {
        this.perfilAspiranteCollection = perfilAspiranteCollection;
    }

    public Collection<Maestria> getMaestriaCollection() {
        return maestriaCollection;
    }

    public void setMaestriaCollection(Collection<Maestria> maestriaCollection) {
        this.maestriaCollection = maestriaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLpa != null ? idLpa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListadoPerfilAspirante)) {
            return false;
        }
        ListadoPerfilAspirante other = (ListadoPerfilAspirante) object;
        if ((this.idLpa == null && other.idLpa != null) || (this.idLpa != null && !this.idLpa.equals(other.idLpa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gl05.bad.domain.ListadoPerfilAspirante[ idLpa=" + idLpa + " ]";
    }
    
}
