$(document).ready(function () {
    $('#asignaturaTable').DataTable({
        ajax: '/Asignatura/data',
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

                    //if(hasPrivilegeAdmin == true){
                    actionsHtml += '<button type="button" class="btn btn-outline-primary abrirModal-btn" data-bs-toggle="modal" ';
                    actionsHtml += 'data-bs-target="#crearModal" data-tipo="editar" data-id="' + row.idAsignatura + '" data-modo="actualizar">';
                    actionsHtml += '<i class="bi bi-pencil-square"></i></button>';
                    //}
                    actionsHtml += '<button type="button" class="btn btn-outline-danger eliminarModal-btn" data-id="' + row.idAsignatura + '" ';
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

    var validator = $('#formGuardar').validate({
        rules: {// reglas
            nombreArea: {
                required: true
            },
        },
        messages: {// mensajes
            nombreArea: {
                required: ''
            },
        },
        highlight: function (element) {
            $(element).addClass('is-invalid');
        },
        unhighlight: function (element) {
            $(element).removeClass('is-invalid');
        },
        errorPlacement: function (error, element) {
            if (element.attr("name") === "nombreArea") {
                error.insertAfter(element);
            } else {
                if (element.attr("name") === "descripcion") {
                    error.insertAfter(element);
                }
            }
        },
        errorElement: 'div',
        errorClass: 'invalid-feedback',
        submitHandler: function (form) {
            event.preventDefault();

            var idAsignatura = $('#asignaturaId').val();//tomo la id
            var formData = $('#formGuardar').serializeArray();//tomo los datos del array

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
                    //mostrarMensaje(response, 'success');
                    console.log(response);
                },
                error: function (xhr, status, error) {
                    $('#crearModal').modal('hide');  // Cierra el modal
                    console.log(error);
                    //var errorMessage = xhr.responseText || 'Error al actualizar la Asignatura.';
                    //mostrarMensaje(errorMessage, 'danger');
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
    /*
     // Método para mostrar el modal de eliminación
     $(document).on('click', '.eliminarModal-btn', function () {
     var idArea = $(this).data('id');
     var nombreArea = $(this).data('nombre');
     
     var modal = $('#confirmarEliminarModal');
     var tituloModal = modal.find('.modal-title');
     var cuerpoModal = modal.find('.modal-body');
     var eliminarBtn = modal.find('#eliminarAreaBtn');
     
     // Actualizar el contenido del modal con los parámetros recibidos
     tituloModal.text('Confirmar eliminación');
     cuerpoModal.html('<strong>¿Estás seguro de eliminar la Àrea de Conocimiento seleccionada?</strong><br>Ten en cuenta que se eliminarán los datos relacionados a la Àrea de Conocimiento ' + nombreArea + '.');
     
     // Actualizar el atributo href del botón de eliminación con el idMaestria
     eliminarBtn.data('id', idArea);
     
     modal.modal('show');
     });
     
     //Método para enviar la solicitud de eliminar
     $(document).on('click', '#eliminarAreaBtn', function () {
     var idArea = $(this).data('id');
     // Actualizar la acción del formulario con el idMaestria
     $('#eliminarAreaForm').attr('action', '/EliminarAreaConocimiento/' + idArea);
     
     // Realizar la solicitud POST al método de eliminación
     $.ajax({
     url: $('#eliminarAreaForm').attr('action'),
     type: 'POST',
     data: $('#eliminarAreaForm').serialize(), // Incluir los datos del formulario en la solicitud
     success: function (response) {
     $('#confirmarEliminarModal').modal('hide');
     // Recargar el DataTable
     $('#areaConocimientoTable').DataTable().ajax.reload();
     // Mostrar el mensaje de éxito del controlador
     mostrarMensaje(response, 'success');
     },
     error: function () {
     $('#confirmarEliminarModal').modal('hide');
     // Mostrar mensaje de error en caso de que la solicitud falle
     mostrarMensaje('Error al eliminar la Àrea de Conocimiento.', 'danger');
     }
     });
     
     });
     
     function mostrarMensaje(mensaje, tipo) {
     var alertElement = $('.alert-' + tipo);
     alertElement.text(mensaje).addClass('show').removeClass('d-none');
     setTimeout(function () {
     alertElement.removeClass('show').addClass('d-none');
     }, 5000); // Ocultar el mensaje después de 3 segundos (ajusta el valor según tus necesidades)
     }*/
});





