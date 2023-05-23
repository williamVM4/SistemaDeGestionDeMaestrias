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
                        actionsHtml += '<button type="button" class="btn btn-outline-warning abrirModal-btn" data-bs-toggle="modal" ';
                        actionsHtml += 'data-bs-target="#crearModal" data-tipo="editar" data-id="' + row.id + '" data-modo="actualizar">';
                        actionsHtml += '<i class="bi bi-pencil-square"></i></button>';
                    }
                    
                    actionsHtml += '<a href="#" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#confirmarEliminar-' + row.id + '">';
                    actionsHtml += '<i class="bi bi-trash"></i></a>';
              
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


