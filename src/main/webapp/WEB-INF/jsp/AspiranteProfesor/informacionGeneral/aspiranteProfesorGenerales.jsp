<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="perfil-informacion-general">
    <div class="subtitulo-Perfil"><h3>Información General
            <span title="Editar datos" data-bs-toggle="modal" data-bs-target="#actualizarGeneralesModal" class="text-info puntero pull-right" onclick="cargarSelect()">
                <i class="fa bi-pencil-square"></i>
            </span>
        </h3>
    </div>
    <div class="overflow-auto" style="max-height: 55vh;">
        <table style="width:100%; " class="table table-bordered">
            <tbody>
                <tr>
                    <td width="20%">Carné</td>
                    <td><c:if test="${not empty aspiranteAP.codAp}">${aspiranteAP.codAp}</c:if></td>
                </tr>
                <tr>
                    <td>Nombres</td>
                    <td><c:if test="${not empty aspiranteAP.nombresAp}">${aspiranteAP.nombresAp}</c:if></td>
                </tr>
                <tr>
                    <td>Apellidos</td>
                    <td><c:if test="${not empty aspiranteAP.apellidosAp}">${aspiranteAP.apellidosAp}</c:if></td>
                </tr>
                <tr>
                    <td>Sexo</td>
                    <td><c:if test="${not empty aspiranteAP.sexoAp}">${aspiranteAP.sexoAp}</c:if></td>
                </tr>
                <tr>
                    <td>Género</td>
                    <td><c:if test="${not empty aspiranteAP.generoAp}">${aspiranteAP.generoAp}</c:if></td>
                </tr>
                <tr>
                    <td>Fecha Nacimiento</td>
                    <td><c:if test="${not empty aspiranteAP.fechaNacAp}">${aspiranteAP.fechaNacAp}</c:if></td>
                </tr>
                <tr>
                    <td>Estado Civil</td>
                    <td><c:if test="${not empty aspiranteAP.estadoCivilAp}">${aspiranteAP.estadoCivilAp}</c:if></td>
                </tr>
                <tr>
                    <td>Pais</td>
                    <td><c:if test="${not empty aspiranteAP.idPais}">${aspiranteAP.idPais}</c:if></td>
                </tr>
                <tr>
                    <td>Nacionalidad</td>
                    <td><c:if test="${not empty aspiranteAP.nacionalidadAp}">${aspiranteAP.nacionalidadAp}</c:if></td>
                </tr>
                <tr>
                    <td>DUI</td>
                    <td><c:if test="${not empty aspiranteAP.duiAp}">${aspiranteAP.duiAp}</c:if></td>
                </tr>
                <tr>
                    <td>NIT</td>
                    <td><c:if test="${not empty aspiranteAP.nitAp}">${aspiranteAP.nitAp}</c:if></td>
                </tr>
                <tr>
                    <td>NUP</td>
                    <td><c:if test="${not empty aspiranteAP.nupAp}">${aspiranteAP.nupAp}</c:if></td>
                </tr>
                <tr>
                    <td>Pasaporte</td>
                    <td><c:if test="${not empty aspiranteAP.pasaporteAp}">${aspiranteAP.pasaporteAp}</c:if></td>
                </tr>
                <tr>
                    <td>DocumentoPersonal</td>
                    <td><c:if test="${not empty aspiranteAP.docPersonalAp}">${aspiranteAP.docPersonalAp}</c:if></td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
<div style="text-align: left;">
    <!-- Modal para crear aspirantes -->
    <div class="modal fade" id="actualizarGeneralesModal" tabindex="-1" aria-labelledby="crearModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="crearModalLabel">Información General</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="/ActualizarAspiranteProfesor/${aspiranteAP.idAspiranteProfesor}" method="post" accept-charset="UTF-8">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        <div class="overflow-auto" style="max-height: 55vh;">
                            <div class="form-group">
                                <label for="apellidosAp" class="form-label">Nombre:</label>
                                <input type="text" class="form-control" id="nombresAp" name="nombresAp" value="${aspiranteAP.nombresAp}">
                            </div>
                            <div class="form-group">
                                <label for="apellidosAp" class="form-label">Apellido:</label>
                                <input type="text" class="form-control" id="apellidosAp" name="apellidosAp" value="${aspiranteAP.apellidosAp}">
                            </div>
                            <!--<div class="form-group">
                                <label for="sexoAp" class="form-label">Sexo:</label>
                                <select type="text" class="form-select" id="sexoAp" name="sexoAp" value="${aspiranteAP.sexoAp}">
                                    <option>Seleccione una opción</option>
                                    <c:forEach items="${sexos}" var="eSexo" varStatus="status">
                                        <option value="${eSexo}">${eSexo}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="generoAp" class="form-label">Genero:</label>
                                <select type="text" class="form-select" id="generoAp" name="generoAp" value="${aspiranteAP.generoAp}">
                                    <option>Seleccione una opción</option>
                                    <c:forEach items="${generos}" var="eGenero">
                                        <option value="${eGenero}">${eGenero}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="fechaNacAp" class="form-label">Fecha Nacimiento:</label>
                                <input type="text" class="form-control" id="fechaNacAp" name="fechaNacAp" placeholder="## / ## / ####" value="${aspiranteAP.fechaNacAp}">
                            </div>
                            <div class="form-group">
                                <label for="estadoCivilAp" class="form-label">Estado Civil:</label>
                                <select type="text" class="form-select" id="estadoCivilAp" name="estadoCivilAp" value="${aspiranteAp.estadoCivilAp}">
                                    <option>Seleccione una opción</option>
                                    <c:forEach items="${estadosCiviles}" var="eEstadosCiviles">
                                        <option value="${eEstadosCiviles}">${eEstadosCiviles}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="idPais" class="form-label">País:</label>
                                <select class="form-select" id="idPais" name="idPais" value="${aspiranteAp.idPais.nombrePais}" onchange="mostrarOcultarSelect()">
                                    <option>Seleccione una opción</option>
                                    <c:forEach items="${paises}" var="ePais">
                                        <option value="${ePais.idPais}">${ePais.nombrePais}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="nacionalidadAp" class="form-label">Nacionalidad:</label>
                                <select class="form-select" id="nacionalidadesAp" name="nacionalidadesAp" value="${aspiranteAp.nacionalidadesAp}">
                                    <option>Seleccione una opción</option>
                                    <c:forEach items="${nacionalidades}" var="eNacionalidad">
                                        <option value="${eNacionalidad}">${eNacionalidad}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div id="group-duiAp" class="form-group">
                                <label for="duiAp" class="form-label">DUI:</label>
                                <input type="text" class="form-control duiApMask" id="duiAp" name="duiAp" placeholder="######## - #" value="${aspiranteAP.duiAp}">
                            </div>
                            <div id="group-nitAp" class="form-group">
                                <label for="nitAp" class="form-label">NIT:</label>
                                <input type="text" class="form-control" id="nitAp" name="nitAp" placeholder="#### - #### - ### - #" value="${aspiranteAP.nitAp}">
                            </div>
                            <div id="group-nupAp" class="form-group">
                                <label for="nupAp" class="form-label">NUP:</label>
                                <input type="text" class="form-control" id="nupAp" name="nupAp" placeholder="############" value="${aspiranteAP.nupAp}">
                            </div>
                            <div id="group-pasaporteAp" class="form-group">
                                <label for="pasaporteAp" class="form-label">Pasaporte:</label>
                                <input type="text" class="form-control" id="pasaporteAp" name="pasaporteAp" placeholder="*********" value="${aspiranteAP.pasaporteAp}">
                            </div>
                            <div id="group-docPersonalAp" class="form-group">
                                <label for="docPersonalAp" class="form-label">Documento Personal:</label>
                                <input type="text" class="form-control" id="docPersonalAp" name="docPersonalAp" placeholder="####################" value="${aspiranteAP.docPersonalAp}">
                            </div>-->
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-outline-success">Guardar</button>
                            <button type="button" class="btn btn-outline-danger" data-bs-dismiss="modal">Cancelar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/inputmask/dist/jquery.inputmask.bundle.min.js"></script>
<script>
    var inputDocPersonal = document.getElementById('docPersonalAp');
    var inputPasaporte = document.getElementById("pasaporteAp");
    var inputDui = document.getElementById("duiAp");
    var inputNit = document.getElementById("nitAp");
    var inputNup = document.getElementById("nupAp");
    var fechaNacAp = document.getElementById('fechaNacAp');
    $(inputDocPersonal).inputmask('9999999999999999999999999999', {
        showMaskOnFocus: false,
        showMaskOnHover: false
    });
    $(inputPasaporte).inputmask('*********', {
        showMaskOnFocus: false,
        showMaskOnHover: false
    });
    $(inputDui).inputmask('99999999-9', {
        showMaskOnFocus: false,
        showMaskOnHover: false
    });
    $(inputNit).inputmask('9999-999999-999-9', {
        showMaskOnFocus: false,
        showMaskOnHover: false
    });
    $(inputNup).inputmask('999999999999', {
        showMaskOnFocus: false,
        showMaskOnHover: false
    });  
    $(fechaNacAp).inputmask('99/99/9999', {
        showMaskOnFocus: false,
        showMaskOnHover: false
    });

    // Calcular la fecha mínima permitida (hoy - 15 años)
    var fechaMinima = new Date();
    fechaMinima.setFullYear(fechaMinima.getFullYear() - 15);

    // Establecer la fecha mínima en el campo de fecha de nacimiento
    fechaNacAp.min = fechaMinima.toISOString().split('T')[0];

    // Agregar un evento de escucha para validar la fecha al cambiar el valor
    fechaNacAp.addEventListener('change', function() {
        // Obtener la fecha seleccionada
        var fechaSeleccionada = new Date(fechaNacAp.value);

        // Obtener la fecha actual
        var fechaActual = new Date();

        // Calcular la edad en años
        var edad = fechaActual.getFullYear() - fechaSeleccionada.getFullYear();

        // Verificar si la edad es menor que 15
        if (edad < 15) {
            // La fecha seleccionada es menor de 15 años, mostrar un mensaje de error
            alert('Debe ser mayor de 15 años.');
            // Restablecer el valor del campo de fecha de nacimiento
            fechaNacAp.value = '';
        }
    });
    function mostrarOcultarSelect() {
        var selectPais = document.getElementById("idPais");
        var docPersonal= document.getElementById("group-docPersonalAp");
        var pasaporte = document.getElementById("group-pasaporteAp");
        var dui = document.getElementById("group-duiAp");
        var nit = document.getElementById("group-nitAp");
        var nup = document.getElementById("group-nupAp");

        if (selectPais.options[selectPais.selectedIndex].text === "El Salvador") {
            docPersonal.classList.add("d-none");
            pasaporte.classList.add("d-none");
            dui.classList.remove("d-none");
            nit.classList.remove("d-none");
            nup.classList.remove("d-none");
            inputDocPersonal.value="";
            inputPasaporte.value="";
        } else {
            docPersonal.classList.remove("d-none");
            pasaporte.classList.remove("d-none");
            dui.classList.add("d-none");
            nit.classList.add("d-none");
            nup.classList.add("d-none");
            inputDui.value="";
            inputNit.value="";
            inputNup.value="";
        }
    }
    function cargarSelect() {
        var selectPais = document.getElementById("idPais");
        var docPersonal= document.getElementById("group-docPersonalAp");
        var pasaporte = document.getElementById("group-pasaporteAp");
        var dui = document.getElementById("group-duiAp");
        var nit = document.getElementById("group-nitAp");
        var nup = document.getElementById("group-nupAp");

        if (selectPais.options[selectPais.selectedIndex].text === "Seleccione una opción"){
            docPersonal.classList.add("d-none");
            pasaporte.classList.add("d-none");
            dui.classList.add("d-none");
            nit.classList.add("d-none");
            nup.classList.add("d-none");
        }else if (selectPais.options[selectPais.selectedIndex].text === "El Salvador") {
            docPersonal.classList.add("d-none");
            pasaporte.classList.add("d-none");
            dui.classList.remove("d-none");
            nit.classList.remove("d-none");
            nup.classList.remove("d-none");
        } else {
            docPersonal.classList.remove("d-none");
            pasaporte.classList.remove("d-none");
            dui.classList.add("d-none");
            nit.classList.add("d-none");
            nup.classList.add("d-none");
        }
    }
</script>
      
