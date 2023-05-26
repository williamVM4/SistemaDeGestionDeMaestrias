$(document).ready(function() { 
    $('#maestriasTable').DataTable({
        ajax: '/maestria/data',
        processing: true,
        serverSide: true,
        dom: "<'row w-100'<'col-sm-6'l><'col-sm-6'f>>" +
             "<'row w-100'<'col-sm-12 my-4'tr>>" +
             "<'row w-100'<'col-sm-5'i><'col-sm-7'p>>",
        columns: [
            { data: 'nombreMaestria', width: '25%' },
            { 
                data: 'idPostgrado.nombrePostgrado',
                render: function(data, type, row) {
                    return data || '';
                }, width: '33%'
            },
            { 
                data: 'idPostgrado.idFacultad.nombreFacultad',
                render: function(data, type, row) {
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
                    var actionsHtml = '<a type="button" class="btn btn-outline-secondary" href="/DetalleMaestria/' + row.idMaestria + '">';
                    actionsHtml += '<i class="bi bi-eye"></i></a>';
                    
                    if(hasPrivilegeAdmin == true){
                        actionsHtml += '<button type="button" class="btn btn-outline-warning abrirModal-btn" data-bs-toggle="modal" ';
                        actionsHtml += 'data-bs-target="#crearModal" data-tipo="editar" data-id="' + row.idMaestria + '" data-modo="actualizar">';
                        actionsHtml += '<i class="bi bi-pencil-square"></i></button>';
                    }
                    actionsHtml += '<a href="#" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#confirmarEliminar-' + row.idMaestria + '">';
                    actionsHtml += '<i class="bi bi-trash"></i></a>';
                    actionsHtml += '<div class="modal fade" id="confirmarEliminar-' + row.idMaestria + '" tabindex="-1" aria-labelledby="confirmarEliminarLabel-' + row.idMaestria + '" aria-hidden="true">';
                    actionsHtml += '<div class="modal-dialog">';
                    actionsHtml += '<div class="modal-content">';
                    actionsHtml += '<div class="modal-header">';
                    actionsHtml += '<h5 class="modal-title" id="confirmarEliminarLabel-${elemento.idMaestria}">Confirmar eliminación</h5>';
                    actionsHtml += '<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>';
                    actionsHtml += '</div>';
                    actionsHtml += '<div class="modal-body">';
                    actionsHtml += '<strong>¿Estás seguro de eliminar la maestria seleccionada?</strong>';
                    actionsHtml += '<p>Ten en cuenta que se eliminarán los datos relacionados a la maestria de ' + row.nombreMaestria + '.</p>';
                    actionsHtml += '</div>';
                    actionsHtml += '<div class="modal-footer">';
                    actionsHtml += '<a href="/EliminarMaestria/' + row.idMaestria + '" class="btn btn-danger">Eliminar</a>';
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



