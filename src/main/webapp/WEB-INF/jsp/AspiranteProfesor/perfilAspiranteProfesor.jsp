<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>
<div align="center">
    <div class="titulo-Perfil"><h3>Perfil del Aspirante a Profesor</h3></div>
    <div id="container-datos">
        <c:if test="${not empty mensaje}">
            <div class="alert alert-success d-flex align-items-center alert-dismissible fade show" role="alert">
                <strong><i class="bi bi-check-circle"></i> Éxito!  </strong>${mensaje}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="alert alert-danger d-flex align-items-center alert-dismissible fade show" role="alert">
                <strong><i class="bi bi-exclamation-triangle"></i> Error!  </strong>${error}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <div class="row">
            <div class="col-sm-2 ">
                <div class="row">
                    <div class="col-sm-12" style="text-align: center;">
                        <img style="width:128px;cursor:pointer;" src="/images/foto.jpg" id="tab_fotografia" title="Click para subir foto" onerror="" onclick="setActiveButton('tab_fotografia')">
                    </div>
                </div>
                <br>
                <div class="row">
                  <div class="col-sm-12 ">
                        <div class="list-group info ">
                            <button class="tab-perfil list-group-item list-group-item-info btn-info active" id="tab_generales" data-url="#" title="Datos generales" type="button" onclick="setActiveButton('tab_generales')">
                                Información general
                            </button>
                            <button class="tab-perfil list-group-item list-group-item-info btn-info" id="tab_documentos_personales" data-url="#" title="Educación" type="button" onclick="setActiveButton('tab_documentos_personales')">
                                Documentos
                            </button>
                            <button class="tab-perfil list-group-item list-group-item-info btn-info" id="tab_titulos_academicos" data-url="#" title="Documentos" type="button" onclick="setActiveButton('tab_titulos_academicos')">
                                Títulos
                            </button>
                            <button class="tab-perfil list-group-item list-group-item-info btn-info" id="tab_telefonos" data-url="#" title="Teléfonos" type="button" onclick="setActiveButton('tab_telefonos')">
                                Teléfonos
                            </button>
                            <button class="tab-perfil list-group-item list-group-item-info btn-info" id="tab_correos" data-url="#" title="Correos" type="button" onclick="setActiveButton('tab_correos')">
                                Correos
                            </button>
                            <button class="tab-perfil list-group-item list-group-item-info btn-info" id="tab_redes_sociales" data-url="#" title="Correos" type="button" onclick="setActiveButton('tab_redes_sociales')">
                                Redes Sociales
                            </button>
                            <button class="tab-perfil list-group-item list-group-item-info btn-info" id="tab_experiencia_laboral" data-url="#" title="Correos" type="button" onclick="setActiveButton('tab_experiencia_laboral')">
                                Experiencia Laboral
                            </button>
                        </div>
                  </div>
                </div>
            </div>
            <div class="col-sm-10">
                <div class="col-sm-12">
                    <div id="contenido-perfil" class="contenido">
                        <div id="content_tab_fotografia" class="row d-none content_tab tab_fotografia">
                            <jsp:include page="informacionGeneral/aspiranteProfesorFotografia.jsp" />
                        </div>
                        <div id="content_tab_generales" class="row content_tab tab_generales">
                            <jsp:include page="informacionGeneral/aspiranteProfesorGenerales.jsp" />
                        </div>
                        <div id="content_tab_documentos_personales" class="row d-none content_tab tab_documentos_personales">
                            <jsp:include page="informacionGeneral/aspiranteProfesorDocumentos.jsp" />
                        </div>
                        <div id="content_tab_titulos_academicos" class="row d-none content_tab tab_titulos_academicos">
                            <jsp:include page="informacionGeneral/aspiranteProfesorTitulos.jsp" />
                        </div>
                        <div id="content_tab_telefonos" class="row d-none content_tab tab_telefonos">
                            <jsp:include page="informacionGeneral/aspiranteProfesorTelefonos.jsp" />
                        </div>
                        <div id="content_tab_correos" class="row d-none content_tab tab_correos">
                            <jsp:include page="informacionGeneral/aspiranteProfesorCorreos.jsp" />
                        </div>
                        <div id="content_tab_redes_sociales" class="row d-none content_tab tab_redes_sociales">
                            <jsp:include page="informacionGeneral/aspiranteProfesorRedes.jsp" />
                        </div>
                        <div id="content_tab_experiencia_laboral" class="row d-none content_tab tab_experiencia_laboral">
                            <jsp:include page="informacionGeneral/aspiranteProfesorExperiencia.jsp" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../common/footer.jspf"%>
<script>
    // Función que se ejecuta cuando se hace clic en un botón
    function setActiveButton(buttonId) {
        // Obtener todos los botones
        var buttons = document.getElementsByClassName("tab-perfil");
        var content_tab = document.getElementsByClassName('content_tab');

        // Recorrer todos los botones y quitar la clase "active"
        for (var i = 0; i < buttons.length; i++) {
          buttons[i].classList.remove("active");
        }

        // Agregar la clase "active" al botón actual
        var currentButton = document.getElementById(buttonId);
        currentButton.classList.add("active");

        for (var i = 0; i < content_tab.length; i++) {
            content_tab[i].classList.add('d-none');
        }

        var currentContentTab = document.getElementById("content_"+buttonId);
        currentContentTab.classList.remove('d-none');
    }
</script>