package com.gl05.bad.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name = "LISTADO_PERFIL_COORDINADORAC")
@NamedQueries({
    @NamedQuery(name = "ListadoPerfilCoordinadorac.findAll", query = "SELECT l FROM ListadoPerfilCoordinadorac l"),
    @NamedQuery(name = "ListadoPerfilCoordinadorac.findByIdLpc", query = "SELECT l FROM ListadoPerfilCoordinadorac l WHERE l.idLpc = :idLpc")})
public class ListadoPerfilCoordinadorac implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "S_LISTADO_PERFIL_COORDINADORAC", sequenceName = "S_LISTADO_PERFIL_COORDINADORAC", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_LISTADO_PERFIL_COORDINADORAC")
    @Column(name = "ID_LPC")
    private Integer idLpc;
    @JsonIgnore
    @OneToMany(mappedBy = "idLpc")
    private Collection<PerfilCoordinadorac> perfilCoordinadoracCollection;
    @JsonIgnore
    @OneToMany(mappedBy = "idLpc")
    private Collection<Maestria> maestriaCollection;

    public ListadoPerfilCoordinadorac() {
    }

    public ListadoPerfilCoordinadorac(Integer idLpc) {
        this.idLpc = idLpc;
    }

    public Integer getIdLpc() {
        return idLpc;
    }

    public void setIdLpc(Integer idLpc) {
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
        return "ListadoPerfilCoordinadorac[ idLpc=" + idLpc + " ]";
    }
    
}
