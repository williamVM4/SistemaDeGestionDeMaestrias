<%@ include file="../common/header1.jspf"%>
<%@ include file="../common/navigation1.jspf"%>


<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12">
                    <div class="titulo-Perfil">
                        <div class="container">
                            <h1>Asignatura</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Main content -->
    <section class="content pb-5">
        <div class="container">
            <div class="alert alert-success d-flex align-items-center alert-dismissible fade d-none" role="alert">
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                <strong><i class="bi bi-check-circle"></i> Éxito!&nbsp;</strong>
            </div>
            <div class="alert alert-danger d-flex align-items-center alert-dismissible fade d-none" role="alert">
                <strong><i class="bi bi-exclamation-triangle"></i> Error!&nbsp;</strong>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <div class="row col-sm-12 d-flex justify-content-end">
                <div class="col-sm-1">
                    <button type="button" class="btn btn-outline-primary btn-sm abrirModal-btn" 
                            data-bs-toggle="modal" data-bs-target="#crearModal" 
                            data-action="agregar">Agregar</button>
                </div>
            </div>

            <br>

            <div class="pt-4">
                <div class="table-responsive">
                    <table id="asignaturaTable" class="table table-striped" >
                        <thead class="thead-light">
                            <tr>
                                <th class="text-center">Nº Correlativo</th> 
                                <th class="text-center">Codigo</th>
                                <th class="text-center">Nombre</th>
                                <th class="text-center">UV</th>
                                <th class="text-center">Ciclo</th>
                                <th class="text-center"></th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>

    <!-- Modal para agregar -->
    <div class="modal fade" id="crearModal" tabindex="-1" aria-labelledby="crearModalLabel" aria-hidden="true" data-tipo="" data-modo=''>
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="crearModalLabel"></h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id='formGuardar' accept-charset="UTF-8">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        <input type="hidden" id="asignaturaId">
                        <input type="text" id="mallaId" value="1">
                        <div class="row">
                            <div class="row">
                                <div class="form-group col-6">
                                    <input type="text" class="form-control" id="codigoAsignatura" name="codigoAsignatura" placeholder="Còdigo de la Asignatura">
                                </div>
                                <div class="form-group col-6">
                                    <input type="text" class="form-control" id="nombreAsignatura" name="nombreAsignatura" placeholder="Nombre de la Asignatura">
                                </div>
                                <div class="form-group col-6">
                                    <input type="number" class="form-control" id="uv" name="uv" placeholder="Unidades Valorativas">
                                </div>
                                <div class="form-group col-6">
                                    <input type="text" class="form-control" id="numeroCorrelativo" name="numeroCorrelativo" placeholder="Nùmero Correlativo">
                                </div>
                                <div class="form-group col-6">
                                    <input type="text" class="form-control" id="ciclo" name="ciclo" placeholder="Ciclo">
                                </div>
                                <div class="form-group col-6">
                                    <select class="form-select form-select-sm" id="idAreaC" name="idAreaC">
                                        <option value="">Seleccione una Área de conocimiento</option>
                                        <c:forEach items="${areaC}" var="elementoArea" varStatus="status">
                                            <option value="${elementoArea.idAreaConocimiento}">${elementoArea.nombreArea}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <h6>Programa de la Asignatura</h6>
                            <div class="row">
                                <div class="form-group col-6">
                                    <input type="text" class="form-control" id="duracion" name="duracion" placeholder="Duraciòn en Semanas">
                                </div>
                                <div class="form-group col-6">
                                    <input type="text" class="form-control" id="horasT" name="horasT" placeholder="Horas Teorico Semanas">
                                </div>
                                <div class="form-group col-6">
                                    <input type="text" class="form-control" id="horasP" name="horasP" placeholder="Horas Practica Semanas">
                                </div>
                                <div class="form-group col-6">
                                    <input type="text" class="form-control" id="horaCiclo" name="horaCiclo" placeholder="Horas Ciclo">
                                </div>
                                <div class="form-group col-6">
                                    <input type="text" class="form-control" id="introduccion" name="introduccion" placeholder="Introduccion">
                                </div>
                                <div class="form-group col-6">
                                    <input type="text" class="form-control" id="descipcionPrograma" name="descipcionPrograma" placeholder="Descriòn del Programa">
                                </div>
                                <div class="form-group col-6">
                                    <input type="text" class="form-control" id="objetivo" name="objetivo" placeholder="Objetivo">
                                </div>
                                <div class="form-group col-6">
                                    <input type="text" class="form-control" id="metodologia" name="metodologia" placeholder="Metodologia de Enseñanza">
                                </div>
                                <div class="form-group col-6">
                                    <input type="text" class="form-control" id="sistemaEvaluacion" name="sistemaEvaluacion" placeholder="Sistema de Evaluaciòn">
                                </div>
                                <div class="form-group col-6">
                                    <input type="text" class="form-control" id="bibliografia" name="bibliografia" placeholder="Bibliografia">
                                </div> 
                            </div>

                            <h6>Actividad de la Asignatura</h6>
                            <div class="row">
                                <div class="form-group col-6">
                                    <input type="text" class="form-control" id="actividad" name="actividad" placeholder="Nombre de la Actividad">
                                </div>
                                <div class="form-group col-6">
                                    <input type="text" class="form-control" id="ponderacion" name="ponderacion" placeholder="Ponderaciòn de la Actividad">
                                </div>
                            </div>
                            <div id="actividades-extra" class="row">
                            </div> 
                            <div class="form-group col-4">
                                <button type="button" class="btn btn-secondary" id="btnAgregarActividad">Añadir actividad</button>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button id='btnSumit' type="submit" class="btn btn-outline-success guardar-btn">Guardar</button>
                            <button type="button" class="btn btn-outline-danger" data-bs-dismiss="modal">Cancelar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal de eliminar -->
    <div class="modal fade" id="confirmarEliminarModal" tabindex="-1" aria-labelledby="confirmarEliminarLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmarEliminarLabel">Confirmar eliminación</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">

                </div>
                <div class="modal-footer">
                    <button id="eliminarAreaBtn" class="btn btn-danger">Eliminar</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                </div>
            </div>
        </div>
    </div>

    <form id="eliminarAreaForm" method="post" action="/EliminarAsignatura/{idAsignatura}">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    </form>
</div>
<%@ include file="../common/footer1.jspf"%>
<script src="${pageContext.request.contextPath}/js/asignatura.js"></script>
<style>
    .modal-dialog {
        max-width: 800px; /* Ajusta el valor según el ancho deseado */
    }

    .modal-content {
        width: 100%; /* Opcional: haz que el contenido del modal ocupe todo el ancho disponible */
    }
</style>
<script>
    // Función para añadir un nuevo campo de entrada de actividad
    function agregarActividad() {
        var container = $("#actividades-extra");

        var divA = $("<div>").addClass("form-group col-6");
        var divP = $("<div>").addClass("form-group col-6");
        //"Nombre de la Actividad""Ponderaciòn de la Actividad"
        var actividad = $("<input>").attr({
            type: "text",
            class: "form-control",
            name: "actividad[]",
            placeholder: "Nombre de la Actividad"
        });
        var ponderacion = $("<input>").attr({
            type: "text",
            class: "form-control",
            name: "ponderacion[]",
            placeholder: "Ponderaciòn de la Actividad"
        });

        divA.append(actividad);
        divP.append(ponderacion);
        container.append(divA);
        container.append(divP);
    }

    // Evento de clic para añadir actividad
    $("#btnAgregarActividad").click(agregarActividad);
</script>
