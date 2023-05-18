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
@Table(name = "LISTADO_COHORTE")
@NamedQueries({
    @NamedQuery(name = "ListadoCohorte.findAll", query = "SELECT l FROM ListadoCohorte l"),
    @NamedQuery(name = "ListadoCohorte.findByIdListCohorte", query = "SELECT l FROM ListadoCohorte l WHERE l.idListCohorte = :idListCohorte")})
public class ListadoCohorte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_LIST_COHORTE")
    private Long idListCohorte;
    @OneToMany(mappedBy = "idListCohorte")
    private Collection<Cohorte> cohorteCollection;
    @OneToMany(mappedBy = "idListCohorte")
    private Collection<Maestria> maestriaCollection;

    public ListadoCohorte() {
    }

    public ListadoCohorte(Long idListCohorte) {
        this.idListCohorte = idListCohorte;
    }

    public Long getIdListCohorte() {
        return idListCohorte;
    }

    public void setIdListCohorte(Long idListCohorte) {
        this.idListCohorte = idListCohorte;
    }

    public Collection<Cohorte> getCohorteCollection() {
        return cohorteCollection;
    }

    public void setCohorteCollection(Collection<Cohorte> cohorteCollection) {
        this.cohorteCollection = cohorteCollection;
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
        hash += (idListCohorte != null ? idListCohorte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListadoCohorte)) {
            return false;
        }
        ListadoCohorte other = (ListadoCohorte) object;
        if ((this.idListCohorte == null && other.idListCohorte != null) || (this.idListCohorte != null && !this.idListCohorte.equals(other.idListCohorte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gl05.bad.domain.ListadoCohorte[ idListCohorte=" + idListCohorte + " ]";
    }
    
}
