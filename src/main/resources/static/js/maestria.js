$(document).ready(function() { 
    $('#maestriasTable').DataTable({
        ajax: '/maestria/data',
        processing: true,
        serverSide: true,
        columns: [
            { data: 'nombreMaestria' },
            { 
                data: 'idPostgrado.nombrePostgrado',
                render: function(data, type, row) {
                    return data || '';
                }
            },
            { 
                data: 'idPostgrado.idFacultad.nombreFacultad',
                render: function(data, type, row) {
                    return data || '';
                }
            },
            {
                data: null,
                title: 'Acciones',
                sortable: false,
                searchable: false,
                className: 'd-flex justify-content-around',
                render: function (data, type, row) {
                    // Aquí puedes construir el HTML para las acciones según tus necesidades
                    var actionsHtml = '<a type="button" class="btn btn-outline-secondary" href="#">';
                    actionsHtml += '<i class="bi bi-eye"></i></a>';
                    
                    if(hasPrivilegeAdmin == true){
                        actionsHtml += '<button type="button" class="btn btn-outline-primary abrirModal-btn" data-bs-toggle="modal" ';
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
            search: "_INPUT_",
            searchPlaceholder: "Buscar...",
            lengthMenu: "_MENU_ registros por página",
            info: "Mostrando _START_ a _END_ de _TOTAL_ entradas",
        paginate: {
            first: "Primero",
            last: "Último",
            next: "Siguiente",
            previous: "Anterior"
        }
        },
        search: {
            return: true
        }
    });
});


