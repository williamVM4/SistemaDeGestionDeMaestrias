$(document).ready(function() {
    
    var formGuardarPerfilC = $('#formGuardarPerfilC'); // Almacenar referencia al formulario
    var validatorPerfilC = $('#formGuardarPerfilC').validate({
        rules: {// reglas
            perfilCoor: {
                required: true,
                maxlength: 4000
            }
        },
        messages: {// mensajes
            perfilCoor: {
                required: 'Este campo es requerido',
                maxlength: "Ha superado el máximo de caracteres permitidos"
            }
        },
        highlight: function(element) {
            $(element).addClass('is-invalid');
        },
        unhighlight: function(element) {
            $(element).removeClass('is-invalid');
        },
        errorPlacement: function(error, element) {
            if (element.attr("name") === "perfilCoor") {
                error.insertAfter(element);
            }
         },
        errorElement: 'div',
        errorClass: 'invalid-feedback',
        submitHandler: function (form) {
            event.preventDefault();//detiene el evento del envio del form 
            var formDataArray = formGuardarPerfilC.serializeArray();//tomo los datos del array
            var url = '/AgregarPerfilMaestriaCoordinador';
            formDataArray.push({ name: 'idMaestria', value: idMaestria });
            // Convertir el arreglo en un objeto
            var formData = {};
            $.map(formDataArray, function (n, i) {
                formData[n['name']] = n['value'];
            });
            //realizo el guardado mediante ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: formData,
                success: function (response) {
                    $('#crearModalPerfilCoordinador').modal('hide');  // Cierra el modal
                    mostrarMensaje(response, 'success');
                    $('#infoPerfilC').removeClass('show').addClass('d-none');
                    location.reload();
                },
                error: function (xhr, status, error) {
                    $('#crearModalPerfilCoordinador').modal('hide');  // Cierra el modal
                    var errorMessage = xhr.responseText || 'Error al actualizar la maestría.';
                    mostrarMensaje(errorMessage, 'danger');
                    location.reload();
                }
            });
        }
    });
    
$(document).on('click', '.abrirModal-perfilC', function () {
    var tipo = $(this).data('tipo');
    var idMaestria = $(this).data('id');
    var modal = $('#crearModalPerfilCoordinador');
    var tituloModal = modal.find('.modal-title');
    var form = modal.find('form');
    var btnSumit = document.getElementById('btnSumitPerfilCoordinador');
    var modalBody = modal.find('.modal-body');
    validatorPerfilC.resetForm();  // Restablecer la validación
    formGuardarPerfilC.find('.is-invalid').removeClass('is-invalid');

    if (tipo === 'editar') {
        tituloModal.text('Editar Perfil del Coordinador');
        form.attr('action', '/EditarPerfilCoordinador'); // Ajusta la URL de acción del formulario
        $.ajax({
            url: '/ObtenerMaestria/' + idMaestria,
            type: 'GET',
            success: function (response) {
                $('#perfilCoor').val(response.perfilCoor);
            },
            error: function () {
                alert('Error al obtener el perfil del coordinador.');
            }
        });
        $('#perfilCoor').removeClass('d-none'); // Muestra el campo perfilCoor
        $('#perfilCoorGroup').removeClass('d-none'); // Muestra el labelPerfilCoor
        btnSumit.textContent = 'Guardar'; // Cambia el texto del botón a 'Guardar'
        modalBody.find('.eliminar-confirmacion').addClass('d-none'); // Oculta el texto de confirmación
    } else if (tipo === 'eliminar') {
        tituloModal.text('Eliminar Perfil del Coordinador');
        form.attr('action', '/EliminarPerfilCoordinador'); // Ajusta la URL de acción del formulario
        $('#perfilCoor').addClass('d-none'); // Oculta el campo perfilCoor
        $('#perfilCoor').val(''); // Borra el valor del campo perfilCoor
        $('#perfilCoorGroup').addClass('d-none'); // Oculta el labelPerfilCoor
        btnSumit.textContent = 'Eliminar'; // Cambia el texto del botón a 'Eliminar'
        modalBody.find('.eliminar-confirmacion').removeClass('d-none'); // Muestra el texto de confirmación
    } else {
        tituloModal.text('Agregar Perfil del Coordinador');
        form.attr('action', '/AgregarPerfilCoordinador'); // Ajusta la URL de acción del formulario
        $('#idMaestria').val(idMaestria);
        $('#perfilCoor').val('');
        $('#perfilCoor').removeClass('d-none'); // Muestra el campo perfilCoor
        $('#perfilCoorGroup').removeClass('d-none'); // Muestra el labelPerfilCoor
        btnSumit.textContent = 'Guardar'; // Cambia el texto del botón a 'Guardar'
        modalBody.find('.eliminar-confirmacion').addClass('d-none'); // Oculta el texto de confirmación
    }
    modal.modal('show');
});


    
    function mostrarMensaje(mensaje, tipo) {
        var alertElement = $('.alert-' + tipo);
        alertElement.text(mensaje).addClass('show').removeClass('d-none');
        setTimeout(function() {
          alertElement.removeClass('show').addClass('d-none');
        }, 5000); // Ocultar el mensaje después de 3 segundos (ajusta el valor según tus necesidades)
      }
});

