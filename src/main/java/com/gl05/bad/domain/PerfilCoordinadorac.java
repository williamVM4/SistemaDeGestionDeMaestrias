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
    private int idResca;
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

    public PerfilCoordinadorac(int idResca) {
        this.idResca = idResca;
    }

    public PerfilCoordinadorac(int idResca, String tituloRespon, String responsabilidad) {
        this.idResca = idResca;
        this.tituloRespon = tituloRespon;
        this.responsabilidad = responsabilidad;
    }

    public int getIdResca() {
        return idResca;
    }

    public void setIdResca(int idResca) {
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
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + idResca;
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
        PerfilCoordinadorac other = (PerfilCoordinadorac) object;
        return idResca == other.idResca;
    }

    @Override
    public String toString() {
        return "PerfilCoordinadorac[ idResca=" + idResca + " ]";
    }
    
}
