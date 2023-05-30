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
                            <h1>Facultades</h1>
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
                <strong><i class="bi bi-check-circle"></i> �xito!&nbsp;</strong>
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
                    <table id="facultadTable" class="table table-striped" style="width:100%">
                        <thead class="table-light">
                            <tr>
                                <th class="text-center">Nombre</th>
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
    
    <!-- Modal para facultades -->
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
                    <input type="hidden" id="facultadId">
                    
                    <div class="form-group">
                        <label for="nombreFacultad" class="form-label">Nombre Facultad: </label>
                        <input type="text" class="form-control" id="nombreFacultad" name="nombreFacultad" placeholder="Nombre de la Facultad" required>
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
                    <strong>�Est�s seguro de eliminar la facultad seleccionada?</strong>
                    <p>Ten en cuenta que se eliminar�n los datos relacionados la facultad <span id="nombreFacultad"></span>.</p>
                    
                </div>
                <div class="modal-footer">
                  <button id="eliminarFacultadBtn" class="btn btn-danger">Eliminar</button>
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                </div>
            </div>
        </div>
    </div>
    
    <form id="eliminarFacultadForm" method="post" action="/EliminarFacultad/{idFacultad}">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    </form>                      
    
    


<%@ include file="../common/footer1.jspf"%>
<script src="${pageContext.request.contextPath}/js/facultad.js"></script>