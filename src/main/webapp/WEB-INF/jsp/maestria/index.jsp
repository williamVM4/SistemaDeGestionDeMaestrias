<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>
 <div align="center">
    <div class="titulo-Perfil"><h3>Maestrías</h3></div>
    <div id="container-datos">

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
        <br>
        <div class="row">
            <div class="col-md-12 pt-4">
                <div class="table-responsive">
                    <table id="maestriasTable" class="table table-bordered dt-responsive nowrap">
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
    </div>
</div>
<sec:authorize access="hasAuthority('VER_ADMIN_PRIVILEGE')" var="hasPrivilegeAdmin"></sec:authorize>
<script>
    var hasPrivilegeAdmin = ${hasPrivilegeAdmin};
</script>
<%@ include file="../common/footer.jspf"%>