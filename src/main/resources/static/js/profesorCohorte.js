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
            var idCohorte = $('#idCohorte').val();
            var formDataArray = formGuardar.serializeArray();
            var url;
            var id = $(this).data('id');
            url = '/ContratarAspirante';
            var formData = {};
            $.map(formDataArray, function (n, i) {
                formData[n['name']] = n['value'];
            });
            $.ajax({
                url: url,
                type: 'POST',
                data: formData,
                success: function (response) {
                    $('#contratar').modal('hide');
                    mostrarMensaje('Se elimino el profesor con exito.', 'success');

                    //location.reload();
                },
                error: function (xhr, status, error) {
                    $('#crearModal').modal('hide');
                    mostrarMensaje(error, 'danger');
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
        var eliminarBtn = modal.find('#eliminarProfesorBtn');

        tituloModal.text('Confirmar eliminación');
        cuerpoModal.html('<strong>¿Estás seguro de eliminar El Profesor seleccionada?</strong><br>Ten en cuenta que se eliminarán los datos relacionados a el Profesor ' + nombre + '.');

        eliminarBtn.data('id', id);

        modal.modal('show');
    });
    //Método para enviar la solicitud de eliminar
    $(document).on('click', '#eliminarProfesorBtn', function () {
        var idProfesorCohorte = $(this).data('id');
        console.log(idProfesorCohorte);
        // Actualizar la acción del formulario con el idMaestria
        $('#eliminarForm').attr('action', '/EliminarProfesor/' + idProfesorCohorte);

        var formData = $('#eliminarForm').serializeArray();
        formData.push({name: 'idProfesor', value: idProfesorCohorte});
        console.log(formData);
        $.ajax({
            url: $('#eliminarForm').attr('action'),
            type: 'POST',
            data: formData, // Incluir los datos del formulario en la solicitud
            success: function (response) {
                $('#confirmarEliminarModal').modal('hide');
                mostrarMensaje('Se elimino el profesor con exito.', 'success');
                //location.reload();
            },
            error: function () {
                $('#confirmarEliminarModal').modal('hide');
                // Mostrar mensaje de error en caso de que la solicitud falle
                mostrarMensaje('Error al eliminar el profesor.', 'danger');
            }
        });

    });
    function mostrarMensaje(mensaje, tipo) {
        Swal.fire({
            icon: tipo,
            title: mensaje,
            showConfirmButton: true,
            allowOutsideClick: false,
            didClose: function () {
                window.location.reload();
            }
        });
    }

});


