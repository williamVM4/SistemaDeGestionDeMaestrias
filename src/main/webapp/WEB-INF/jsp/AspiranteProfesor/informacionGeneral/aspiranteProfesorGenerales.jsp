<div id="perfil-informacion-general">
    <div class="subtitulo-Perfil"><h3>Información General
            <span title="Editar datos" onclick="" class="text-info puntero pull-right">
                <i class="fa bi-pencil-square"></i>
            </span>
        </h3>
    </div>
    <div class="overflow-auto" style="max-height: 55vh;">
        <table style="width:100%; " class="table table-bordered">
            <tbody>
                <tr>
                    <td width="20%">Carné</td>
                    <td><c:if test="${not empty aspirantesAP.codAp}">${aspiranteAP.codAp}</c:if></td>
                </tr>
                <tr>
                    <td>Nombres</td>
                    <td><c:if test="${not empty aspirantesAP.nombresAp}">${aspiranteAP.nombresAp}</c:if></td>
                </tr>
                <tr>
                    <td>Apellidos</td>
                    <td><c:if test="${not empty aspirantesAP.apellidosAp}">${aspiranteAP.apellidosAp}</c:if></td>
                </tr>
                <tr>
                    <td>Sexo</td>
                    <td><c:if test="${not empty aspirantesAP.sexoAp}">${aspiranteAP.sexoAp}</c:if></td>
                </tr>
                <tr>
                    <td>Género</td>
                    <td><c:if test="${not empty aspirantesAP.generoAp}">${aspiranteAP.generoAp}</c:if></td>
                </tr>
                <tr>
                    <td>Fecha Nacimiento</td>
                    <td><c:if test="${not empty aspirantesAP.fechaNacAp}">${aspiranteAP.fechaNacAp}</c:if></td>
                </tr>
                <tr>
                    <td>Estado Civil</td>
                    <td><c:if test="${not empty aspirantesAP.estadoCivilAp}">${aspiranteAP.estadoCivilAp}</c:if></td>
                </tr>
                <tr>
                    <td>Nacionalidad</td>
                    <td><c:if test="${not empty aspirantesAP.nacionalidadAp}">${aspiranteAP.nacionalidadAp}</c:if></td>
                </tr>
                <tr>
                    <td>Pais</td>
                    <td><c:if test="${not empty aspirantesAP.idPais}">${aspiranteAP.idPais}</c:if></td>
                </tr>
                <tr>
                    <td>DUI</td>
                    <td><c:if test="${not empty aspirantesAP.duiAp}">${aspiranteAP.duiAp}</c:if></td>
                </tr>
                <tr>
                    <td>NIT</td>
                    <td><c:if test="${not empty aspirantesAP.nitAp}">${aspiranteAP.nitAp}</c:if></td>
                </tr>
                <tr>
                    <td>NUP</td>
                    <td><c:if test="${not empty aspirantesAP.nupAp}">${aspiranteAP.nupAp}</c:if></td>
                </tr>
                <tr>
                    <td>Pasaporte</td>
                    <td><c:if test="${not empty aspirantesAP.pasaporteAp}">${aspiranteAP.pasaporteAp}</c:if></td>
                </tr>
                <tr>
                    <td>DocumentoPersonal</td>
                    <td><c:if test="${not empty aspirantesAP.docPersonalAp}">${aspiranteAP.docPersonalAp}</c:if></td>
                </tr>
            </tbody>
        </table>
    </div>
</div>                   
