<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>
<div align="center">
    <div class="titulo-Perfil"><h3>Gestionar Aspirante a Profesor</h3></div>
    <div id="container-datos">
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
                            <td>Ver coordinador</td>
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
                <form th.action="/AgregarAspiranteProfesor" method="post" accept-charset="UTF-8">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="hidden" name="action" value="create">
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