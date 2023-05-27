<%@ include file="../common/header1.jspf"%>
<%@ include file="../common/navigation1.jspf"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">

    <!-- Content Header (Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12">
                    <div class="titulo-Perfil">
                        <div class="container">
                            <h1>Estudiantes</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Main content -->
    <section class="content pb-5">
        <div class="container">
            <c:if test="${not empty mensaje}">
                <div class="alert alert-success d-flex align-items-center alert-dismissible fade show" role="alert">
                    <strong><i class="bi bi-check-circle"></i> Éxito!&nbsp;</strong> ${mensaje}
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>
            <c:if test="${not empty error}">
                <div class="alert alert-danger d-flex align-items-center alert-dismissible fade show" role="alert">
                    <strong><i class="bi bi-exclamation-triangle"></i> Error!&nbsp;</strong> ${error}
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>
            <div class="row col-sm-12 d-flex justify-content-end">
                <div class="col-sm-1">
                    <button type="button" class="btn-add btn abrirModal-btn" 
                            data-bs-toggle="modal" data-bs-target="#crearModal" 
                            data-action="agregar" onclick="cargarSelect()" >Agregar</button>
                </div>
            </div>

            <div class="pt-4">
                <div class="table-responsive-md">
                    <table id="estudianteTable" class="table table-striped" style="width:100%">
                        <thead class="table-light">
                            <tr>
                                <th class="text-center">Carnet</th>
                                <th class="text-center">Nombre</th>
                                <th class="text-center">Apellidos</th>
                                <th class="text-center">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->

    <!-- Modal de agregar y editar -->
    <div class="modal fade" id="crearModal" tabindex="-1" aria-labelledby="crearModalLabel" aria-hidden="true" data-tipo="" data-modo=''>
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="crearModalLabel"></h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id='formGuardar' accept-charset="UTF-8" >

                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        
                        
                        <input type="hidden" id="estudianteId">

                        <div class="form-group">
                            <label for="carnetE" class="form-label">Carnet:</label>
                            <input type="text" class="form-control" id="carnetE" name="carnetE" maxlength="5" placeholder="Carnet" required>
                        </div>
                        
                        <div class="form-group">
                            <label for="nombresE" class="form-label">Nombres:</label>
                            <input type="text" class="form-control" id="nombresE" name="nombresE" placeholder="Nombres Estudiante" required>
                        </div>


                        <div class="form-group">
                            <label for="apellidosE" class="form-label">Apellidos:</label>
                            <input type="text" class="form-control" id="apellidosE" name="apellidosE" placeholder="Apellidos Estudiante" required>
                        </div>

                        <div class="form-group">
                            <label for="sexoE" class="form-label">Sexo:</label>
                            <select type="text" class="form-select" id="sexoE" name="sexoE" required>
                                <option value="">Seleccione una opción</option>
                                <c:forEach items="${sexos}" var="eSexo" varStatus="status">
                                    <option value="${eSexo}">${eSexo}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="fechaNacE" class="form-label">Fecha Nacimiento:</label>
                            <input type="text" class="form-control" id="fechaNacE" name="fechaNacE" placeholder="dd-mm-yyyy" maxlength="10"/>
                        </div>
                        
                        <div class="form-group">
                            <label for="nacionalidadE" class="form-label">Nacionalidad:</label>
                            <select class="form-select" id="nacionalidadE" name="nacionalidadE" required>
                                <option value="">Seleccione una opción</option>
                                <c:forEach items="${nacionalidades}" var="eNacionalidad">
                                    <option value="${eNacionalidad}">${eNacionalidad}</option>
                                </c:forEach>
                            </select>
                        </div>
                        
                        <div class="form-group">
                            <label for="" class="form-label">Pais:</label>
                            <select class="form-control" id="idPais" name="idPais" onchange="mostrarOcultarSelect()" required>
                                <option value="">Seleccione una opción</option>
                                <c:forEach items="${pais}" var="elementoPais">
                                    <option value="${elementoPais.idPais}">${elementoPais.nombrePais}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div id="group-duiE" class="form-group">
                            <label for="duiE" class="form-label">DUI:</label>
                            <input type="text" class="form-control" id="duiE" name="duiE" maxlength="10" placeholder="########-#" >
                        </div>


                        <div id="group-nitE" class="form-group">
                            <label for="nitE" class="form-label">NIT:</label>
                            <input type="text" class="form-control" id="nitE" name="nitE" maxlength="17" placeholder="#### - #### - ### - #" >
                        </div>

                        <div id="group-nupE" class="form-group">
                            <label for="nupE" class="form-label">NUP:</label>
                            <input type="text" class="form-control" id="nupE" name="nupE" maxlength="14" placeholder="############">
                        </div>

                        <div id="group-pasaporteE" class="form-group">
                            <label for="pasaporteE" class="form-label">Pasaporte:</label>
                            <input type="text" class="form-control" id="pasaporteE" name="pasaporteE" maxlength="9" placeholder="*********" >
                        </div>

                        <div id="group-docPersonalE" class="form-group">
                            <label for="docPersonalE" class="form-label">Documento Personal:</label>
                            <input type="text" class="form-control" id="docPersonalE" name="docPersonalE" maxlength="20" placeholder="####################">
                        </div>

                        <br>
                        <div class="modal-footer">
                            <button id='btnSumit' type="submit" class="btn btn-outline-success guardar-btn">Guardar</button>
                            <button type="button" class="btn btn-outline-danger" data-bs-dismiss="modal">Cancelar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
<!-- /.content-wrapper -->


<%@ include file="../common/footer1.jspf"%>

<script src="${pageContext.request.contextPath}/js/estudiantes.js"></script>

<script src="https://cdn.jsdelivr.net/npm/inputmask/dist/jquery.inputmask.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/js/estudianteSelect.js"></script>

<script>
    $(document).ready(function () {
        $('#formGuardar').submit(function (event) {
            event.preventDefault();//detiene el evento del envio del form 
            var idEstudiante = $('#estudianteId').val();//tomo la id

            var formDataArray = $(this).serializeArray();//tomo los datos del array

            var url;//valido el tipo de url si editar o crear
            if (idEstudiante) {
                url = '/ActualizarEstudiante';
                //meto la id en el campo de envio
                formDataArray.push({name: 'idEstudiante', value: idEstudiante});
            } else {
                url = '/AgregarEstudiante';
            }
            // Convertir el arreglo en un objeto
            var formData = {};
            $.map(formDataArray, function (n, i) {
                formData[n['name']] = n['value'];
            });
            
            console.log(formData);
            
            //realizo el guardado mediante ajax
            $.ajax({
                url: url,
                type: 'POST',
                data: formData,
                success: function (response) {
                    $('#crearModal').modal('hide');  // Cierra el modal
                    location.reload();  // Recarga la página
                },
                error: function (error) {
                    console.log(error);
                }
            });
        });
        // metodo para mostrar el modal segun sea si editar o nuevo registro
        $(document).on('click', '.abrirModal-btn', function () {
            var idEstudiante = $(this).data('id');
            var modal = $('#crearModal');
            var tituloModal = modal.find('.modal-title');
            var form = modal.find('form');
            var btnSumit = document.getElementById('btnSumit');
            //validator.resetForm();
            
           var docPersonal= document.getElementById("group-docPersonalE");
           var pasaporte = document.getElementById("group-pasaporteE");
           var dui = document.getElementById("group-duiE");
           var nit = document.getElementById("group-nitE");
           var nup = document.getElementById("group-nupE");  
            

            if (idEstudiante) {
                tituloModal.text('Editar Estudiante');//titulo del modal
                $.ajax({//utilizo ajax para obtener los datos
                    url: '/ObtenerEstudiante/' + idEstudiante,
                    type: 'GET',
                    success: function (response) {
                        $('#carnetE').val(response.carnetE);
                        $('#nombresE').val(response.nombresE);
                        $('#apellidosE').val(response.apellidosE);
                        $('#sexoE').val(response.sexoE);
                        //$('#fechaNacE').val(response.fechaNacE);
                        var fechaNacE = response.fechaNacE;
                        var fechaFormateada = formatearFecha(fechaNacE);
                        $('#fechaNacE').val(fechaFormateada);
                        $('#nacionalidadE').val(response.nacionalidadE);
                        $('#idPais').val(response.idPais.idPais);
                        $('#duiE').val(response.duiE);
                        $('#nitE').val(response.nitE);
                        $('#nupE').val(response.nupE);
                        $('#pasaporteE').val(response.pasaporteE);
                        $('#docPersonalE').val(response.docPersonalE); 
                        $('#estudianteId').val(idEstudiante);
                        
                        
                        //console.log(response.idPais.nombrePais);
                        console.log(response.fechaNacE);
                        
                        docPersonal.classList.remove("d-none");
                        pasaporte.classList.remove("d-none");
                        dui.classList.remove("d-none");
                        nit.classList.remove("d-none");
                        nup.classList.remove("d-none");
                        
                        if(response.idPais.nombrePais === "El Salvador"){
                            //console.log("entro en 1");
                            docPersonal.classList.add("d-none");
                            pasaporte.classList.add("d-none");
                        }else{
                            dui.classList.add("d-none");
                            nit.classList.add("d-none");
                            nup.classList.add("d-none");
                            //console.log("entro en 2");
                        }
                        
                    },
                    error: function () {
                        alert('Error al obtener los datos del estudiante.');
                    }
                });
            } else {
                // en caso de presionar el boton de nuevo solo se abrira el modal
                tituloModal.text('Agregar Estudiante');
                form.attr('action', '/AgregarEstudiante');
                
                 docPersonal.classList.add("d-none");
                 pasaporte.classList.add("d-none");
                 dui.classList.add("d-none");
                 nit.classList.add("d-none");
                 nup.classList.add("d-none");
                
                $('#carnetE').val('');
                $('#nombresE').val('');
                $('#apellidosE').val('');
                $('#sexoE').val('');
                $('#fechaNacE').val('');
                $('#nacionalidadE').val('');
                $('#idPais').val('');
                $('#duiE').val('');
                $('#nitE').val('');
                $('#nupE').val('');
                $('#pasaporteE').val('');
                $('#docPersonalE').val('');
                $('#estudianteId').val('');
            }
            modal.modal('show');
        });
    });
    
    function formatearFecha(fecha) {
    //Especifico UTCDate para tomar la fecha del sistema
        var fechaObjeto = new Date(fecha);
        var dia = fechaObjeto.getUTCDate();
        var mes = fechaObjeto.getUTCMonth() + 1;
        var anio = fechaObjeto.getUTCFullYear();
        
        //var fechaObjeto = new Date(fecha);
        //var dia = fechaObjeto.getDate();
        //var mes = fechaObjeto.getMonth() + 1;
        //var anio = fechaObjeto.getFullYear();

    if (dia < 10) {
        dia = '0' + dia;
    }
    if (mes < 10) {
        mes = '0' + mes;
    }

    return dia + '/' + mes + '/' + anio;
}
</script>

