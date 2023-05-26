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
                            <h1>Área de Conocimientos</h1>
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
                    <button type="button" class="btn btn-outline-primary btn-sm abrirModal-btn" 
                            data-bs-toggle="modal" data-bs-target="#crearModal" 
                            data-action="agregar">Agregar</button>
                </div>
            </div>

            <br>

            <div class="pt-4">
                <div class="table-responsive">
                    <table id="areaConocimientoTable" class="table table-bordered dtr-inline">
                        <thead class="thead-light">
                            <tr>
                                <th class="text-center">N°</th>
                                <th class="text-center">Nombre</th>
                                <th class="text-center">Descripción</th>
                                <th class="text-center"></th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>

    <!-- Modal para agregar -->
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
                        <input type="hidden" id="areaId">
                        <div class="form-group">
                            <input type="text" class="form-control" id="nombreArea" name="nombreArea" placeholder="Nombre de la Ã€rea">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="descripcion" name="descripcion" placeholder="DescripciÃ²n">
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
    <%@ include file="../common/footer1.jspf"%>
    <script src="${pageContext.request.contextPath}/js/areaConocimiento.js"></script>
    <script>
        $(document).ready(function () {
            $('#mensajeExito').hide();
            $('#formGuardar').validate({
                rules: {// reglas
                    nombreArea: {
                        required: true
                    },
                    descripcion: {
                        required: true
                    }
                },
                messages: {// mensajes
                    nombreArea: {
                        required: 'Este campo es requerido'
                    },
                    descripcion: {
                        required: 'Este campo es requerido'
                    },
                },
                submitHandler: function (form) {
                    event.preventDefault();

                    var idAreaConocimiento = $('#areaId').val();//tomo la id
                    var formDataArray = $('#formGuardar').serializeArray();//tomo los datos del array

                    var url;//valido el tipo de url si editar o crear
                    if (idAreaConocimiento) {
                        url = '/ActualizarAreaConocimiento';
                        //meto la id en el campo de envio
                        formDataArray.push({name: 'idAreaConocimiento', value: idAreaConocimiento});
                    } else {
                        url = '/AgregarAreaConocimiento';
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
                            location.reload();  // Recarga la pÃ¡gina
                            console.log(response.mensaje);
                        },
                        error: function (error) {
                            console.log(error);
                        }
                    });
                }
            });

            // metodo para mostrar el modal segun sea si editar o nuevo registro
            $(document).on('click', '.abrirModal-btn', function () {
                var idAreaConocimiento = $(this).data('id');
                var modal = $('#crearModal');
                var tituloModal = modal.find('.modal-title');
                var form = modal.find('form');
                var btnSumit = document.getElementById('btnSumit');
                $('#formGuardar').validate().resetForm();//quita los mensajes de error 
                if (idAreaConocimiento) {
                    tituloModal.text('Editar Area de Conocimiento');//titulo del modal
                    $.ajax({//utilizo ajax para obtener los datos
                        url: '/ObtenerAreaConocimiento/' + idAreaConocimiento,
                        type: 'GET',
                        success: function (response) {
                            $('#nombreArea').val(response.nombreArea);
                            $('#descripcion').val(response.descripcion);
                            $('#areaId').val(idAreaConocimiento);
                        },
                        error: function () {
                            alert('Error al obtener los datos del Ã¡rea de conocimiento.');
                        }
                    });
                } else {
                    // en caso de presionar el boton de nuevo solo se abrira el modal
                    tituloModal.text('Agregar Conocimiento');
                    form.attr('action', '/AgregarAreaConocimiento');
                    $('#nombreArea').val('');
                    $('#descripcion').val('');
                    $('#areaId').val('');
                }
                modal.modal('show');
            });
        });

    </script>


