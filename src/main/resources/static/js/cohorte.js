$(document).ready(function() { 
    $('#cohorteTable').DataTable({
        ajax: '/cohorte/data?idMaestria=' + idMaestria,
        processing: true,
        serverSide: true,
        order: [[2, 'desc']],
        dom: "<'row w-100'<'col-sm-6'l><'col-sm-6'f>>" +
             "<'row w-100'<'col-sm-12 my-4'tr>>" +
             "<'row w-100'<'col-sm-5'i><'col-sm-7'p>>",
        columns: [
            { 
                data: 'nombreCohorte',width: '20%'
            },
            { data: 'fechaApertura', width: '20%' },
            { 
                data: 'estadoCohorte',width: '20%'
            },
            {
                data: null,
                title: 'Acciones',
                sortable: false,
                searchable: false,
                width: '40%',
                render: function (data, type, row) {
                    // Aquí puedes construir el HTML para las acciones según tus necesidades
//                    var actionsHtml = '<a type="button" class="btn btn-outline-secondary" href="/DetallePlanEstudio/' + row.idPlanEstudio + '">';
//                    actionsHtml += '<i class="bi bi-eye"></i></a>';
                    
                    var actionsHtml = '<button type="button" class="btn btn-outline-warning abrirModal-btn" data-bs-toggle="modal" ';
                    actionsHtml += 'data-bs-target="#crearModal" data-tipo="editar" data-id="' + row.idCohorte + '" data-modo="actualizar">';
                    actionsHtml += '<i class="bi bi-pencil-square"></i></button>';
                    
                    actionsHtml += '<button type="button" class="btn btn-outline-danger eliminarModal-btn" data-id="' + row.idCohorte + '" ';
                    actionsHtml += 'data-cod="' + row.idCohorte + '">';
                    actionsHtml += '<i class="bi bi-trash"></i></button>';
                    
                    //Boton para habilitar/deshabilitar
                    actionsHtml += '<button type="button" class="btn btn-outline-secondary" ">';
//                    actionsHtml += 'data-cod="' + row.idCohorte + '">';
                    actionsHtml += '<i class="bi bi-check"></i></button>';
                    
                    //Boton para aspirantes
                    actionsHtml += '<button type="button" class="btn btn-outline-success abrirModal-btn" data-bs-toggle="modal" ';
                    actionsHtml += 'data-bs-target="#crearModal" data-tipo="editar" data-id="' + row.idCohorte + '" data-modo="actualizar">';
                    actionsHtml += '<i class="bi bi-person-fill-add"></i></button>';
                    
              
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
            "sInfoFiltered": "",
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

    

