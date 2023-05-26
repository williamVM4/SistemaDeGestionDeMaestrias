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
                <strong><i class="bi bi-check-circle"></i> Éxito!&nbsp;</strong> ${mensaje}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="alert alert-danger d-flex align-items-center alert-dismissible fade show" role="alert">
                <strong><i class="bi bi-exclamation-triangle"></i> Error!&nbsp;</strong> ${error}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <div class="row col-sm-12 d-flex justify-content-end">
            <div class="col-sm-1">
                <button type="button" class="btn-add btn abrirModal-btn" 
                        data-bs-toggle="modal" data-bs-target="#crearModal" 
                        data-action="agregar">Agregar</button>
            </div>
        </div>

          <div class="pt-4">
              <div class="table-responsive-md">
                  <table id="maestriasTable" class="table table-striped" style="width:100%">
                      <thead class="table-light">
                          <tr>
                              <th class="text-center">Código del plan de estudios</th>
                              <th class="text-center">Modalidad</th>
                              <th class="text-center">Estado</th>
                              <th class="text-center">Acciones</th>
                          </tr>
                      </thead>
                      <tbody>
                      </tbody>
                  </table>
              </div>
          </div>
        </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->



</div>
  <!-- /.content-wrapper -->
  

<%@ include file="../common/footer1.jspf"%>
<script src="${pageContext.request.contextPath}/js/planEstudio.js"></script>