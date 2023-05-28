<%@ include file="../common/header1.jspf"%>
<%@ include file="../common/navigation1.jspf"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-12">
          <div class="titulo-Perfil"><h1>${maestria.nombreMaestria}</h1></div>
        </div>
      </div>
    </div><!-- /.container-fluid -->
  </section>

  <!-- Main content -->
  <section class="content">
      <div class="container">
            <c:if test="${maestria.idCoorAca == null}">
                <div id="infoCoordinador" class="alert alert-info d-flex align-items-center alert-dismissible fade show" role="alert">
                        <i class="bi bi-info-circle"></i> &nbsp; La maestría aún no tiene un coordinador académico asociado. Por favor, agregue uno.
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>
            <c:if test="${maestria.perfilAsp == null}">
                <div id="infoPerfilA" class="alert alert-info d-flex align-items-center alert-dismissible fade show" role="alert">
                        <i class="bi bi-info-circle"></i> &nbsp; La maestría aún no tiene un perfil de aspirante. Por favor, agregue uno.
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>
            <c:if test="${maestria.perfilCoor == null}">
                <div id="infoPerfilC" class="alert alert-info d-flex align-items-center alert-dismissible fade show" role="alert">
                        <i class="bi bi-info-circle"></i> &nbsp; La maestría aún no tiene un perfil de coordinador. Por favor, agregue uno.
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>
            <div class="alert alert-success d-flex align-items-center alert-dismissible fade d-none" role="alert">
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                <strong><i class="bi bi-check-circle"></i> Éxito!&nbsp;</strong>
            </div>
            <div class="alert alert-danger d-flex align-items-center alert-dismissible fade d-none" role="alert">
                <strong><i class="bi bi-exclamation-triangle"></i> Error!&nbsp;</strong>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
          <div class="row">
              <div class="col-md-12">
                  <div class="card m-3">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-6">
                                    <p class="my-3"><strong>Escuela de Posgrado:</strong>&nbsp;${maestria.idPostgrado.nombrePostgrado}</p>
                                </div>
                                <div class="col-md-6">
                                    <p class="my-3"><strong>Facultad:</strong>&nbsp;${maestria.idPostgrado.idFacultad.nombreFacultad}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <c:if test="${maestria.idCoorAca != null}">
                                        <p class="my-3"><strong>Coordinador Académico:</strong>&nbsp;${maestria.idCoorAca.nombresCa}&nbsp;${maestria.idCoorAca.apellidosCa}</p>
                                    </c:if>
                                    <c:if test="${maestria.idCoorAca == null}">
                                        <p class="my-3"><strong>Coordinador Académico:</strong>&nbsp;No se ha seleccionado un coordinador.</p>
                                    </c:if>
                                </div>
                                <div class="col-md-6">
                                    <c:if test="${maestria.idCoorAca != null}">
                                        <p class="my-3"><strong>Plan de estudio vigente:</strong>&nbsp;</p>
                                    </c:if>
                                    <c:if test="${maestria.idCoorAca == null}">
                                        <p class="my-3"><strong>Plan de estudio vigente:</strong>&nbsp;No tiene un plan de estudio vigente.</p>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                  </div>
              </div>
          </div>
          <div class="row">
              <div class="col-md-6">
                    <div class="card m-3">
                        <div class="card-header d-flex justify-content-between align-items-center">
                            <h5 class="mb-0">Perfil del Coordinador</h5>
                            <div>
                                <c:if test="${maestria.perfilCoor == null || maestria.perfilCoor == ''}">
                                <button class="btn btn-outline-primary abrirModal-perfilC"><i class="fas fa-plus"></i></button>
                                </c:if>
                                <c:if test="${maestria.perfilCoor != null && maestria.perfilCoor != ''}">
                                <button class="btn btn-outline-warning abrirModal-perfilC" data-tipo="editar" data-id="${maestria.idMaestria}"><i class="bi bi-pencil-square"></i></button>
                                </c:if> 
                                <c:if test="${maestria.perfilCoor != null && maestria.perfilCoor != ''}">
                                <button class="btn btn-outline-danger abrirModal-perfilC" data-tipo="eliminar" data-id="${maestria.idMaestria}"><i class="bi bi-trash"></i></button>
                                </c:if> 
                            </div>
                        </div>
                        <div class="card-body">
                            <p><pre><c:out value="${maestria.perfilCoor}" /></pre></p>
                        </div>
                    </div>
              </div>
              <div class="col-md-6">
                    <div class="card m-3">
                        <div class="card-header d-flex justify-content-between align-items-center">
                            <h5 class="mb-0">Perfil del Aspirante</h5>
                            <div>
                                <button class="btn btn-outline-primary"><i class="fas fa-plus"></i></button>
                                <button class="btn btn-outline-warning"><i class="bi bi-pencil-square"></i></button>
                                <button class="btn btn-outline-danger"><i class="bi bi-trash"></i></button>
                            </div>
                        </div>
                        <div class="card-body">
                            <!-- Contenido del perfil del aspirante -->
                        </div>
                    </div>
              </div>
          </div>
          <div class="row">
              <div class="col-md-6">
                    <div class="card m-3">
                        <div class="card-header d-flex justify-content-between align-items-center">
                            <h5 class="mb-0">Coordinador Académico</h5>
                            <div>
                                <button class="btn btn-outline-primary"><i class="fas fa-plus"></i></button>
                                <button class="btn btn-outline-warning"><i class="bi bi-pencil-square"></i></button>
                                <button class="btn btn-outline-danger"><i class="bi bi-trash"></i></button>
                            </div>
                        </div>
                        <div class="card-body">
                            <!-- Contenido del perfil del aspirante -->
                        </div>
                    </div>
              </div>
              <div class="col-md-6">
                    <div class="card m-3">
                        <div class="card-header d-flex justify-content-between align-items-center">
                            <h5 class="mb-0">Plan de Estudio</h5>
                            <div>
                                <button class="btn btn-outline-primary"><i class="fas fa-plus"></i></button>
                                <button class="btn btn-outline-warning"><i class="bi bi-pencil-square"></i></button>
                                <button class="btn btn-outline-danger"><i class="bi bi-trash"></i></button>
                            </div>
                        </div>
                        <div class="card-body">
                            <!-- Contenido del perfil del aspirante -->
                        </div>
                    </div>
              </div>
          </div>
      </div><!-- /.container-fluid -->
  </section>
  <!-- /.content -->
  
    <!-- Modal de agregar, editar y eliminar -->
<div class="modal fade" id="crearModalPerfilCoordinador" tabindex="-1" aria-labelledby="crearModalLabel" aria-hidden="true" data-tipo="" data-modo=''>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="crearModalLabel"></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form id="formGuardarPerfilC" accept-charset="UTF-8">
                <div class="modal-body">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="hidden" id="idMaestria">
                    <div id="perfilCoorGroup" class="form-group">
                        <label for="perfilCoor" class="form-label">Perfil y Responsabilidades del Coordinador</label>
                        <textarea class="form-control" id="perfilCoor" name="perfilCoor" style="height: 200px; width: 100%;" required></textarea>
                    </div>
                    <div class="eliminar-confirmacion d-none">
                        ¿Estás seguro de que deseas eliminar el perfil del coordinador?
                    </div>
                </div>
                <div class="modal-footer">
                    <button id="btnSumitPerfilCoordinador" type="submit" class="btn btn-outline-success guardar-btn">Guardar</button>
                    <button type="button" class="btn btn-outline-danger" data-bs-dismiss="modal">Cancelar</button>
                </div>
            </form>
        </div>
    </div>
</div>

</div>
  <!-- /.content-wrapper -->
  
<script>
    var idMaestria = ${maestria.idMaestria};
</script>
<%@ include file="../common/footer1.jspf"%>
<script src="${pageContext.request.contextPath}/js/detalleMaestria.js"></script>
