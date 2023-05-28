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
                    <h1>Cohortes</h1>
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
                  <table id="cohorteTable" class="table table-striped" style="width:100%">
                      <thead class="table-light">
                          <tr>
                              <th class="text-center">Nombre Cohorte</th>
                              <th class="text-center">Fecha apertura</th>
                              <th class="text-center">Estado Cohorte</th>
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
    
    <!-- /.Modal de eliminar -->

</div>
  <!-- /.content-wrapper -->
  
<script>
    var idMaestria = "${idMaestria}";
</script>
<%@ include file="../common/footer1.jspf"%>
<script src="${pageContext.request.contextPath}/js/cohorte.js"></script>