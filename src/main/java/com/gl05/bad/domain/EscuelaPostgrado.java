package com.gl05.bad.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name = "ESCUELA_POSTGRADO")
@NamedQueries({
    @NamedQuery(name = "EscuelaPostgrado.findAll", query = "SELECT e FROM EscuelaPostgrado e"),
    @NamedQuery(name = "EscuelaPostgrado.findByIdPostgrado", query = "SELECT e FROM EscuelaPostgrado e WHERE e.idPostgrado = :idPostgrado"),
    @NamedQuery(name = "EscuelaPostgrado.findByNombrePostgrado", query = "SELECT e FROM EscuelaPostgrado e WHERE e.nombrePostgrado = :nombrePostgrado")})
public class EscuelaPostgrado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "S_ESCUELA_POSTGRADO", sequenceName = "S_ESCUELA_POSTGRADO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_ESCUELA_POSTGRADO")
    @Column(name = "ID_POSTGRADO")
    private int idPostgrado;
    @Basic(optional = false)
    @Column(name = "NOMBRE_POSTGRADO")
    private String nombrePostgrado;
    @JoinColumn(name = "ID_FACULTAD", referencedColumnName = "ID_FACULTAD")
    @ManyToOne(optional = false)
    private Facultad idFacultad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPostgrado")
    private Collection<Maestria> maestriaCollection;

    public EscuelaPostgrado() {
    }

    public EscuelaPostgrado(int idPostgrado) {
        this.idPostgrado = idPostgrado;
    }

    public EscuelaPostgrado(int idPostgrado, String nombrePostgrado) {
        this.idPostgrado = idPostgrado;
        this.nombrePostgrado = nombrePostgrado;
    }

    public int getIdPostgrado() {
        return idPostgrado;
    }

    public void setIdPostgrado(int idPostgrado) {
        this.idPostgrado = idPostgrado;
    }

    public String getNombrePostgrado() {
        return nombrePostgrado;
    }

    public void setNombrePostgrado(String nombrePostgrado) {
        this.nombrePostgrado = nombrePostgrado;
    }

    public Facultad getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Facultad idFacultad) {
        this.idFacultad = idFacultad;
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
        hash = prime * hash + idPostgrado;
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
        EscuelaPostgrado other = (EscuelaPostgrado) object;
        return idPostgrado == other.idPostgrado;
    }
    
    @Override
    public String toString() {
        return "EscuelaPostgrado[ idPostgrado=" + idPostgrado + " ]";
    }
    
}
