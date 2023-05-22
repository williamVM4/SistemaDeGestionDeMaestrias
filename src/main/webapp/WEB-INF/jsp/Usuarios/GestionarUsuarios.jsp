<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>


<div class="titulo-Perfil"><h3>Usuarios</h3></div>
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
                    <th scope="col">Nombre de Usuario</th>
                    <th scope="col">Correo</th>
                    <th scope="col">Habilitado</th>
                    <th scope="col">Bloqueado</th>
                    <th scope="Opciones">Opciones</th>
                </tr>
            </thead>

            <tbody>
                <c:if test="${empty usuarios}">
                    <tr>
                        <td colspan="5">No hay registros</td>
                    </tr>
                </c:if>

                <c:if test="${not empty usuarios}">
                    <c:forEach items="${usuarios}" var="elemento" varStatus="status">
                        <tr>
                            <td width="20%">${status.index + 1}</td>
                            <td>${elemento.username}</td>
                            <td>${elemento.email}</td>
                            <td>${elemento.enabled}</td>
                            <td>${elemento.usuarioBloqueado}</td>
                            <td>
                                
                                <a href="#" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#confirmarEliminar-${elemento.idUsuario}">
                                    <i class="bi bi-trash"></i>
                                </a>
                                    
                                  <!-- Modal de confirmación de eliminación -->
                                    <div class="modal fade" id="confirmarEliminar-${elemento.idUsuario}" tabindex="-1" aria-labelledby="confirmarEliminarLabel-${elemento.idUsuario}" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="confirmarEliminarLabel-${elemento.idUsuario}">Confirmar eliminación</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <strong>¿Estás seguro de eliminar este usuario?</strong>
                                                    <p>Ten en cuenta que se eliminarán los datos relacionados a ${elemento.username} .</p>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                                    <a href="/EliminarUsuario/${elemento.idUsuario}" class="btn btn-danger">Eliminar</a>
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
    
            <!-- Modal para Usuarios -->
        <div class="modal fade" id="crearModal" tabindex="-1" aria-labelledby="crearModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                            <h5 class="modal-title" id="crearModalLabel">Agregar Usuario</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="/AgregarUsuario" method="post" accept-charset="UTF-8">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            
                            <div class="form-group">
                                <input type="text" class="form-control" id="username" name="username" placeholder="Nombre de Usuario" required>
                            </div>
                            
                             <div class="form-group">
                                <input type="text" class="form-control" id="email" name="email" placeholder="Correo" required>
                            </div>
                            
                            <div class="form-group">
                                <input type="text" class="form-control" id="password" name="password" placeholder="Contraseña" required>
                            </div>
                            
                            <input type="hidden" name="numerointentos" value="0">
                            <input type="hidden" name="enabled" value="1">
                            <input type="hidden" name="usuarioBloqueado" value="0">
                            

                            <div class="form-group">
                                <c:forEach items="${roles}" var="elementoRol" varStatus="status">
                                    <div>
                                        <li>
                                            <input type="checkbox" id="${elementoRol.idRol}" name="roles" value="${elementoRol.idRol}">
                                            <label for="${elementoRol.idRol}">${elementoRol.nombre}</label>
                                        </li>
                                    </div>
                                </c:forEach>
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