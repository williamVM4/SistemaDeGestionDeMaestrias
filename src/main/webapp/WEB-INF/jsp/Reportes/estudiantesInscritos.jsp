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
                    <h1>N�mero de estudiantes inscritos por cohorte</h1>
                </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Main content -->
    <section class="content pb-5">
        <div class="container">

            <div class="pt-4">
                <div class="table-responsive-md">
                    <table id="estudiantesInscritosTable" class="table table-striped" style="width:100%">
                        <thead class="table-light">
                            <tr>
                                <th class="text-center">Maestr�a</th>
                                <th class="text-center">Cohorte</th>
                                <th class="text-center">Fecha de apertura de la cohorte</th>
                                <th class="text-center">N�mero de estudiantes inscritos</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div><!-- /.container-->
    </section>
    <!-- /.Main content -->
</div>
<!-- /.content-wrapper -->
  

<%@ include file="../common/footer1.jspf"%>
<script src="${pageContext.request.contextPath}/js/reporteEstudiantesInscritos.js"></script>

