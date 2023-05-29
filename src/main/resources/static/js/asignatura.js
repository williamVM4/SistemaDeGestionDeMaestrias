$(document).ready(function () {
    $('#asignaturaTable').DataTable({
        ajax: '/Asignatura/data?idMallaCurricular=' + idMallaCurricular,
        processing: true,
        serverSide: true,
        dom: "<'row w-100'<'col-sm-6'l><'col-sm-6'f>>" +
                "<'row w-100'<'col-sm-12 my-5'tr>>" +
                "<'row w-100'<'col-sm-5'i><'col-sm-7'p>>",
        columns: [
            {data: 'numeroCorrelativo'},
            {data: 'codAsignatura'},
            {data: 'nombreMateria'},
            {data: 'unidadesValorativas'},
            {data: 'ciclo'},
            {
                data: null,
                title: 'Acciones',
                sortable: false,
                searchable: false,
                className: 'd-flex justify-content-around',
                render: function (data, type, row) {
                    // Aquí puedes construir el HTML para las acciones según tus necesidades
                    var actionsHtml = '';
                    actionsHtml += '<a type="button" title="Programa" class="btn btn-outline-secondary"';
                    actionsHtml += 'title="" href="/viewPrograma/' + row.idProgramAsignatura.idProgramAsignatura + '">';
                    actionsHtml += '<i class="bi bi-arrow-up-right-square"></i></a>';
                    
                    actionsHtml += '<a type="button" title="Actividades" class="btn btn-outline-secondary"';
                    actionsHtml += 'title="" href="/viewActividad/' + row.idProgramAsignatura.idProgramAsignatura + '">';
                    actionsHtml += '<i class="bi bi-card-checklist"></i></a>';
                    
                    //if(hasPrivilegeAdmin == true){
                    actionsHtml += '<button title="Actualizar" type="button" class="btn btn-outline-primary abrirModal-btn" data-bs-toggle="modal" ';
                    actionsHtml += 'data-bs-target="#crearModal" data-tipo="editar" data-id="' + row.idAsignatura + '" data-modo="actualizar">';
                    actionsHtml += '<i class="bi bi-pencil-square"></i></button>';
                    //}

                    actionsHtml += '<button type="button" title="Eliminar" class="btn btn-outline-danger eliminarModal-btn" data-id="' + row.idAsignatura + '" ';
                    actionsHtml += 'data-nombre="' + row.nombreMateria + '">';
                    actionsHtml += '<i class="bi bi-trash"></i></button>';

                    return actionsHtml;
                }
            }
        ],
        language: {
            "sProcessing": "Procesando...",
            "sLengthMenu": "Mostrar _MENU_ registros",
            "sZeroRecords": "No se encontraron resultados",
            "sEmptyTable": "Ningún dato disponible en esta tabla",
            "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
            "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
            "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix": "",
            "sSearch": "Buscar:",
            "sUrl": "",
            "sInfoThousands": ",",
            "sLoadingRecords": "Cargando...",
            "oPaginate": {
                "sFirst": "Primero",
                "sLast": "Último",
                "sNext": "Siguiente",
                "sPrevious": "Anterior"
            },
            "oAria": {
                "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            },
            "buttons": {
                "copy": "Copiar",
                "colvis": "Visibilidad"
            }
        },
        search: {
            return: true
        }
    });
    //total horas
    // Obtener referencias a los elementos de input y resultado
    var horasT = $('#horasT');
    var horasP = $('#horasP');
    var horaCiclo = $('#horaCiclo');

    // Detectar cambios en los inputs
    horasT.on('change', sumarValores);
    horasP.on('change', sumarValores);

    // Función para sumar los valores y asignar el resultado
    function sumarValores() {
        var valor1 = parseInt(horasT.val()) || 0; // Obtener valor del input 1, convertir a entero
        var valor2 = parseInt(horasP.val()) || 0; // Obtener valor del input 2, convertir a entero
        var suma = valor1 + valor2; // Sumar los valores

        horaCiclo.val(suma); // Asignar el resultado al input de resultado
    }


    $.validator.addMethod('positiveInteger', function (value, element) {
        return this.optional(element) || /^[1-9]\d*$/.test(value);
    }, 'Ingrese un valor positivo entero válido.');
    var validator = $('#formGuardar').validate({
        rules: {// reglas
            codigoAsignatura: {
                required: true
            },
            nombreAsignatura: {
                required: true
            },
            uv: {
                required: true,
                positiveInteger: true
            },
            numeroCorrelativo: {
                required: true,
                positiveInteger: true
            },
            ciclo: {
                required: true,
                positiveInteger: true
            },
            idAreaC: {
                required: true
            },
            duracion: {
                required: true,
                positiveInteger: true
            },
            horasT: {
                required: true,
                positiveInteger: true
            },
            horasP: {
                required: true,
                positiveInteger: true
            },
            horaCiclo: {
                required: true,
                positiveInteger: true
            },
            introduccion: {
                required: true
            },
            descipcionPrograma: {
                required: true
            },
            objetivo: {
                required: true
            },
            metodologia: {
                required: true
            },
            sistemaEvaluacion: {
                required: true
            },
            bibliografia: {
                required: true
            },
            actividad: {
                required: true,
                minlength: 1
            },
            ponderacion: {
                required: true,
                minlength: 1,
                positiveInteger: true
            }
        },
        messages: {// mensajes
            codigoAsignatura: {
                required: 'Campo Requerido'
            },
            nombreAsignatura: {
                required: 'Campo Requerido'
            },
            uv: {
                required: 'Campo Requerido'
            },
            numeroCorrelativo: {
                required: 'Campo Requerido'
            },
            ciclo: {
                required: 'Campo Requerido'
            },
            idAreaC: {
                required: 'Campo Requerido'
            },
            duracion: {
                required: 'Campo Requerido'
            },
            horasT: {
                required: 'Campo Requerido'
            },
            horasP: {
                required: 'Campo Requerido'
            },
            horaCiclo: {
                required: 'Campo Requerido'
            },
            introduccion: {
                required: 'Campo Requerido'
            },
            descipcionPrograma: {
                required: 'Campo Requerido'
            },
            objetivo: {
                required: 'Campo Requerido'
            },
            metodologia: {
                required: 'Campo Requerido'
            },
            sistemaEvaluacion: {
                required: 'Campo Requerido'
            },
            bibliografia: {
                required: 'Campo Requerido'
            },
            actividad: {
                required: 'Campo Requerido'
            },
            ponderacion: {
                required: 'Campo Requerido'
            }
        },
        highlight: function (element) {
            $(element).addClass('is-invalid');
        },
        unhighlight: function (element) {
            $(element).removeClass('is-invalid');
        },
        errorPlacement: function (error, element) {
            error.insertAfter(element);
        },
        errorElement: 'div',
        errorClass: 'invalid-feedback',
        submitHandler: function (form) {
            event.preventDefault();

            var idAsignatura = $('#asignaturaId').val();//tomo la id
            var mallaId = $('#mallaId').val();//tomo la id
            var formData = $('#formGuardar').serializeArray();//tomo los datos del array
            formData.push({name: 'mallaId', value: mallaId});
            var url;//valido el tipo de url si editar o crear
            if (idAsignatura) {
                url = '/ActualizarAsignatura';
                //meto la id en el campo de envio
                formData.push({name: 'idAsignatura', value: idAsignatura});
            } else {
                url = '/AgregarAsignatura';
            }
            //realizo el guardado mediante ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: formData,
                success: function (response) {
                    $('#crearModal').modal('hide');  // Cierra el modal
                    var table = $('#asignaturaTable').DataTable();
                    table.ajax.reload(null, false); // Recargar sin reiniciar la paginación
                    mostrarMensaje(response, 'success');
                },
                error: function (xhr, status, error) {
                    $('#crearModal').modal('hide');  // Cierra el modal
                    console.log(error);
                    var errorMessage = xhr.responseText || 'Error al actualizar la Asignatura.';
                    mostrarMensaje(errorMessage, 'danger');
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
        $("#actividades-extra").empty();
        //validator.resetForm();  // Restablecer la validación
        $('#formGuardar').find('.is-invalid').removeClass('is-invalid');

        $('#formGuardar').validate().resetForm();//quita los mensajes de error 
        if (idAreaConocimiento) {
            tituloModal.text('Editar Asignatura');//titulo del modal
            $.ajax({//utilizo ajax para obtener los datos
                url: '/ObtenerAreaConocimiento/' + idAreaConocimiento,
                type: 'GET',
                success: function (response) {
                    //$('#nombreArea').val(response.nombreArea);
                },
                error: function () {
                    alert('Error al obtener los datos del Ã¡rea de conocimiento.');
                }
            });
        } else {
            // en caso de presionar el boton de nuevo solo se abrira el modal
            tituloModal.text('Agregar Asignatura');
            form.attr('action', '/AgregarAsignatura');
            $('#nombreArea').val('');

        }
        modal.modal('show');
    });

    // Método para mostrar el modal de eliminación
    $(document).on('click', '.eliminarModal-btn', function () {
        var idAsignatura = $(this).data('id');
        var nombreAsignatura = $(this).data('nombre');

        var modal = $('#confirmarEliminarModal');
        var tituloModal = modal.find('.modal-title');
        var cuerpoModal = modal.find('.modal-body');
        var eliminarBtn = modal.find('#eliminarAsignaturaBtn');

        // Actualizar el contenido del modal con los parámetros recibidos
        tituloModal.text('Confirmar eliminación');
        cuerpoModal.html('<strong>¿Estás seguro de eliminar la Àrea de Conocimiento seleccionada?</strong><br>Ten en cuenta que se eliminarán los datos relacionados a la Àrea de Conocimiento ' + nombreAsignatura + '.');

        // Actualizar el atributo href del botón de eliminación con el idMaestria
        eliminarBtn.data('id', idAsignatura);

        modal.modal('show');
    });

    //Método para enviar la solicitud de eliminar
    $(document).on('click', '#eliminarAsignaturaBtn', function () {
        var idAsignatura = $(this).data('id');
        // Actualizar la acción del formulario con el idMaestria
        $('#eliminarAsignaturaForm').attr('action', '/EliminarAsignatura/' + idAsignatura);

        // Realizar la solicitud POST al método de eliminación
        $.ajax({
            url: $('#eliminarAsignaturaForm').attr('action'),
            type: 'POST',
            data: $('#eliminarAsignaturaForm').serialize(), // Incluir los datos del formulario en la solicitud
            success: function (response) {
                $('#confirmarEliminarModal').modal('hide');
                // Recargar el DataTable
                $('#asignaturaTable').DataTable().ajax.reload();
                // Mostrar el mensaje de éxito del controlador
                mostrarMensaje(response, 'success');
            },
            error: function () {
                $('#confirmarEliminarModal').modal('hide');
                // Mostrar mensaje de error en caso de que la solicitud falle
                mostrarMensaje('Error al eliminar la Asignatura.', 'danger');
            }
        });

    });

    function mostrarMensaje(mensaje, tipo) {
        var alertElement = $('.alert-' + tipo);
        alertElement.text(mensaje).addClass('show').removeClass('d-none');
        setTimeout(function () {
            alertElement.removeClass('show').addClass('d-none');
        }, 5000); // Ocultar el mensaje después de 3 segundos (ajusta el valor según tus necesidades)
    }
});





