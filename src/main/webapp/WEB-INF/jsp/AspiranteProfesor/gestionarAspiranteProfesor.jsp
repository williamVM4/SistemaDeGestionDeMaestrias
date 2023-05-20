<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>
<div align="center">
    <div class="titulo-Perfil"><h3>Gestionar Aspirante a Profesor</h3></div>
    <div id="container-datos">
        <c:if test="${not empty mensaje}">
            <div class="alert alert-success d-flex align-items-center alert-dismissible fade show" role="alert">
                <strong><i class="bi bi-check-circle"></i> Éxito!  </strong>${mensaje}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="alert alert-danger d-flex align-items-center alert-dismissible fade show" role="alert">
                <strong><i class="bi bi-exclamation-triangle"></i> Error!  </strong>${error}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
          <br>
        <div class="row col-sm-12 d-flex justify-content-end">
            <div class="col-sm-1">
                <button type="button" class="btn btn-outline-primary btn-sm" data-bs-toggle="modal" data-bs-target="#crearModal">Agregar</button>
            </div>
        </div>
        <br>
        <div class="row col-sm-12">
            <table class="table">
                <thead class="table">
                    <tr>
                        <th scope="col">N°</th>
                        <th scope="col">Carné</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col">Opciones</th>
                    </tr>
                </thead>
                <tbody>
                <c:if test="${empty aspirantesAP}">
                    <tr>
                        <td colspan="5">No hay registros</td>
                    </tr>
                </c:if>
                <c:if test="${not empty aspirantesAP}">
                    <c:forEach items="${aspirantesAP}" var="elemento" varStatus="status">
                        <tr>
                            <td width="20%">${status.index + 1}</td>
                            <td>${elemento.codAp}</td>
                            <td>${elemento.nombresAp}</td>
                            <td>${elemento.apellidosAp}</td>
                            <td>
                                <a type="button" class="btn btn-outline-secondary" href="/PerfilAspiranteProfesor/${elemento.idAspiranteProfesor}"><i class="bi bi-eye"></i></a>
                                <a href="#" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#confirmarEliminar-${elemento.idAspiranteProfesor}">
                                    <i class="bi bi-trash"></i>
                                </a>
                                <!-- Modal de confirmación de eliminación -->
                                <div class="modal fade" id="confirmarEliminar-${elemento.idAspiranteProfesor}" tabindex="-1" aria-labelledby="confirmarEliminarLabel-${elemento.idAspiranteProfesor}" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="confirmarEliminarLabel-${elemento.idAspiranteProfesor}">Confirmar eliminación</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                <strong>¿Estás seguro de eliminar este aspirante?</strong>
                                                <p>Ten en cuenta que se eliminarán los datos relacionados a ${elemento.nombresAp} ${elemento.apellidosAp}.</p>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                                <a href="/EliminarAspiranteProfesor/${elemento.idAspiranteProfesor}" class="btn btn-danger">Eliminar</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- Modal para crear aspirantes -->
<div class="modal fade" id="crearModal" tabindex="-1" aria-labelledby="crearModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="crearModalLabel">Agregar Aspirante a Profesor</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="/AgregarAspiranteProfesor" method="post" accept-charset="UTF-8">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <div class="form-group">
                      <input type="text" class="form-control" id="codAp" name="codAp" maxlength="6" placeholder="Carné" required>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="nombresAp" name="nombresAp" placeholder="Nombre" required>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="apellidosAp" name="apellidosAp" placeholder="Apellido" required>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-outline-success">Guardar</button>
                        <button type="button" class="btn btn-outline-danger" data-bs-dismiss="modal">Cancelar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
<%@ include file="../common/footer.jspf"%>