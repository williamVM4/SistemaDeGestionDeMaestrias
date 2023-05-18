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

@Entity
@Table(name = "COORDINADOR_ACADEMICO")
@NamedQueries({
    @NamedQuery(name = "CoordinadorAcademico_1.findAll", query = "SELECT c FROM CoordinadorAcademico_1 c"),
    @NamedQuery(name = "CoordinadorAcademico_1.findByIdCoorAca", query = "SELECT c FROM CoordinadorAcademico_1 c WHERE c.idCoorAca = :idCoorAca"),
    @NamedQuery(name = "CoordinadorAcademico_1.findByCodCa", query = "SELECT c FROM CoordinadorAcademico_1 c WHERE c.codCa = :codCa"),
    @NamedQuery(name = "CoordinadorAcademico_1.findByNombresCa", query = "SELECT c FROM CoordinadorAcademico_1 c WHERE c.nombresCa = :nombresCa"),
    @NamedQuery(name = "CoordinadorAcademico_1.findByApellidosCa", query = "SELECT c FROM CoordinadorAcademico_1 c WHERE c.apellidosCa = :apellidosCa"),
    @NamedQuery(name = "CoordinadorAcademico_1.findBySexoCa", query = "SELECT c FROM CoordinadorAcademico_1 c WHERE c.sexoCa = :sexoCa"),
    @NamedQuery(name = "CoordinadorAcademico_1.findByGeneroCa", query = "SELECT c FROM CoordinadorAcademico_1 c WHERE c.generoCa = :generoCa"),
    @NamedQuery(name = "CoordinadorAcademico_1.findByFechaNacCa", query = "SELECT c FROM CoordinadorAcademico_1 c WHERE c.fechaNacCa = :fechaNacCa"),
    @NamedQuery(name = "CoordinadorAcademico_1.findByEstadoCivilCa", query = "SELECT c FROM CoordinadorAcademico_1 c WHERE c.estadoCivilCa = :estadoCivilCa"),
    @NamedQuery(name = "CoordinadorAcademico_1.findByNacionalidadCa", query = "SELECT c FROM CoordinadorAcademico_1 c WHERE c.nacionalidadCa = :nacionalidadCa"),
    @NamedQuery(name = "CoordinadorAcademico_1.findByDuiCa", query = "SELECT c FROM CoordinadorAcademico_1 c WHERE c.duiCa = :duiCa"),
    @NamedQuery(name = "CoordinadorAcademico_1.findByNitCa", query = "SELECT c FROM CoordinadorAcademico_1 c WHERE c.nitCa = :nitCa"),
    @NamedQuery(name = "CoordinadorAcademico_1.findByNupCa", query = "SELECT c FROM CoordinadorAcademico_1 c WHERE c.nupCa = :nupCa"),
    @NamedQuery(name = "CoordinadorAcademico_1.findByPasaporteCa", query = "SELECT c FROM CoordinadorAcademico_1 c WHERE c.pasaporteCa = :pasaporteCa"),
    @NamedQuery(name = "CoordinadorAcademico_1.findByDocPersonalCa", query = "SELECT c FROM CoordinadorAcademico_1 c WHERE c.docPersonalCa = :docPersonalCa")})
public class CoordinadorAcademico_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_COOR_ACA")
    private Long idCoorAca;
    @Basic(optional = false)
    @Column(name = "COD_CA")
    private String codCa;
    @Basic(optional = false)
    @Column(name = "NOMBRES_CA")
    private String nombresCa;
    @Basic(optional = false)
    @Column(name = "APELLIDOS_CA")
    private String apellidosCa;
    @Basic(optional = false)
    @Column(name = "SEXO_CA")
    private String sexoCa;
    @Basic(optional = false)
    @Column(name = "GENERO_CA")
    private String generoCa;
    @Basic(optional = false)
    @Column(name = "FECHA_NAC_CA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacCa;
    @Basic(optional = false)
    @Column(name = "ESTADO_CIVIL_CA")
    private String estadoCivilCa;
    @Basic(optional = false)
    @Column(name = "NACIONALIDAD_CA")
    private String nacionalidadCa;
    @Basic(optional = false)
    @Lob
    @Column(name = "FOTOGRAFIA_CA")
    private Serializable fotografiaCa;
    @Column(name = "DUI_CA")
    private String duiCa;
    @Column(name = "NIT_CA")
    private String nitCa;
    @Column(name = "NUP_CA")
    private String nupCa;
    @Column(name = "PASAPORTE_CA")
    private String pasaporteCa;
    @Column(name = "DOC_PERSONAL_CA")
    private String docPersonalCa;
    @JoinColumn(name = "ID_LIST_CORREO", referencedColumnName = "ID_LIST_CORREO")
    @ManyToOne(optional = false)
    private ListadoCorreo idListCorreo;
    @JoinColumn(name = "ID_LIST_DP", referencedColumnName = "ID_LIST_DP")
    @ManyToOne
    private ListadoDocumentacionPersonal idListDp;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCoorAca")
    private Collection<Maestria> maestriaCollection;

    public CoordinadorAcademico_1() {
    }

    public CoordinadorAcademico_1(Long idCoorAca) {
        this.idCoorAca = idCoorAca;
    }

    public CoordinadorAcademico_1(Long idCoorAca, String codCa, String nombresCa, String apellidosCa, String sexoCa, String generoCa, Date fechaNacCa, String estadoCivilCa, String nacionalidadCa, Serializable fotografiaCa) {
        this.idCoorAca = idCoorAca;
        this.codCa = codCa;
        this.nombresCa = nombresCa;
        this.apellidosCa = apellidosCa;
        this.sexoCa = sexoCa;
        this.generoCa = generoCa;
        this.fechaNacCa = fechaNacCa;
        this.estadoCivilCa = estadoCivilCa;
        this.nacionalidadCa = nacionalidadCa;
        this.fotografiaCa = fotografiaCa;
    }

    public Long getIdCoorAca() {
        return idCoorAca;
    }

    public void setIdCoorAca(Long idCoorAca) {
        this.idCoorAca = idCoorAca;
    }

    public String getCodCa() {
        return codCa;
    }

    public void setCodCa(String codCa) {
        this.codCa = codCa;
    }

    public String getNombresCa() {
        return nombresCa;
    }

    public void setNombresCa(String nombresCa) {
        this.nombresCa = nombresCa;
    }

    public String getApellidosCa() {
        return apellidosCa;
    }

    public void setApellidosCa(String apellidosCa) {
        this.apellidosCa = apellidosCa;
    }

    public String getSexoCa() {
        return sexoCa;
    }

    public void setSexoCa(String sexoCa) {
        this.sexoCa = sexoCa;
    }

    public String getGeneroCa() {
        return generoCa;
    }

    public void setGeneroCa(String generoCa) {
        this.generoCa = generoCa;
    }

    public Date getFechaNacCa() {
        return fechaNacCa;
    }

    public void setFechaNacCa(Date fechaNacCa) {
        this.fechaNacCa = fechaNacCa;
    }

    public String getEstadoCivilCa() {
        return estadoCivilCa;
    }

    public void setEstadoCivilCa(String estadoCivilCa) {
        this.estadoCivilCa = estadoCivilCa;
    }

    public String getNacionalidadCa() {
        return nacionalidadCa;
    }

    public void setNacionalidadCa(String nacionalidadCa) {
        this.nacionalidadCa = nacionalidadCa;
    }

    public Serializable getFotografiaCa() {
        return fotografiaCa;
    }

    public void setFotografiaCa(Serializable fotografiaCa) {
        this.fotografiaCa = fotografiaCa;
    }

    public String getDuiCa() {
        return duiCa;
    }

    public void setDuiCa(String duiCa) {
        this.duiCa = duiCa;
    }

    public String getNitCa() {
        return nitCa;
    }

    public void setNitCa(String nitCa) {
        this.nitCa = nitCa;
    }

    public String getNupCa() {
        return nupCa;
    }

    public void setNupCa(String nupCa) {
        this.nupCa = nupCa;
    }

    public String getPasaporteCa() {
        return pasaporteCa;
    }

    public void setPasaporteCa(String pasaporteCa) {
        this.pasaporteCa = pasaporteCa;
    }

    public String getDocPersonalCa() {
        return docPersonalCa;
    }

    public void setDocPersonalCa(String docPersonalCa) {
        this.docPersonalCa = docPersonalCa;
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

    public Collection<Maestria> getMaestriaCollection() {
        return maestriaCollection;
    }

    public void setMaestriaCollection(Collection<Maestria> maestriaCollection) {
        this.maestriaCollection = maestriaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCoorAca != null ? idCoorAca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoordinadorAcademico_1)) {
            return false;
        }
        CoordinadorAcademico_1 other = (CoordinadorAcademico_1) object;
        if ((this.idCoorAca == null && other.idCoorAca != null) || (this.idCoorAca != null && !this.idCoorAca.equals(other.idCoorAca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gl05.bad.domain.CoordinadorAcademico_1[ idCoorAca=" + idCoorAca + " ]";
    }
    
}