<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>
 <!-- Content -->
 <div class="content">
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center pb-4">
                <h1>Gestionar Maestrías</h1>
            </div>
        </div>
        
        <div class="row">
            <div class="col-md-12 pt-4">
                <div class="table-responsive">
                    <table class="table table-bordered table-striped small">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Escuela de Posgrado</th>
                                <th>Facultad</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${empty maestrias}">
                                <tr>
                                    <td colspan="4">No hay registros</td>
                                </tr>
                            </c:if>
                            <c:if test="${not empty maestrias}">
                                <c:forEach items="${maestrias}" var="elemento">
                                    <tr>
                                        <td>${elemento.nombreMaestria}</td>
                                        <td>${elemento.idPostgrado.nombrePostgrado}</td>
                                        <td>prueba</td>
                                        <td>Botones</td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../common/footer.jspf"%>