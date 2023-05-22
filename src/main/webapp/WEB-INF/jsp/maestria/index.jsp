<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>
 <!-- Content -->
 <div class="content">
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center pb-4">
                <h1>Gestionar Maestr�as</h1>
            </div>
        </div>
        
        <div class="row">
            <div class="col-md-12 pt-4">
                <div class="table-responsive">
                    <table id="maestriasTable" class="table table-bordered table-striped small">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <!-- Otros campos de la maestr�a -->
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${maestrias}" var="maestria">
                                <tr>
                                    <td>${maestria.idMaestria}</td>
                                    <td>${maestria.nombreMaestria}</td>
                                    <!-- Otros campos de la maestr�a -->
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../common/footer.jspf"%>