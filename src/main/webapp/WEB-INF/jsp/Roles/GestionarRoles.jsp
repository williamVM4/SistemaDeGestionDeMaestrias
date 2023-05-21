<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div align="center">
    <div class="titulo-Perfil"><h3>Roles</h3></div>
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
                <button type="button" class="btn btn-outline-primary btn-sm" data-bs-toggle="modal" data-bs-target="#crearModal">Agregar</button>
            </div>
        </div>

        <br>

        <div class="row col-sm-12">
            <table class="table">
                <thead class="table">
                    <tr>
                        <th scope="col">N°</th>
                        <th scope="col">Nombre</th>
                        <th scope="Opciones">Opciones</th>
                    </tr>
                </thead>

                <tbody>
                    <c:if test="${empty Roles}">
                        <tr>
                            <td colspan="5">No hay registros</td>
                        </tr>
                    </c:if>

                    <c:if test="${not empty Roles}">
                        <c:forEach items="${Roles}" var="elemento" varStatus="status">
                            <tr>
                                <td width="20%">${status.index + 1}</td>
                                <td>${elemento.nombre}</td>
                                <td>
                                    <a href="#" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#confirmarEliminar-${elemento.idRol}">
                                        <i class="bi bi-trash"></i>
                                    </a>

                                    <!-- Modal de confirmación de eliminación -->
                                    <div class="modal fade" id="confirmarEliminar-${elemento.idRol}" tabindex="-1" aria-labelledby="confirmarEliminarLabel-${elemento.idRol}" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="confirmarEliminarLabel-${elemento.idRol}">Confirmar eliminación</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <strong>¿Estás seguro de eliminar este rol?</strong>
                                                    <p>Ten en cuenta que se eliminarán los datos relacionados a ${elemento.nombre} .</p>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                                    <a href="/EliminarRol/${elemento.idRol}" class="btn btn-danger">Eliminar</a>
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

        <!-- Modal para roles -->
        <div class="modal fade" id="crearModal" tabindex="-1" aria-labelledby="crearModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="crearModalLabel">Agregar Rol</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="/AgregarRol" method="post" accept-charset="UTF-8">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

                            <div class="form-group">
                                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre" required>
                            </div>

                            <div class="modal-footer">
                                <button type="submit" class="btn btn-outline-success">Guardar</button>
                                <button type="button" class="btn btn-outline-danger" data-bs-dismiss="modal">Cancelar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>

    <%@ include file="../common/footer.jspf"%>