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
                            <h1>Roles</h1>
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
                    <sec:authorize access="hasAuthority('AGREGAR_ROL_PRIVILAGE')"> 
                    <button type="button" class="btn-add btn abrirModal-btn" 
                            data-bs-toggle="modal" data-bs-target="#crearModal" 
                            data-action="agregar">Agregar
                    </button>
                    </sec:authorize>
                </div>
            </div>

            <div class="pt-4">
                <div class="table-responsive-md">
                    <table id="rolesTable" class="table table-striped" style="width:100%">
                        <thead class="table-light">
                            <tr>
                                <th class="text-center">Nombre</th>
                                <th class="text-center">Permisos</th>
                                <th class="text-center">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>
            
<!-- Modal para roles -->
<div class="modal fade" id="crearModal" tabindex="-1" aria-labelledby="crearModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="crearModalLabel">Agregar Rol</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id='formGuardar' accept-charset="UTF-8">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="hidden" id="rolId">
                    <div class="form-group">
                        <label for="nombre" class="form-label">Nombre de rol: </label>
                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre" required>
                    </div>

                    <div id="permisos-error" class="error-message"></div>
                    <div class="form-group">
                        <label for="permisos" class="form-label">Permisos: </label>
                        <c:forEach items="${Permisos}" var="elementoPermiso" varStatus="status">
                            <div>
                                <li>
                                    <input class="checkClean" type="checkbox" id="permiso${elementoPermiso.idPermiso}" name="permisos[]" value="${elementoPermiso.idPermiso}">
                                    <label for="permiso${elementoPermiso.idPermiso}">${elementoPermiso.nombre}</label>
                                </li>
                            </div>
                        </c:forEach>
                    </div>

                    <div class="modal-footer">
                        <button id='btnSumit' type="submit" class="btn btn-outline-success">Guardar</button>
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
                    <strong>�Est�s seguro de eliminar al rol seleccionado?</strong>
                    <p>Ten en cuenta que se eliminar�n los datos relacionados al rol <span id="nombre"></span>.</p>
                    
                </div>
                <div class="modal-footer">
                  <button id="eliminarRolBtn" class="btn btn-danger">Eliminar</button>
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                </div>
            </div>
        </div>
    </div>
    
    <form id="eliminarRolForm" method="post" action="/EliminarRol/{idRol}">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    </form>                 

<sec:authorize access="hasAuthority('EDITAR_ROL_PRIVILAGE')" var="hasPrivilegeEditarRol"></sec:authorize>
<script>
    var hasPrivilegeEditarRol = ${hasPrivilegeEditarRol};
</script>

<sec:authorize access="hasAuthority('ELIMINAR_ROL_PRIVILAGE')" var="hasPrivilegeEliminarRol"></sec:authorize>
<script>
    var hasPrivilegeEliminarRol = ${hasPrivilegeEliminarRol};
</script>    

<%@ include file="../common/footer1.jspf"%>

<script src="${pageContext.request.contextPath}/js/roles.js"></script>