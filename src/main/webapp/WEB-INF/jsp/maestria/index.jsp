<%@ include file="../common/header1.jspf"%>
<%@ include file="../common/navigation1.jspf"%>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-12">
            <div class="titulo-Perfil"><h3>Maestrias</h3></div>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
    
    <!-- Main content -->
    <section class="content">
        <div class="container">
        <c:if test="${not empty mensaje}">
            <div class="alert alert-success d-flex align-items-center alert-dismissible fade show" role="alert">
                <strong><i class="bi bi-check-circle"></i> Éxito!  </strong> ${mensaje}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="alert alert-danger d-flex align-items-center alert-dismissible fade show" role="alert">
                <strong><i class="bi bi-exclamation-triangle"></i> Error!  </strong> ${error}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <br>
        <div class="row col-sm-12 d-flex justify-content-end">
            <div class="col-sm-1">
                <button type="button" class="btn-add btn abrirModal-btn" 
                        data-bs-toggle="modal" data-bs-target="#crearModal" 
                        data-action="agregar">Agregar</button>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12 pt-4">
                <div class="table-responsive">
                    <table id="maestriasTable" class="table table-bordered dtr-inline w-100 my-3">
                        <thead class="thead-light">
                            <tr>
                                <th class="text-center">Nombre</th>
                                <th class="text-center">Escuela de Posgrado</th>
                                <th class="text-center">Facultad</th>
                                <th class="text-center">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  
 
<sec:authorize access="hasAuthority('VER_ADMIN_PRIVILEGE')" var="hasPrivilegeAdmin"></sec:authorize>
<script>
    var hasPrivilegeAdmin = ${hasPrivilegeAdmin};
</script>
<%@ include file="../common/footer1.jspf"%>