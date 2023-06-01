$(document).ready(function () {
    var montoPagarHora = $('#montoPagarHora');
    var unidadHorasImpartir = $('#unidadHorasImpartir');
    var montoTotalServicios = $('#montoTotalServicios');
    montoPagarHora.on('change', sumarValores);
    unidadHorasImpartir.on('change', sumarValores);

    // Función para sumar
    function sumarValores() {
        var valor1 = parseInt(montoPagarHora.val()) || 0;
        var valor2 = parseInt(unidadHorasImpartir.val()) || 0;
        var suma = (valor1 * valor2);

        montoTotalServicios.val(suma);
    }

    var fechaContratacion = document.getElementById("fechaContratacion");

    $(fechaContratacion).inputmask('99/99/9999', {
        showMaskOnFocus: false,
        showMaskOnHover: false
    });

    $.validator.addMethod("validarFecha", function (value, element) {
        return this.optional(element) || /^(0[1-9]|1\d|2\d|3[01])\/(0[1-9]|1[0-2])\/\d{4}$/.test(value);
    }, "Ingresa una fecha en formato DD/MM/AAAA");

    $(document).on('click', '.abrirModal-btn', function () {
        var id = $(this).data('id');

        $('#idAspiranteProfesor').val(id);
    });

    var formGuardar = $('#formGuardar');
    var validator = $('#formGuardar').validate({
        rules: {
            montoPagarHora: {
                required: true
            },
            unidadHorasImpartir: {
                required: true,
            },
            montoTotalServicios: {
                required: true
            },
            fechaContratacion: {
                required: true,
                validarFecha: true
            }
        },

        messages: {
            montoPagarHora: {
                required: 'Este campo es requerido'
            },

            unidadHorasImpartir: {
                required: 'Este campo es requerido',
            },
            montoTotalServicios: {
                required: 'Este campo es requerido'
            },

            fechaContratacion: {
                required: 'Este campo es requerido',
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
            event.preventDefault(); // detiene el evento del envío del formulario
            var idCohorte = $('#idCohorte').val(); // tomo la id

            var formDataArray = formGuardar.serializeArray(); // tomo los datos del array
            var url; // valido el tipo de URL si editar o crear
            var id = $(this).data('id');
            url = '/ContratarAspirante';
            //formDataArray.push({name: 'idMaestria', value: idMaestria});

            // Convertir el arreglo en un objeto
            var formData = {};
            $.map(formDataArray, function (n, i) {
                formData[n['name']] = n['value'];
            });

            console.log(formDataArray);
            // realizo el guardado mediante ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: formData,
                success: function (response) {
                    $('#contratar').modal('hide'); // Cierra el modal
                    //var table = $('#cohorteTable').DataTable();
                    //table.ajax.reload(null, false); // Recargar sin reiniciar la paginación
                    //mostrarMensaje(response, 'success');
                    console.log(response);
                },
                error: function (xhr, status, error) {
                    $('#crearModal').modal('hide'); // Cierra el modal
                    //var errorMessage = xhr.responseText || 'Error al actualizar la cohorte.';
                    //mostrarMensaje(errorMessage, 'danger');

                    console.log(error);
                }
            });
        }
    });
    // Método para mostrar el modal de eliminación
    $(document).on('click', '.eliminarModal-btn', function () {
        var id = $(this).data('id');
        var nombre = $(this).data('nombre');

        var modal = $('#confirmarEliminarModal');
        var tituloModal = modal.find('.modal-title');
        var cuerpoModal = modal.find('.modal-body');
        var eliminarBtn = modal.find('#eliminarBtn');

        // Actualizar el contenido del modal con los parámetros recibidos
        tituloModal.text('Confirmar eliminación');
        cuerpoModal.html('<strong>¿Estás seguro de eliminar la Àrea de Conocimiento seleccionada?</strong><br>Ten en cuenta que se eliminarán los datos relacionados a el Profesor ' + nombre + '.');

        // Actualizar el atributo href del botón de eliminación con el idMaestria
        eliminarBtn.data('id', id);

        modal.modal('show');
    });
    //Método para enviar la solicitud de eliminar
    $(document).on('click', '#eliminarBtn', function () {
        var idProfesorCohorte = $(this).data('id');
        // Actualizar la acción del formulario con el idMaestria
        $('#eliminarForm').attr('action', '/EliminarProfesor/' + idProfesorCohorte);

        var formData = $('#eliminarForm').serializeArray();
        formData.push({name: 'idProfesorCohorte', value: idProfesorCohorte});
        console.log(formData);
        $.ajax({
            url: $('#eliminarForm').attr('action'),
            type: 'POST',
            data: formData, // Incluir los datos del formulario en la solicitud
            success: function (response) {
                $('#confirmarEliminarModal').modal('hide');
                //location.reload();
                mostrarMensaje('Se elimino el profesor con exito.', 'success');
            },
            error: function () {
                $('#confirmarEliminarModal').modal('hide');
                // Mostrar mensaje de error en caso de que la solicitud falle
                mostrarMensaje('Error al eliminar el profesor.', 'danger');
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


