<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="area">
    
    <sec:authorize access="hasRole('ROLE_ADMIN')">
       <a href="/welcome2">Ir a welcome 2</a>
    </sec:authorize>
        
</div>
<%@ include file="common/footer.jspf"%>
