<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="area">

<sec:authorize access="hasAuthority('AGREGAR_WELCOME2_PRIVILEGE')">
    <a href="/welcome2">Ir a welcome 2</a>
</sec:authorize>

   
<sec:authorize access="hasAuthority('AGREGAR_WELCOME3_PRIVILEGE')">
    <a href="/welcome3">Ir a welcome 3</a>
</sec:authorize>

        
</div>
<%@ include file="common/footer.jspf"%>
