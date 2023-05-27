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
            <div class="alert alert-success d-flex align-items-center alert-dismissible fade d-none" role="alert">
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                <strong><i class="bi bi-check-circle"></i> Éxito!&nbsp;</strong>
            </div>
            <div class="alert alert-danger d-flex align-items-center alert-dismissible fade d-none" role="alert">
                <strong><i class="bi bi-exclamation-triangle"></i> Error!&nbsp;</strong>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <div class="row col-sm-12 d-flex justify-content-end">
                <div class="col-sm-1">
                    <button type="button" class="btn-add btn abrirModal-btn" 
                            data-bs-toggle="modal" data-bs-target="#crearModal" 
                            data-action="agregar">Agregar
                    </button>
                </div>
            </div>

            <div class="pt-4">
              <div class="table-responsive-md">
                  <table id="planEstudioTable" class="table table-striped" style="width:100%">
                      <thead class="table-light">
                          <tr>
                              <th class="text-center">Código del plan de estudios</th>
                              <th class="text-center">Año</th>
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
                            <input type="text" class="form-control" id="codPlan" name="codPlan" placeholder="Código del plan de estudio" required>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="modalidad" name="modalidad" placeholder="Modalidad" required>
                        </div>
                        <div class="form-group">
                            <input type="number" class="form-control" id="cumMinimo" name="cumMinimo" placeholder="CUM Mínimo" min="0" max="10" required>
                        </div>
                        <div class="form-group">
                            <input type="number" class="form-control" id="notaMinimaAprobacion" name="notaMinimaAprobacion" placeholder="Nota Mínima de Aprobación" min="0" max="10" required>
                        </div>
                        <div class="form-group">
                            <input type="number" class="form-control" id="totalAsignaturas" name="totalAsignaturas" placeholder="Total de Asignaturas" required>
                        </div>
                        <div class="form-group">
                            <input type="number" class="form-control" id="totalUv" name="totalUv" placeholder="Total de UV" required>
                        </div>
                        <div class="form-group">
                            <input type="number" class="form-control" id="duracionCarrera" name="duracionCarrera" placeholder="Duración de la Carrera" required>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="tituloOrtorgar" name="tituloOrtorgar" placeholder="Título a Otorgar" required>
                        </div>
                        <div class="form-group">
                            <input type="number" class="form-control" id="anio" name="anio" placeholder="Año" required>
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
                    <h5 class="modal-title" id="confirmarEliminarLabel">Confirmar eliminación</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <strong>¿Estás seguro de eliminar el plan de estudio seleccionado?</strong>
                    <p>Ten en cuenta que se eliminarán los datos relacionados a la plan de estudio de código <span id="codPlanEliminar"></span>.</p>
                    
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
  
<script>
    var idMaestria = "${idMaestria}";
</script>
<%@ include file="../common/footer1.jspf"%>
<script src="${pageContext.request.contextPath}/js/planEstudio.js"></script>