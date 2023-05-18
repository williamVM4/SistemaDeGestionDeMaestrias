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
@Table(name = "LISTADO_PERFIL_COORDINADORAC")
@NamedQueries({
    @NamedQuery(name = "ListadoPerfilCoordinadorac.findAll", query = "SELECT l FROM ListadoPerfilCoordinadorac l"),
    @NamedQuery(name = "ListadoPerfilCoordinadorac.findByIdLpc", query = "SELECT l FROM ListadoPerfilCoordinadorac l WHERE l.idLpc = :idLpc")})
public class ListadoPerfilCoordinadorac implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_LPC")
    private Long idLpc;
    @OneToMany(mappedBy = "idLpc")
    private Collection<PerfilCoordinadorac> perfilCoordinadoracCollection;
    @OneToMany(mappedBy = "idLpc")
    private Collection<Maestria> maestriaCollection;

    public ListadoPerfilCoordinadorac() {
    }

    public ListadoPerfilCoordinadorac(Long idLpc) {
        this.idLpc = idLpc;
    }

    public Long getIdLpc() {
        return idLpc;
    }

    public void setIdLpc(Long idLpc) {
        this.idLpc = idLpc;
    }

    public Collection<PerfilCoordinadorac> getPerfilCoordinadoracCollection() {
        return perfilCoordinadoracCollection;
    }

    public void setPerfilCoordinadoracCollection(Collection<PerfilCoordinadorac> perfilCoordinadoracCollection) {
        this.perfilCoordinadoracCollection = perfilCoordinadoracCollection;
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
        hash += (idLpc != null ? idLpc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListadoPerfilCoordinadorac)) {
            return false;
        }
        ListadoPerfilCoordinadorac other = (ListadoPerfilCoordinadorac) object;
        if ((this.idLpc == null && other.idLpc != null) || (this.idLpc != null && !this.idLpc.equals(other.idLpc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gl05.bad.domain.ListadoPerfilCoordinadorac[ idLpc=" + idLpc + " ]";
    }
    
}
