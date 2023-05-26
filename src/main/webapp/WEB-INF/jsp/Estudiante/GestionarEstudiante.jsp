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
                            <h1>Estudiantes</h1>
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
                    <table id="estudianteTable" class="table table-striped" style="width:100%">
                        <thead class="table-light">
                            <tr>
                                <th class="text-center">Carnet</th>
                                <th class="text-center">Nombre</th>
                                <th class="text-center">Apellidos</th>
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
                        <input type="hidden" id="estudianteId">

                        <div class="form-group">
                            <input type="text" class="form-control" id="carnetE" name="carnetE" placeholder="Carnet" required>
                        </div>

                        <br>

                        <div class="form-group">
                            <input type="text" class="form-control" id="nombresE" name="nombresE" placeholder="Nombres Estudiante" required>
                        </div>

                        <br>

                        <div class="form-group">
                            <input type="text" class="form-control" id="apellidosE" name="apellidosE" placeholder="Apellidos Estudiante" required>
                        </div>

                    <br>

                        <div class="form-group">
                            <label for="sexoE" class="form-label">Sexo:</label>
                            <select type="text" class="form-select" id="sexoE" name="sexoE" required>
                                <option value="">Seleccione una opción</option>
                                <c:forEach items="${sexos}" var="eSexo" varStatus="status">
                                    <option value="${eSexo}">${eSexo}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <br>

                        <div class="form-group">
                            <label for="fechaNacE" class="form-label">Fecha Nacimiento:</label>
                            <input type="text" class="form-control" id="fechaNacE" name="fechaNacE" placeholder="dd-mm-yyyy"/>
                        </div>
                        
                        <br>

                        <div class="form-group">
                            <label for="nacionalidadE" class="form-label">Nacionalidad:</label>
                            <select class="form-select" id="nacionalidadE" name="nacionalidadE" required>
                                <option value="">Seleccione una opción</option>
                                <c:forEach items="${nacionalidades}" var="eNacionalidad">
                                    <option value="${eNacionalidad}">${eNacionalidad}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <br>

                        <div class="form-group">
                            <select class="form-control" id="idPais" name="idPais" required>
                                <option value="">Seleccione un pais</option>
                                <c:forEach items="${pais}" var="elementoPais">
                                    <option value="${elementoPais.idPais}">${elementoPais.nombrePais}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <br>

                        <div class="form-group">
                            <input type="text" class="form-control" id="duiE" name="duiE" placeholder="DUI" required>
                        </div>

                        <br>

                        <div class="form-group">
                            <input type="text" class="form-control" id="nitE" name="nitE" placeholder="NIT" required>
                        </div>

                        <br>

                        <div class="form-group">
                            <input type="text" class="form-control" id="nupE" name="nupE" placeholder="NUP" required>
                        </div>

                        <br>

                        <div class="form-group">
                            <input type="text" class="form-control" id="pasaporteE" name="pasaporteE" placeholder="Pasaporte" required>
                        </div>

                        <br>

                        <div class="form-group">
                            <input type="text" class="form-control" id="docPersonalE" name="docPersonalE" placeholder="Documento Personal" required>
                        </div>

                        <br>

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


<%@ include file="../common/footer1.jspf"%>

<script src="${pageContext.request.contextPath}/js/estudiantes.js"></script>

<script>
    $(document).ready(function () {
        $('#formGuardar').submit(function (event) {
            event.preventDefault();//detiene el evento del envio del form 
            var idEstudiante = $('#estudianteId').val();//tomo la id

            var formDataArray = $(this).serializeArray();//tomo los datos del array

            var url;//valido el tipo de url si editar o crear
            if (idEstudiante) {
                url = '/ActualizarEstudiante';
                //meto la id en el campo de envio
                formDataArray.push({name: 'idEstudiante', value: idEstudiante});
            } else {
                url = '/AgregarEstudiante';
            }
            // Convertir el arreglo en un objeto
            var formData = {};
            $.map(formDataArray, function (n, i) {
                formData[n['name']] = n['value'];
            });
            
            console.log(formData);
            
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
            var idEstudiante = $(this).data('id');
            var modal = $('#crearModal');
            var tituloModal = modal.find('.modal-title');
            var form = modal.find('form');
            var btnSumit = document.getElementById('btnSumit');

            if (idEstudiante) {
                tituloModal.text('Editar Estudiante');//titulo del modal
                $.ajax({//utilizo ajax para obtener los datos
                    url: '/ObtenerEstudiante/' + idEstudiante,
                    type: 'GET',
                    success: function (response) {
                        $('#carnetE').val(response.carnetE);
                        $('#nombresE').val(response.nombresE);
                        $('#apellidosE').val(response.apellidosE);
                        $('#sexoE').val(response.sexoE);
                        $('#fechaNacE').val(response.fechaNacE);
                        $('#nacionalidadE').val(response.nacionalidadE);
                        $('#idPais').val(response.idPais.idPais);
                        $('#duiE').val(response.duiE);
                        $('#nitE').val(response.nitE);
                        $('#nupE').val(response.nupE);
                        $('#pasaporteE').val(response.pasaporteE);
                        $('#docPersonalE').val(response.docPersonalE);
                        $('#estudianteId').val(idEstudiante);
                    },
                    error: function () {
                        alert('Error al obtener los datos del estudiante.');
                    }
                });
            } else {
                // en caso de presionar el boton de nuevo solo se abrira el modal
                tituloModal.text('Agregar Estudiante');
                form.attr('action', '/AgregarEstudiante');
                $('#carnetE').val('');
                $('#nombresE').val('');
                $('#apellidosE').val('');
                $('#sexoE').val('');
                $('#fechaNacE').val('');
                $('#nacionalidadE').val('');
                $('#idPais').val('');
                $('#duiE').val('');
                $('#nitE').val('');
                $('#nupE').val('');
                $('#pasaporteE').val('');
                $('#docPersonalE').val('');
                $('#estudianteId').val('');
            }
            modal.modal('show');
        });
    });

</script>

