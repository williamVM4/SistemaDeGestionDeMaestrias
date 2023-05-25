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
                    <h1>Maestrias</h1>
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
                <strong><i class="bi bi-check-circle"></i> Éxito!&nbsp;</strong> ${mensaje}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="alert alert-danger d-flex align-items-center alert-dismissible fade show" role="alert">
                <strong><i class="bi bi-exclamation-triangle"></i> Error!&nbsp;</strong> ${error}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <div class="row col-sm-12 d-flex justify-content-end">
            <div class="col-sm-1">
                <button type="button" class="btn-add btn abrirModal-btn" 
                        data-bs-toggle="modal" data-bs-target="#crearModal" 
                        data-action="agregar">Agregar</button>
            </div>
        </div>

          <div class="pt-4">
              <div class="table-responsive-md">
                  <table id="maestriasTable" class="table table-striped" style="width:100%">
                      <thead class="table-light">
                          <tr>
                              <th class="text-center">Nombre</th>
                              <th class="text-center">Escuela de Posgrado</th>
                              <th class="text-center">Facultad</th>
                              <th class="text-center">Acciones</th>
                          </tr>
                      </thead>
                      <tbody>
                      </tbody>
                  </table>
              </div>
          </div>
        </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->

    <!-- Modal de agregar y editar -->
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
                        <input type="hidden" id="idMaestria">
                        <div class="form-group">
                            <input type="text" class="form-control" id="nombreMaestria" name="nombreMaestria" placeholder="Nombre de la maestria" required>
                        </div>
                        <div class="form-group">
                              <select class="form-control" id="escuelaPostgrado" name="escuelaPostgrado" required>
                                  <option value="">Seleccione una escuela de postgrado</option>
                                  <c:forEach items="${escuelas}" var="escuela">
                                      <option value="${escuela.idPostgrado}">${escuela.nombrePostgrado}</option>
                                  </c:forEach>
                              </select>
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

</div>
  <!-- /.content-wrapper -->
  
<sec:authorize access="hasAuthority('VER_ADMIN_PRIVILEGE')" var="hasPrivilegeAdmin"></sec:authorize>
<script>
    var hasPrivilegeAdmin = ${hasPrivilegeAdmin};
</script>
<%@ include file="../common/footer1.jspf"%>
    
    <script src="${pageContext.request.contextPath}/js/maestria.js"></script>
    <script>
      $(document).ready(function () {
          $('#formGuardar').submit(function (event) {
              event.preventDefault();//detiene el evento del envio del form 
              var idMaestria = $('#idMaestria').val();//tomo la id

              var formDataArray = $(this).serializeArray();//tomo los datos del array

              var url;//valido el tipo de url si editar o crear
              if (idMaestria) {
                  url = '/ActualizarMaestria';
                  //meto la id en el campo de envio
                  formDataArray.push({name: 'idMaestria', value: idMaestria});
              } else {
                  url = '/AgregarMaestria';
              }
              // Convertir el arreglo en un objeto
              var formData = {};
              $.map(formDataArray, function (n, i) {
                  formData[n['name']] = n['value'];
              });
              //realizo el guardado mediante ajax
              $.ajax({
                  url: url,
                  type: 'POST',
                  data: formData,
                  success: function (response) {
                      $('#crearModal').modal('hide');  // Cierra el modal
                      location.reload();  // Recarga la página
                  },
                  error: function (error) {
                      console.log(error);
                  }
              });
          });
          // metodo para mostrar el modal segun sea si editar o nuevo registro
          $(document).on('click', '.abrirModal-btn', function () {
              var idMaestria = $(this).data('id');
              var modal = $('#crearModal');
              var tituloModal = modal.find('.modal-title');
              var form = modal.find('form');
              var btnSumit = document.getElementById('btnSumit');

              if (idMaestria) {
                  tituloModal.text('Editar Area de Conocimiento');//titulo del modal
                  $.ajax({//utilizo ajax para obtener los datos
                      url: '/ObtenerMaestria/' + idMaestria,
                      type: 'GET',
                      success: function (response) {
                          $('#nombreMaestria').val(response.nombreMaestria);
                          $('#idMaestria').val(idMaestria);
                      },
                      error: function () {
                          alert('Error al obtener los datos de la maestria.');
                      }
                  });
              } else {
                  // en caso de presionar el boton de nuevo solo se abrira el modal
                  tituloModal.text('Agregar Maestria');
                  form.attr('action', '/AgregarMaestria');
                  $('#nombreMaestria').val('');
                  $('#idMaestria').val('');
              }
              modal.modal('show');
          });
      });

    </script>

