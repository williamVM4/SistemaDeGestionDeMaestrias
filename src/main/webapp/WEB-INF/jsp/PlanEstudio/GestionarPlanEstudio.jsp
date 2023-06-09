<%@ include file="../common/header1.jspf"%>
<%@ include file="../common/navigation1.jspf"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row">
          <div class="col-sm-12">
            <div class="titulo-Perfil">
                <div class="container">
                    <h1>Planes de estudio</h1>
                </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Main content -->
    <section class="content pb-5">
        <div class="container">
            <c:if test="${not empty mensaje}">
              <div class="alert alert-success d-flex align-items-center alert-dismissible fade show" role="alert">
                <strong><i class="bi bi-check-circle"></i> �xito!</strong> ${mensaje}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
              </div>
            </c:if>
            <c:if test="${not empty error}">
              <div class="alert alert-danger d-flex align-items-center alert-dismissible fade show" role="alert">
                <strong><i class="bi bi-exclamation-triangle"></i> Error!</strong> ${error}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
              </div>
            </c:if>
          
            <div class="alert alert-success d-flex align-items-center alert-dismissible fade d-none" role="alert">
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                <strong><i class="bi bi-check-circle"></i> �xito!&nbsp;</strong>
            </div>
            <div class="alert alert-danger d-flex align-items-center alert-dismissible fade d-none" role="alert">
                <strong><i class="bi bi-exclamation-triangle"></i> Error!&nbsp;</strong>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <div class="row col-sm-12 d-flex justify-content-end">
                <div class="col-sm-1">
                    <sec:authorize access="hasAuthority('AGREGAR_PLANES_ESTUDIO_PRIVILAGE')">
                    <button type="button" class="btn-add btn abrirModal-btn" 
                            data-bs-toggle="modal" data-bs-target="#crearModal" 
                            data-action="agregar">Agregar
                    </button>
                    </sec:authorize>
                </div>
            </div>

            <div class="pt-4">
              <div class="table-responsive-md">
                  <table id="planEstudioTable" class="table table-striped" style="width:100%">
                      <thead class="table-light">
                          <tr>
                              <th class="text-center">C�digo del plan de estudios</th>
                              <th class="text-center">A�o</th>
                              <th class="text-center">Estado</th>
                              <th class="text-center">Acciones</th>
                          </tr>
                      </thead>
                      <tbody class="text-center">
                      </tbody>
                  </table>
              </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>
    <!-- /.Main content -->
    
    <!-- Modal de agregar y editar -->
    <div class="modal fade" id="crearModal" tabindex="-1" aria-labelledby="crearModalLabel" aria-hidden="true" data-tipo="" data-modo=''>
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="crearModalLabel"></h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id='formGuardar' accept-charset="UTF-8">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        <input type="hidden" id="idPlanEstudio">
                        <input type="hidden" id="idMaestria">
                        <div class="form-group">
                            <label for="codPlan" class="form-label">C�digo del plan de estudio</label>
                            <input type="text" class="form-control" id="codPlan" name="codPlan" required>
                        </div>
                        <div class="form-group">
                            <label for="modalidad" class="form-label">Modalidad</label>
                            <select class="form-select" id="modalidad" name="modalidad" required>
                              <option value="">Seleccionar Modalidad</option>
                              <option value="Presencial">Presencial</option>
                              <option value="Semipresencial">Semipresencial</option>
                              <option value="En l�nea">En l�nea</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="cumMinimo" class="form-label">CUM M�nimo</label>
                            <input type="number" class="form-control" id="cumMinimo" name="cumMinimo" min="0" max="10" step="any" required>
                        </div>
                        <div class="form-group">
                            <label for="notaMinimaAprobacion" class="form-label">Nota M�nima de Aprobaci�n</label>
                            <input type="number" class="form-control" id="notaMinimaAprobacion" name="notaMinimaAprobacion" min="0" max="10" step="any" required>
                        </div>
                        <div class="form-group">
                            <label for="totalAsignaturas" class="form-label">Total de Asignaturas</label>
                            <input type="number" class="form-control" id="totalAsignaturas" name="totalAsignaturas" min="0" max="999" step="1" required>
                        </div>
                        <div class="form-group">
                            <label for="totalUv" class="form-label">Total de UV</label>
                            <input type="number" class="form-control" id="totalUv" name="totalUv" min="0" max="999" step="1" required>
                        </div>
                        <div class="form-group">
                            <label for="duracionCarrera" class="form-label">Duraci�n de la Carrera en a�os</label>
                            <input type="number" class="form-control" id="duracionCarrera" name="duracionCarrera" min="0" max="999" step="1" required>
                        </div>
                        <div class="form-group">
                            <label for="tituloOrtorgar" class="form-label">T�tulo a Otorgar</label>
                            <input type="text" class="form-control" id="tituloOrtorgar" name="tituloOrtorgar" required>
                        </div>
                        <div class="form-group">
                            <label for="anio" class="form-label">A�o</label>
                            <input type="number" class="form-control" id="anio" name="anio" min="0" required>
                        </div>
                        <div class="modal-footer">
                            <button id='btnSumit' type="submit" class="btn btn-outline-success guardar-btn">Guardar</button>
                            <button type="button" class="btn btn-outline-danger" data-bs-dismiss="modal">Cancelar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
                        
    <!-- Modal de eliminar -->
    <div class="modal fade" id="confirmarEliminarModal" tabindex="-1" aria-labelledby="confirmarEliminarLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmarEliminarLabel">Confirmar eliminaci�n</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <strong>�Est�s seguro de eliminar el plan de estudio seleccionado?</strong>
                    <p>Ten en cuenta que se eliminar�n los datos relacionados a la plan de estudio de c�digo <span id="codPlanEliminar"></span>.</p>
                    
                </div>
                <div class="modal-footer">
                  <button id="eliminarPlanEstudioBtn" class="btn btn-danger">Eliminar</button>
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                </div>
            </div>
        </div>
    </div>
    
    <form id="eliminarPlanEstudioForm" method="post" action="/EliminarPlanEstudio/{idPlanEstudio}">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    </form>
    <!-- /.Modal de eliminar -->

</div>
  <!-- /.content-wrapper -->

<sec:authorize access="hasAuthority('GESTIONAR_PLANES_ESTUDIO_PRIVILAGE')" var="hasPrivilegeAccederPlan"></sec:authorize>
<sec:authorize access="hasAuthority('EDITAR_PLANES_ESTUDIO_PRIVILAGE')" var="hasPrivilegeEditarPlan"></sec:authorize>
<sec:authorize access="hasAuthority('ELIMINAR_PLANES_ESTUDIO_PRIVILAGE')" var="hasPrivilegeEliminarPlan"></sec:authorize>
<script>
    var idMaestria = "${idMaestria}";
    var hasPrivilegeAccederPlan = ${hasPrivilegeAccederPlan};
    var hasPrivilegeEditarPlan = ${hasPrivilegeEditarPlan};
    var hasPrivilegeEliminarPlan = ${hasPrivilegeEliminarPlan};
</script>
<%@ include file="../common/footer1.jspf"%>
<script src="${pageContext.request.contextPath}/js/planEstudio.js"></script>