<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div align="center">
  <div class="titulo-Perfil"><h3>Coordinadores Académicos</h3></div>
  <div id="container-datos">
    <div class="row">
      <div class="col-sm-10 ">
        <div class="row">
          <div id="view-coordinadores">
            <div class="row col-sm-12 d-flex justify-content-end">
              <div class="col-sm-1">
                  <button type="button" class="btn-add btn" data-bs-toggle="modal" data-bs-target="#crearModal">Agregar</button>
              </div>
            </div>
            <br>
            <div class="row col-sm-12">
              <table style="width:100%; " class="table table-bordered table-striped small">
              <thead>
                <tr>
                  <th>No</th>
                  <th>Número de identificación</th>
                  <th>Nombres</th>
                  <th>Apellidos</th>
                  <th>Opciones</th>
                </tr>
              </thead>
              <tbody>
                <c:if test="${empty coordinadoresAC}">
                    <tr>
                        <td colspan="5">No hay registros</td>
                    </tr>
                </c:if>
                <c:if test="${not empty coordinadoresAC}">
                    <c:forEach items="${coordinadoresAC}" var="elemento" varStatus="status">
                        <tr>
                            <td width="20%">${status.index + 1}</td>
                            <td>${elemento.codCa}</td>
                            <td>${elemento.nombresCa}</td>
                            <td>${elemento.apellidosCa}</td>
                            <td>Ver coordinador</td>
                        </tr>
                    </c:forEach>
                </c:if>
              </tbody>
            </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
    <!-- Modal para crear coordinadores -->
   <div class="modal fade" id="crearModal" tabindex="-1" aria-labelledby="crearModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="crearModalLabel">Agregar Coordinador Académico</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <form action="/guardarCA" method="POST" accept-charset="UTF-8">
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
              <div class="form-group">
                <label for="codCa">Carnet de identificación:</label>
                <input type="text" class="form-control" id="codCa" name="codCa" maxlength="6" required>
              </div>
              <div class="form-group">
                <label for="nombresCa">Nombre:</label>
                <input type="text" class="form-control" id="nombresCa" name="nombresCa" required>
              </div>
              <div class="form-group">
                <label for="apellidosCa">Apellido:</label>
                <input type="text" class="form-control" id="apellidosCa" name="apellidosCa" required>
              </div>
              <div class="modal-footer">
                <button type="submit" class="btn btn-outline-success">Guardar</button>
                <button type="submit" class="btn btn-outline-danger" data-bs-dismiss="modal">Cancelar</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
<%@ include file="../common/footer.jspf"%>





