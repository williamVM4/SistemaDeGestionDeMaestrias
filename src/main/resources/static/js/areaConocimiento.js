$(document).ready(function() { 
    $('#areaConocimientoTable').DataTable({
        ajax: '/areaConocimiento/data',
        processing: true,
        serverSide: true,
        dom: "<'row w-100'<'col-sm-6'l><'col-sm-6'f>>" +
             "<'row w-100'<'col-sm-12 my-5'tr>>" +
             "<'row w-100'<'col-sm-5'i><'col-sm-7'p>>",
        columns: [
            { data: 'idAreaConocimiento'},
            { data: 'nombreArea'},
            { data: 'descripcion'},
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
                        actionsHtml += 'data-bs-target="#crearModal" data-tipo="editar" data-id="' + row.idAreaConocimiento + '" data-modo="actualizar">';
                        actionsHtml += '<i class="bi bi-pencil-square"></i></button>';
                    //}
                    
                    actionsHtml += '<a href="#" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#confirmarEliminar-' + row.idAreaConocimiento + '">';
                    actionsHtml += '<i class="bi bi-trash"></i></a>';
                    actionsHtml += '<div class="modal fade" id="confirmarEliminar-' + row.idAreaConocimiento + '" tabindex="-1" aria-labelledby="confirmarEliminarLabel-' + row.idAreaConocimiento + '" aria-hidden="true">';
                    actionsHtml += '<div class="modal-dialog">';
                    actionsHtml += '<div class="modal-content">';
                    actionsHtml += '<div class="modal-header">';
                    actionsHtml += '<h5 class="modal-title" id="confirmarEliminarLabel-${elemento.idAreaConocimiento}">Confirmar eliminación</h5>';
                    actionsHtml += '<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>';
                    actionsHtml += '</div>';
                    actionsHtml += '<div class="modal-body">';
                    actionsHtml += '<strong>¿Estás seguro de eliminar la maestria seleccionada?</strong>';
                    actionsHtml += '<p>Ten en cuenta que se eliminarán los datos relacionados a la maestria de ' + row.nombreMaestria + '.</p>';
                    actionsHtml += '</div>';
                    actionsHtml += '<div class="modal-footer">';
                    actionsHtml += '<a href="/EliminarAreaConocimiento/' + row.idAreaConocimiento + '" class="btn btn-danger">Eliminar</a>';
                    actionsHtml += '<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>';
                    actionsHtml += '</div>';
                    actionsHtml += '</div>';
                    actionsHtml += '</div>';
                    actionsHtml += '</div>';
              
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
});


