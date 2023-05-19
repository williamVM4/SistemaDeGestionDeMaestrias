package com.gl05.bad.domain;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "PERFIL_COORDINADORAC")
@NamedQueries({
    @NamedQuery(name = "PerfilCoordinadorac.findAll", query = "SELECT p FROM PerfilCoordinadorac p"),
    @NamedQuery(name = "PerfilCoordinadorac.findByIdResca", query = "SELECT p FROM PerfilCoordinadorac p WHERE p.idResca = :idResca"),
    @NamedQuery(name = "PerfilCoordinadorac.findByTituloRespon", query = "SELECT p FROM PerfilCoordinadorac p WHERE p.tituloRespon = :tituloRespon"),
    @NamedQuery(name = "PerfilCoordinadorac.findByResponsabilidad", query = "SELECT p FROM PerfilCoordinadorac p WHERE p.responsabilidad = :responsabilidad")})
public class PerfilCoordinadorac implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "S_PERFIL_COORDINADORAC", sequenceName = "S_PERFIL_COORDINADORAC", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_PERFIL_COORDINADORAC")
    @Column(name = "ID_RESCA")
    private Integer idResca;
    @Basic(optional = false)
    @Column(name = "TITULO_RESPON")
    private String tituloRespon;
    @Basic(optional = false)
    private String responsabilidad;
    @JoinColumn(name = "ID_LPC", referencedColumnName = "ID_LPC")
    @ManyToOne
    private ListadoPerfilCoordinadorac idLpc;

    public PerfilCoordinadorac() {
    }

    public PerfilCoordinadorac(Integer idResca) {
        this.idResca = idResca;
    }

    public PerfilCoordinadorac(Integer idResca, String tituloRespon, String responsabilidad) {
        this.idResca = idResca;
        this.tituloRespon = tituloRespon;
        this.responsabilidad = responsabilidad;
    }

    public Integer getIdResca() {
        return idResca;
    }

    public void setIdResca(Integer idResca) {
        this.idResca = idResca;
    }

    public String getTituloRespon() {
        return tituloRespon;
    }

    public void setTituloRespon(String tituloRespon) {
        this.tituloRespon = tituloRespon;
    }

    public String getResponsabilidad() {
        return responsabilidad;
    }

    public void setResponsabilidad(String responsabilidad) {
        this.responsabilidad = responsabilidad;
    }

    public ListadoPerfilCoordinadorac getIdLpc() {
        return idLpc;
    }

    public void setIdLpc(ListadoPerfilCoordinadorac idLpc) {
        this.idLpc = idLpc;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResca != null ? idResca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilCoordinadorac)) {
            return false;
        }
        PerfilCoordinadorac other = (PerfilCoordinadorac) object;
        if ((this.idResca == null && other.idResca != null) || (this.idResca != null && !this.idResca.equals(other.idResca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PerfilCoordinadorac[ idResca=" + idResca + " ]";
    }
    
}
