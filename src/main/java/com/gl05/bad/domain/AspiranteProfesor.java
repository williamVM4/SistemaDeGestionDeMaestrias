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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author william
 */
@Entity
@Table(name = "ASPIRANTE_PROFESOR")
@NamedQueries({
    @NamedQuery(name = "AspiranteProfesor.findAll", query = "SELECT a FROM AspiranteProfesor a"),
    @NamedQuery(name = "AspiranteProfesor.findByIdAspiranteProfesor", query = "SELECT a FROM AspiranteProfesor a WHERE a.idAspiranteProfesor = :idAspiranteProfesor"),
    @NamedQuery(name = "AspiranteProfesor.findByCodAp", query = "SELECT a FROM AspiranteProfesor a WHERE a.codAp = :codAp"),
    @NamedQuery(name = "AspiranteProfesor.findByNombresAp", query = "SELECT a FROM AspiranteProfesor a WHERE a.nombresAp = :nombresAp"),
    @NamedQuery(name = "AspiranteProfesor.findByApellidosAp", query = "SELECT a FROM AspiranteProfesor a WHERE a.apellidosAp = :apellidosAp"),
    @NamedQuery(name = "AspiranteProfesor.findBySexoAp", query = "SELECT a FROM AspiranteProfesor a WHERE a.sexoAp = :sexoAp"),
    @NamedQuery(name = "AspiranteProfesor.findByGeneroAp", query = "SELECT a FROM AspiranteProfesor a WHERE a.generoAp = :generoAp"),
    @NamedQuery(name = "AspiranteProfesor.findByFechaNacAp", query = "SELECT a FROM AspiranteProfesor a WHERE a.fechaNacAp = :fechaNacAp"),
    @NamedQuery(name = "AspiranteProfesor.findByEstadoCivilAp", query = "SELECT a FROM AspiranteProfesor a WHERE a.estadoCivilAp = :estadoCivilAp"),
    @NamedQuery(name = "AspiranteProfesor.findByNacionalidadAp", query = "SELECT a FROM AspiranteProfesor a WHERE a.nacionalidadAp = :nacionalidadAp"),
    @NamedQuery(name = "AspiranteProfesor.findByDuiAp", query = "SELECT a FROM AspiranteProfesor a WHERE a.duiAp = :duiAp"),
    @NamedQuery(name = "AspiranteProfesor.findByNitAp", query = "SELECT a FROM AspiranteProfesor a WHERE a.nitAp = :nitAp"),
    @NamedQuery(name = "AspiranteProfesor.findByNupAp", query = "SELECT a FROM AspiranteProfesor a WHERE a.nupAp = :nupAp"),
    @NamedQuery(name = "AspiranteProfesor.findByPasaporteAp", query = "SELECT a FROM AspiranteProfesor a WHERE a.pasaporteAp = :pasaporteAp"),
    @NamedQuery(name = "AspiranteProfesor.findByDocPersonalAp", query = "SELECT a FROM AspiranteProfesor a WHERE a.docPersonalAp = :docPersonalAp")})
public class AspiranteProfesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ASPIRANTE_PROFESOR")
    private Long idAspiranteProfesor;
    @Basic(optional = false)
    @Column(name = "COD_AP")
    private String codAp;
    @Basic(optional = false)
    @Column(name = "NOMBRES_AP")
    private String nombresAp;
    @Basic(optional = false)
    @Column(name = "APELLIDOS_AP")
    private String apellidosAp;
    @Basic(optional = false)
    @Column(name = "SEXO_AP")
    private String sexoAp;
    @Basic(optional = false)
    @Column(name = "GENERO_AP")
    private String generoAp;
    @Basic(optional = false)
    @Column(name = "FECHA_NAC_AP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacAp;
    @Basic(optional = false)
    @Column(name = "ESTADO_CIVIL_AP")
    private String estadoCivilAp;
    @Basic(optional = false)
    @Column(name = "NACIONALIDAD_AP")
    private String nacionalidadAp;
    @Basic(optional = false)
    @Lob
    @Column(name = "FOTOGRAFIA_AP")
    private Serializable fotografiaAp;
    @Column(name = "DUI_AP")
    private String duiAp;
    @Column(name = "NIT_AP")
    private String nitAp;
    @Column(name = "NUP_AP")
    private String nupAp;
    @Column(name = "PASAPORTE_AP")
    private String pasaporteAp;
    @Column(name = "DOC_PERSONAL_AP")
    private String docPersonalAp;
    @JoinColumn(name = "ID_LIST_CORREO", referencedColumnName = "ID_LIST_CORREO")
    @ManyToOne
    private ListadoCorreo idListCorreo;
    @JoinColumn(name = "ID_LIST_DP", referencedColumnName = "ID_LIST_DP")
    @ManyToOne
    private ListadoDocumentacionPersonal idListDp;
    @JoinColumn(name = "ID_LIST_EL", referencedColumnName = "ID_LIST_EL")
    @ManyToOne
    private ListadoExperienciaLaboral idListEl;
    @JoinColumn(name = "ID_LIST_RS", referencedColumnName = "ID_LIST_RS")
    @ManyToOne
    private ListadoRedSocial idListRs;
    @JoinColumn(name = "ID_LIST_TELEFONO", referencedColumnName = "ID_LIST_TELEFONO")
    @ManyToOne
    private ListadoTelefono idListTelefono;
    @JoinColumn(name = "ID_LIST_TA", referencedColumnName = "ID_LIST_TA")
    @ManyToOne
    private ListadoTitulosAcademicos idListTa;
    @JoinColumn(name = "ID_PAIS", referencedColumnName = "ID_PAIS")
    @ManyToOne(optional = false)
    private Pais idPais;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuario idusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAspiranteProfesor")
    private Collection<ProfesorCohorte> profesorCohorteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAspiranteProfesor")
    private Collection<PostulacionCohorte> postulacionCohorteCollection;

    public AspiranteProfesor() {
    }

    public AspiranteProfesor(Long idAspiranteProfesor) {
        this.idAspiranteProfesor = idAspiranteProfesor;
    }

    public AspiranteProfesor(Long idAspiranteProfesor, String codAp, String nombresAp, String apellidosAp, String sexoAp, String generoAp, Date fechaNacAp, String estadoCivilAp, String nacionalidadAp, Serializable fotografiaAp) {
        this.idAspiranteProfesor = idAspiranteProfesor;
        this.codAp = codAp;
        this.nombresAp = nombresAp;
        this.apellidosAp = apellidosAp;
        this.sexoAp = sexoAp;
        this.generoAp = generoAp;
        this.fechaNacAp = fechaNacAp;
        this.estadoCivilAp = estadoCivilAp;
        this.nacionalidadAp = nacionalidadAp;
        this.fotografiaAp = fotografiaAp;
    }

    public Long getIdAspiranteProfesor() {
        return idAspiranteProfesor;
    }

    public void setIdAspiranteProfesor(Long idAspiranteProfesor) {
        this.idAspiranteProfesor = idAspiranteProfesor;
    }

    public String getCodAp() {
        return codAp;
    }

    public void setCodAp(String codAp) {
        this.codAp = codAp;
    }

    public String getNombresAp() {
        return nombresAp;
    }

    public void setNombresAp(String nombresAp) {
        this.nombresAp = nombresAp;
    }

    public String getApellidosAp() {
        return apellidosAp;
    }

    public void setApellidosAp(String apellidosAp) {
        this.apellidosAp = apellidosAp;
    }

    public String getSexoAp() {
        return sexoAp;
    }

    public void setSexoAp(String sexoAp) {
        this.sexoAp = sexoAp;
    }

    public String getGeneroAp() {
        return generoAp;
    }

    public void setGeneroAp(String generoAp) {
        this.generoAp = generoAp;
    }

    public Date getFechaNacAp() {
        return fechaNacAp;
    }

    public void setFechaNacAp(Date fechaNacAp) {
        this.fechaNacAp = fechaNacAp;
    }

    public String getEstadoCivilAp() {
        return estadoCivilAp;
    }

    public void setEstadoCivilAp(String estadoCivilAp) {
        this.estadoCivilAp = estadoCivilAp;
    }

    public String getNacionalidadAp() {
        return nacionalidadAp;
    }

    public void setNacionalidadAp(String nacionalidadAp) {
        this.nacionalidadAp = nacionalidadAp;
    }

    public Serializable getFotografiaAp() {
        return fotografiaAp;
    }

    public void setFotografiaAp(Serializable fotografiaAp) {
        this.fotografiaAp = fotografiaAp;
    }

    public String getDuiAp() {
        return duiAp;
    }

    public void setDuiAp(String duiAp) {
        this.duiAp = duiAp;
    }

    public String getNitAp() {
        return nitAp;
    }

    public void setNitAp(String nitAp) {
        this.nitAp = nitAp;
    }

    public String getNupAp() {
        return nupAp;
    }

    public void setNupAp(String nupAp) {
        this.nupAp = nupAp;
    }

    public String getPasaporteAp() {
        return pasaporteAp;
    }

    public void setPasaporteAp(String pasaporteAp) {
        this.pasaporteAp = pasaporteAp;
    }

    public String getDocPersonalAp() {
        return docPersonalAp;
    }

    public void setDocPersonalAp(String docPersonalAp) {
        this.docPersonalAp = docPersonalAp;
    }

    public ListadoCorreo getIdListCorreo() {
        return idListCorreo;
    }

    public void setIdListCorreo(ListadoCorreo idListCorreo) {
        this.idListCorreo = idListCorreo;
    }

    public ListadoDocumentacionPersonal getIdListDp() {
        return idListDp;
    }

    public void setIdListDp(ListadoDocumentacionPersonal idListDp) {
        this.idListDp = idListDp;
    }

    public ListadoExperienciaLaboral getIdListEl() {
        return idListEl;
    }

    public void setIdListEl(ListadoExperienciaLaboral idListEl) {
        this.idListEl = idListEl;
    }

    public ListadoRedSocial getIdListRs() {
        return idListRs;
    }

    public void setIdListRs(ListadoRedSocial idListRs) {
        this.idListRs = idListRs;
    }

    public ListadoTelefono getIdListTelefono() {
        return idListTelefono;
    }

    public void setIdListTelefono(ListadoTelefono idListTelefono) {
        this.idListTelefono = idListTelefono;
    }

    public ListadoTitulosAcademicos getIdListTa() {
        return idListTa;
    }

    public void setIdListTa(ListadoTitulosAcademicos idListTa) {
        this.idListTa = idListTa;
    }

    public Pais getIdPais() {
        return idPais;
    }

    public void setIdPais(Pais idPais) {
        this.idPais = idPais;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Collection<ProfesorCohorte> getProfesorCohorteCollection() {
        return profesorCohorteCollection;
    }

    public void setProfesorCohorteCollection(Collection<ProfesorCohorte> profesorCohorteCollection) {
        this.profesorCohorteCollection = profesorCohorteCollection;
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
        hash += (idAspiranteProfesor != null ? idAspiranteProfesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AspiranteProfesor)) {
            return false;
        }
        AspiranteProfesor other = (AspiranteProfesor) object;
        if ((this.idAspiranteProfesor == null && other.idAspiranteProfesor != null) || (this.idAspiranteProfesor != null && !this.idAspiranteProfesor.equals(other.idAspiranteProfesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gl05.bad.domain.AspiranteProfesor[ idAspiranteProfesor=" + idAspiranteProfesor + " ]";
    }
    
}
