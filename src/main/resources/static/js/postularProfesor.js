$(document).ready(function () {
//Cargar dataTable
    $('#maestriasTable').DataTable({
        ajax: '/maestria/data',
        processing: true,
        serverSide: true,
        dom: "<'row w-100'<'col-sm-6'l><'col-sm-6'f>>" +
                "<'row w-100'<'col-sm-12 my-4'tr>>" +
                "<'row w-100'<'col-sm-5'i><'col-sm-7'p>>",
        columns: [
            {data: 'nombreMaestria', width: '25%'},
            {
                data: 'idPostgrado.nombrePostgrado',
                render: function (data, type, row) {
                    return data || '';
                }, width: '33%'
            },
            {
                data: 'idPostgrado.idFacultad.nombreFacultad',
                render: function (data, type, row) {
                    return data || '';
                }, width: '30%'
            },
            {
                data: null,
                title: 'Acciones',
                sortable: false,
                searchable: false,
                width: '12%',
                render: function (data, type, row) {
                    // Aquí puedes construir el HTML para las acciones según tus necesidades
                    var actionsHtml = '';
                    actionsHtml += '<button type="button" title="Postularse" class="btn btn-outline-success abrirModal-btn"';
                    actionsHtml += '">';
                    actionsHtml += '<i class="bi bi-check-square"></i></button>';

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
    $(document).on('click', '.abrirModal-btn', function () {
        var modal = $('#postularModal');
        modal.modal('show');
    });
    $(document).on('click', '.postular-btn', function () {

        var fechaActual = new Date();
        var url = '/AgregarPostulado';
        var formDataArray = $('#formGuardar').serializeArray();
        formDataArray.push({name: 'idAspiranteProfesor', value: 1});
        formDataArray.push({name: 'idCohorte', value: 1});
        formDataArray.push({name: 'fechaPostulacion', value: "25-MAY-23"});
        var formData = {};
        $.map(formDataArray, function (n, i) {
            formData[n['name']] = n['value'];
        });
        $.ajax({
            url: url,
            type: 'POST',
            data: formData,
            success: function (response) {
                $('#postularModal').modal('hide');  // Cierra el modal
                //location.reload();
                //mostrarMensaje(response, 'success');
            },
            error: function (xhr, status, error) {
                $('#crearModal').modal('hide');  // Cierra el modal
                var errorMessage = xhr.responseText || 'Error al actualizar la maestría.';
                //mostrarMensaje(errorMessage, 'danger');
                console.log(errorMessage);
            }
        });

    });
});


