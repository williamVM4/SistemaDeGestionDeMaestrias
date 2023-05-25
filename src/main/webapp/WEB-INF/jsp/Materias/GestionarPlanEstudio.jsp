<%@ include file="../common/header1.jspf"%>
<%@ include file="../common/navigation1.jspf"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-12">
          <div class="titulo-Perfil"><h3>Planes de estudio</h3></div>
        </div>
      </div>
    </div><!-- /.container-fluid -->
  </section>

  <!-- Main content -->
  <section class="content">
      <div class="container-fluid">
          <div class="row">
              <div class="col-md-2">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title">Seleccione la Maestría</h5>
                    </div>
                    <div class="card-body">
                        <ul class="list-group">
                            <c:if test="${not empty maestrias}">
                                <c:forEach var="maestria" items="${maestrias}">
                                    <li class="list-group-item">${maestria.nombreMaestria}</li>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty maestrias}">
                                <li class="list-group-item">No tienes maestrías asignadas</li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>
              <div class="col-md-10">
                  <div class="card">
                      
                  </div>
              </div>
          </div>
      </div><!-- /.container-fluid -->
  </section>
  <!-- /.content -->

</div>
  <!-- /.content-wrapper -->

<%@ include file="../common/footer1.jspf"%>