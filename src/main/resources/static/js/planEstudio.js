$(document).ready(function() { 
    $('#maestriasTable').DataTable({
        ajax: '/planEstudio/data',
        processing: true,
        serverSide: true,
        order: [[2, 'desc']],
        dom: "<'row w-100'<'col-sm-6'l><'col-sm-6'f>>" +
             "<'row w-100'<'col-sm-12 my-4'tr>>" +
             "<'row w-100'<'col-sm-5'i><'col-sm-7'p>>",
        columns: [
            { data: 'codPlan', width: '25%' },
            { 
                data: 'modalidad',width: '33%'
            },
            { 
                data: 'planEstado',
                width: '30%',
                render: function (data, type, row) {
                    var estado = (data === 1) ? 'Activo' : 'Inactivo';
                    return estado;
                }
            },
            {
                data: null,
                title: 'Acciones',
                sortable: false,
                searchable: false,
                width: '12%',
                render: function (data, type, row) {
                    // Aquí puedes construir el HTML para las acciones según tus necesidades
                    var actionsHtml = '<a type="button" class="btn btn-outline-secondary" href="/DetallePlanEstudio/' + row.idPlanEstudio + '">';
                    actionsHtml += '<i class="bi bi-eye"></i></a>';
              
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

