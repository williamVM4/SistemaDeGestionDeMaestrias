package com.gl05.bad.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name = "LISTADO_PERFIL_ASPIRANTE")
@NamedQueries({
    @NamedQuery(name = "ListadoPerfilAspirante.findAll", query = "SELECT l FROM ListadoPerfilAspirante l"),
    @NamedQuery(name = "ListadoPerfilAspirante.findByIdLpa", query = "SELECT l FROM ListadoPerfilAspirante l WHERE l.idLpa = :idLpa")})
public class ListadoPerfilAspirante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "S_LISTADO_PERFIL_ASPIRANTE", sequenceName = "S_LISTADO_PERFIL_ASPIRANTE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_LISTADO_PERFIL_ASPIRANTE")
    @Column(name = "ID_LPA")
    private Integer idLpa;
    @OneToMany(mappedBy = "idLpa")
    private Collection<PerfilAspirante> perfilAspiranteCollection;
    @OneToMany(mappedBy = "idLpa")
    private Collection<Maestria> maestriaCollection;

    public ListadoPerfilAspirante() {
    }

    public ListadoPerfilAspirante(Integer idLpa) {
        this.idLpa = idLpa;
    }

    public Integer getIdLpa() {
        return idLpa;
    }

    public void setIdLpa(Integer idLpa) {
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
        return "ListadoPerfilAspirante[ idLpa=" + idLpa + " ]";
    }
    
}
