package com.gl05.bad.domain;

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
    private int idLpc;
    @OneToMany(mappedBy = "idLpc")
    private Collection<PerfilCoordinadorac> perfilCoordinadoracCollection;
    @OneToMany(mappedBy = "idLpc")
    private Collection<Maestria> maestriaCollection;

    public ListadoPerfilCoordinadorac() {
    }

    public ListadoPerfilCoordinadorac(int idLpc) {
        this.idLpc = idLpc;
    }

    public int getIdLpc() {
        return idLpc;
    }

    public void setIdLpc(int idLpc) {
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
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + idLpc;
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
        ListadoPerfilCoordinadorac other = (ListadoPerfilCoordinadorac) object;
        return idLpc == other.idLpc;
    }
    
    @Override
    public String toString() {
        return "ListadoPerfilCoordinadorac[ idLpc=" + idLpc + " ]";
    }
    
}
