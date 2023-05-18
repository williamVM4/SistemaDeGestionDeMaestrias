<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
  <div style="clear:both; padding-bottom:15px;"></div>
  <div align="center">
    <div class="titulo-Perfil"><h3>Perfil del Coordinador Académico</h3></div>
    <div id="container-datos">
      <div class="row">
        <div class="col-sm-2 ">
          <div class="row">
              <div class="col-sm-12" style="text-align: center;">
                  <img style="width:128px;cursor:pointer;" src="/images/foto.jpg" id="nofoto" title="Click para subir foto" onerror="">
              </div>
          </div>
          <br>
          <div class="row">
            <div class="col-sm-12 ">
              <div class="list-group info ">
                  <button class="tab-perfil list-group-item list-group-item-info btn-info" id="tab_generales" title="Datos generales" type="button">
                      Información general
                  </button>
                  <button class="tab-perfil list-group-item list-group-item-info btn-info" id="tab_educacion" title="Educación" type="button">
                      Educación
                  </button>
                  <button class="tab-perfil list-group-item list-group-item-info btn-info" id="tab_fotografías" title="Documentos" type="button">
                      Documentos
                  </button>
                  <button class="tab-perfil list-group-item list-group-item-info btn-info" id="tab_telefonos" title="Teléfonos" type="button">
                      Teléfonos
                  </button>
                  <button class="tab-perfil list-group-item list-group-item-info btn-info" id="tab_correos" title="Correos" type="button">
                      Correos
                  </button>
              </div>
            </div>
          </div>
        </div>
        <div class="col-sm-10">
            <div class="row">
                <div class="col-sm-12">
                  <div id="contenido-perfil" class="contenido">
                    <div id="perfil-informacion-general">
                      <div class="subtitulo-Perfil"><h3>Información general
                              <span title="Editar datos" onclick="" class="text-info puntero pull-right">
                                  <i class="fa bi-pencil-square"></i>
                              </span>
                          </h3>
                      </div>
                      <table style="width:100%; " class="table table-bordered table-striped small">
                          <tbody>
                              <tr>
                                  <td width="20%">Apellidos</td>
                                  <td>Pineda Delgado</td>
                              </tr>
                              <tr>
                                  <td>Estado Laboral</td>
                                  <td>Estudiante</td>
                              </tr>
                              <tr>
                                  <td>Estado Laboral</td>
                                  <td>Estudiante</td>
                              </tr>
                          </tbody>
                      </table>
                    </div>
                  </div>
                </div>
            </div>
        </div>
      </div>
    </div>
  </div>
</div>
<%@ include file="../common/footer.jspf"%>
