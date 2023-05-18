/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl05.bad.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author william
 */
@Entity
@Table(name = "RED_SOCIAL")
@NamedQueries({
    @NamedQuery(name = "RedSocial.findAll", query = "SELECT r FROM RedSocial r"),
    @NamedQuery(name = "RedSocial.findByIdRs", query = "SELECT r FROM RedSocial r WHERE r.idRs = :idRs"),
    @NamedQuery(name = "RedSocial.findByNombreRs", query = "SELECT r FROM RedSocial r WHERE r.nombreRs = :nombreRs"),
    @NamedQuery(name = "RedSocial.findByLink", query = "SELECT r FROM RedSocial r WHERE r.link = :link")})
public class RedSocial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_RS")
    private Long idRs;
    @Basic(optional = false)
    @Column(name = "NOMBRE_RS")
    private String nombreRs;
    @Basic(optional = false)
    private String link;
    @JoinColumn(name = "ID_LIST_RS", referencedColumnName = "ID_LIST_RS")
    @ManyToOne(optional = false)
    private ListadoRedSocial idListRs;

    public RedSocial() {
    }

    public RedSocial(Long idRs) {
        this.idRs = idRs;
    }

    public RedSocial(Long idRs, String nombreRs, String link) {
        this.idRs = idRs;
        this.nombreRs = nombreRs;
        this.link = link;
    }

    public Long getIdRs() {
        return idRs;
    }

    public void setIdRs(Long idRs) {
        this.idRs = idRs;
    }

    public String getNombreRs() {
        return nombreRs;
    }

    public void setNombreRs(String nombreRs) {
        this.nombreRs = nombreRs;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ListadoRedSocial getIdListRs() {
        return idListRs;
    }

    public void setIdListRs(ListadoRedSocial idListRs) {
        this.idListRs = idListRs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRs != null ? idRs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RedSocial)) {
            return false;
        }
        RedSocial other = (RedSocial) object;
        if ((this.idRs == null && other.idRs != null) || (this.idRs != null && !this.idRs.equals(other.idRs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gl05.bad.domain.RedSocial[ idRs=" + idRs + " ]";
    }
    
}
