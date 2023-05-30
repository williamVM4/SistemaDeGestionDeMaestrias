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
                            <h1>Postulados</h1>
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

            <br>

            <div class="pt-4">
                <div class="table-responsive">
                    <table id="asignaturaTable" class="table table-striped" >
                        <thead class="thead-light">
                            <tr>
                                <th class="text-center">Nombres</th> 
                                <th class="text-center">Apellidos</th>
                                <th class="text-center">Nacionalidad</th>
                                <th class="text-center">Dui</th>
                                <th class="text-center"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${empty postulados}">
                                <tr>
                                    <td colspan="5">No hay registros</td>
                                </tr>
                            </c:if>
                            <c:if test="${not empty postulados}">
                                <c:forEach items="${postulados}" var="elemento" varStatus="status">
                                    <tr>
                                        <td width="20%">${status.index + 1}</td>
                                        <td>${elemento.nombresAp}</td>
                                        <td>${elemento.apellidosAp}</td>
                                        <td>${elemento.nombresAp}</td>
                                        <td>${elemento.apellidosAp}</td>

                                    </tr>
                                </c:forEach>
                            </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>
</div>
<%@ include file="../common/footer1.jspf"%>
<script src="${pageContext.request.contextPath}/js/profesorCohorte.js"></script>
