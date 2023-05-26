<%@ include file="common/header1.jspf"%>
<%@ include file="common/navigation1.jspf"%>
<div class="content-wrapper">
    <!-- Main content -->
    <section class="content pb-5">

    <sec:authorize access="hasAuthority('AGREGAR_WELCOME2_PRIVILEGE')">
        <a href="/welcome2">Ir a welcome 2</a>
    </sec:authorize>

    <sec:authorize access="hasAuthority('AGREGAR_WELCOME3_PRIVILEGE')">
        <a href="/welcome3">Ir a welcome 3</a>
    </sec:authorize>

    </div>
</div>
<%@ include file="common/footer1.jspf"%>
