<%@ include file="../common/header1.jspf"%>
<%@ include file="../common/navigation1.jspf"%>


<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12">
                    <div class="titulo-Perfil">
                        <div class="container">
                            <h1>Profesores</h1>
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

            <br>

            <div class="pt-4">
                <div class="table-responsive">
                    <table id="asignaturaTable" class="table table-striped" >
                        <thead class="thead-light">
                            <tr>
                                <th class="text-center">N</th> 
                                <th class="text-center">Nombres</th> 
                                <th class="text-center">Pago Por Hora</th>
                                <th class="text-center">Horas a Impartir</th>
                                <th class="text-center">Total Por Servicios</th>
                                <th class="text-center">Fecha Contratacion</th>
                                <th class="text-center">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${empty profesorCohorte}">
                                <tr>
                                    <td colspan="7">No hay registros</td>
                                </tr>
                            </c:if>
                            <c:if test="${not empty profesorCohorte}">
                                <c:forEach items="${profesorCohorte}" var="elemento" varStatus="status">
                                    <tr>
                                        <td width="20%">${status.index + 1}</td>
                                        <td>${elemento.idAspiranteProfesor.nombresAp}</td>
                                        <td>${elemento.montoPagarHora}</td>
                                        <td>${elemento.unidadHorasImpartir}</td>
                                        <td>${elemento.montoTotalServicios}</td>
                                        <td>${elemento.fechaContratacion}</td>
                                        <td class="text-center">
                                            </button> 
                                            <button type="button" title="Eliminar" class="btn btn-outline-danger eliminarModal-btn" data-id="${elemento.idProfesor}" data-nombre="${elemento.idAspiranteProfesor.nombresAp}" >
                                                <i class="bi bi-trash"></i></button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>
    <!-- Modal de eliminar -->
    <div class="modal fade" id="confirmarEliminarModal" tabindex="-1" aria-labelledby="confirmarEliminarLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmarEliminarLabel">Confirmar eliminación</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="modal-body">

                    </div>
                </div>
                <div class="modal-footer">
                    <button id="eliminarBtn" class="btn btn-danger">Eliminar</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                </div>
            </div>
        </div>
    </div>

    <form id="eliminarForm" method="post" action="/EliminarProfesor/{idprofesor}">
        <input type="hidden" id="idCohorte" name="idCohorte" value="${idCohorte}">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    </form>
</div>
<%@ include file="../common/footer1.jspf"%>
<script src="https://cdn.jsdelivr.net/npm/inputmask/dist/jquery.inputmask.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/js/profesorCohorte.js"></script>

