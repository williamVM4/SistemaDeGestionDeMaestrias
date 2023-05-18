/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl05.bad.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author william
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Cohorte.findAll", query = "SELECT c FROM Cohorte c"),
    @NamedQuery(name = "Cohorte.findByIdCohorte", query = "SELECT c FROM Cohorte c WHERE c.idCohorte = :idCohorte"),
    @NamedQuery(name = "Cohorte.findByFechaApertura", query = "SELECT c FROM Cohorte c WHERE c.fechaApertura = :fechaApertura"),
    @NamedQuery(name = "Cohorte.findByEstadoCohorte", query = "SELECT c FROM Cohorte c WHERE c.estadoCohorte = :estadoCohorte")})
public class Cohorte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_COHORTE")
    private Long idCohorte;
    @Basic(optional = false)
    @Column(name = "FECHA_APERTURA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaApertura;
    @Basic(optional = false)
    @Column(name = "ESTADO_COHORTE")
    private short estadoCohorte;
    @JoinColumn(name = "ID_LIST_COHORTE", referencedColumnName = "ID_LIST_COHORTE")
    @ManyToOne
    private ListadoCohorte idListCohorte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCohorte")
    private Collection<ProfesorCohorte> profesorCohorteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCohorte")
    private Collection<EstudianteCohorte> estudianteCohorteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCohorte")
    private Collection<PostulacionCohorte> postulacionCohorteCollection;

    public Cohorte() {
    }

    public Cohorte(Long idCohorte) {
        this.idCohorte = idCohorte;
    }

    public Cohorte(Long idCohorte, Date fechaApertura, short estadoCohorte) {
        this.idCohorte = idCohorte;
        this.fechaApertura = fechaApertura;
        this.estadoCohorte = estadoCohorte;
    }

    public Long getIdCohorte() {
        return idCohorte;
    }

    public void setIdCohorte(Long idCohorte) {
        this.idCohorte = idCohorte;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public short getEstadoCohorte() {
        return estadoCohorte;
    }

    public void setEstadoCohorte(short estadoCohorte) {
        this.estadoCohorte = estadoCohorte;
    }

    public ListadoCohorte getIdListCohorte() {
        return idListCohorte;
    }

    public void setIdListCohorte(ListadoCohorte idListCohorte) {
        this.idListCohorte = idListCohorte;
    }

    public Collection<ProfesorCohorte> getProfesorCohorteCollection() {
        return profesorCohorteCollection;
    }

    public void setProfesorCohorteCollection(Collection<ProfesorCohorte> profesorCohorteCollection) {
        this.profesorCohorteCollection = profesorCohorteCollection;
    }

    public Collection<EstudianteCohorte> getEstudianteCohorteCollection() {
        return estudianteCohorteCollection;
    }

    public void setEstudianteCohorteCollection(Collection<EstudianteCohorte> estudianteCohorteCollection) {
        this.estudianteCohorteCollection = estudianteCohorteCollection;
    }

    public Collection<PostulacionCohorte> getPostulacionCohorteCollection() {
        return postulacionCohorteCollection;
    }

    public void setPostulacionCohorteCollection(Collection<PostulacionCohorte> postulacionCohorteCollection) {
        this.postulacionCohorteCollection = postulacionCohorteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCohorte != null ? idCohorte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cohorte)) {
            return false;
        }
        Cohorte other = (Cohorte) object;
        if ((this.idCohorte == null && other.idCohorte != null) || (this.idCohorte != null && !this.idCohorte.equals(other.idCohorte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gl05.bad.domain.Cohorte[ idCohorte=" + idCohorte + " ]";
    }
    
}
