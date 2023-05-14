<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="area">
    <p>Welcome</p>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
       <a href="/welcome2">Ir a welcome 2</a>
    </sec:authorize>

    <form method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <a onclick="this.parentNode.submit()" href="#">Salir</a>
    </form>
</div>
<%@ include file="common/footer.jspf"%>