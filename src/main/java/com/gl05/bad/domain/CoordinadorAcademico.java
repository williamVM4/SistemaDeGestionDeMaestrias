package com.gl05.bad.domain;

public class CoordinadorAcademico {
  private int idUsuario, idPais,idListTelefono,idListDP;
  private String codCA,nombresCA,apellidosCA,sexoCA,generoCA,estadoCivilCA,nacionalidadCA,duiCA,nitCA,nupCA,pasaporteCA,docPersonalCA,fechaNacCA;

  public CoordinadorAcademico(String codCA, String nombresCA, String apellidosCA) {
    this.codCA = codCA;
    this.nombresCA = nombresCA;
    this.apellidosCA = apellidosCA;
  }

  public CoordinadorAcademico() {
  }

  public int getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(int idUsuario) {
    this.idUsuario = idUsuario;
  }

  public int getIdPais() {
    return idPais;
  }

  public void setIdPais(int idPais) {
    this.idPais = idPais;
  }

  public int getIdListTelefono() {
    return idListTelefono;
  }

  public void setIdListTelefono(int idListTelefono) {
    this.idListTelefono = idListTelefono;
  }

  public int getIdListDP() {
    return idListDP;
  }

  public void setIdListDP(int idListDP) {
    this.idListDP = idListDP;
  }

  public String getCodCA() {
    return codCA;
  }

  public void setCodCA(String codCA) {
    this.codCA = codCA;
  }

  public String getNombresCA() {
    return nombresCA;
  }

  public void setNombresCA(String nombresCA) {
    this.nombresCA = nombresCA;
  }

  public String getApellidosCA() {
    return apellidosCA;
  }

  public void setApellidosCA(String apellidosCA) {
    this.apellidosCA = apellidosCA;
  }

  public String getSexoCA() {
    return sexoCA;
  }

  public void setSexoCA(String sexoCA) {
    this.sexoCA = sexoCA;
  }

  public String getGeneroCA() {
    return generoCA;
  }

  public void setGeneroCA(String generoCA) {
    this.generoCA = generoCA;
  }

  public String getEstadoCivilCA() {
    return estadoCivilCA;
  }

  public void setEstadoCivilCA(String estadoCivilCA) {
    this.estadoCivilCA = estadoCivilCA;
  }

  public String getNacionalidadCA() {
    return nacionalidadCA;
  }

  public void setNacionalidadCA(String nacionalidadCA) {
    this.nacionalidadCA = nacionalidadCA;
  }

  public String getDuiCA() {
    return duiCA;
  }

  public void setDuiCA(String duiCA) {
    this.duiCA = duiCA;
  }

  public String getNitCA() {
    return nitCA;
  }

  public void setNitCA(String nitCA) {
    this.nitCA = nitCA;
  }

  public String getNupCA() {
    return nupCA;
  }

  public void setNupCA(String nupCA) {
    this.nupCA = nupCA;
  }

  public String getPasaporteCA() {
    return pasaporteCA;
  }

  public void setPasaporteCA(String pasaporteCA) {
    this.pasaporteCA = pasaporteCA;
  }

  public String getDocPersonalCA() {
    return docPersonalCA;
  }

  public void setDocPersonalCA(String docPersonalCA) {
    this.docPersonalCA = docPersonalCA;
  }

  public String getFechaNacCA() {
    return fechaNacCA;
  }

  public void setFechaNacCA(String fechaNacCA) {
    this.fechaNacCA = fechaNacCA;
  }

  
}
